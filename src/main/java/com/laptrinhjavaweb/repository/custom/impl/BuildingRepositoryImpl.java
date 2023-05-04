package com.laptrinhjavaweb.repository.custom.impl;

import com.laptrinhjavaweb.buider.BuildingSearchBuilder;
import com.laptrinhjavaweb.entity.BuildingEntity;
import com.laptrinhjavaweb.repository.custom.BuildingRepositoryCustom;
import com.laptrinhjavaweb.utils.checkInputSearch;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.lang.reflect.Field;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class BuildingRepositoryImpl implements BuildingRepositoryCustom {

    // cách 3: sử dụng builder - common search
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<BuildingEntity> findBuilding(BuildingSearchBuilder builder) throws SQLException {
        StringBuilder querry = new StringBuilder("SELECT * FROM building as b ");
        StringBuilder sqlJoin = new StringBuilder();
        StringBuilder sqlWhere = new StringBuilder(" where 1=1 ");
        buidSqlCommonUsingBuider(builder, sqlWhere);
        buidSqlSpecial(builder, sqlJoin, sqlWhere);
        querry.append(sqlJoin).append(sqlWhere).append(" GROUP BY b.id");
        Query query = entityManager.createNativeQuery(querry.toString(), BuildingEntity.class);
        return query.getResultList();
    }

    // sử dụng java reflection
    private StringBuilder buidSqlCommonUsingBuider(BuildingSearchBuilder builder, StringBuilder sql) {
        try {
            Field fields[] = BuildingSearchBuilder.class.getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                String fieldName = field.getName();
                if (!fieldName.equals("types") && !fieldName.startsWith("rentarea")
                                               && !fieldName.equals("staffID")
                                               && !fieldName.startsWith("costrent")) {

                    Object objectValue = field.get(builder);
                    if (objectValue != null) {
                        if (field.getType().getName().equals("java.lang.String")) { // tìm kiếm theo like
                            sql.append(" and b." + fieldName.toLowerCase() + " like '%" + objectValue + "%'");
                        } else if (field.getType().getName().equals("java.lang.Integer")) { // tìm kiếm chính xác
                            sql.append(" and b." + fieldName.toLowerCase() + " = " + objectValue + "");
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sql;
    }

    private String buidSqlSpecial(BuildingSearchBuilder builder, StringBuilder sqlJoin, StringBuilder sqlWhere) {
        Integer rentAreaFrom = builder.getRentAreaFrom();
        Integer rentAreaTo = builder.getRentAreaTo();
        Integer rentPriceFrom = builder.getRentPriceFrom();
        Integer rentPriceTo = builder.getRentPriceTo();

        if (!checkInputSearch.isNullInt(rentPriceFrom)) {
            sqlJoin.append(" and b.rentprice <= " + rentPriceFrom + "");
        }
        if (!checkInputSearch.isNullInt(rentPriceTo)) {
            sqlJoin.append(" and b.rentprice >= " + rentPriceTo + "");
        }

        // rentarea
        if (!checkInputSearch.isNullInt(rentAreaFrom) || !checkInputSearch.isNullInt(rentAreaTo)) {
            sqlJoin.append(" and EXISTS (SELECT * FROM rentarea ra WHERE ra.building_id = b.id and ");
            if (!checkInputSearch.isNullInt(rentAreaFrom)) {
                sqlJoin.append(" ra.value >= " + rentAreaFrom + "");
            }
            if (!checkInputSearch.isNullInt(rentAreaTo)) {
                sqlJoin.append(" ra.value <= " + rentAreaTo + "");
            }
            sqlJoin.append(")");
        }

        // search staff
        Integer staff = builder.getStaffID();
        if (staff != null) {
            sqlJoin.append(
                    " inner join assignmentbuilding as ab on b.id = ab.building_id inner join user as u  on ab.user_id = u.id  ");
            sqlWhere.append(" and u.id = '" + staff + "'");
        }

        // types //
        if (builder.getTypes() != null && !builder.getTypes().isEmpty()) {
//            sqlJoin.append(" inner join buildingrenttype as br on b.id = br.buildingid \r\n"
//                    + " inner join renttype as rt on br.renttypeid = rt.id ");
            sqlJoin.append(" and (");
            String types = builder.getTypes().stream().map(item -> " b.type LIKE '%" + item + "%'").collect(Collectors.joining(" or "));
            sqlJoin.append(types);
            sqlJoin.append(")");
        }
        return sqlJoin.toString();
    }
}