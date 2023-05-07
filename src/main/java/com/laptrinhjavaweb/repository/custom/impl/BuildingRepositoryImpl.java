package com.laptrinhjavaweb.repository.custom.impl;

import com.laptrinhjavaweb.buider.BuildingSearchBuilder;
import com.laptrinhjavaweb.entity.BuildingEntity;
import com.laptrinhjavaweb.repository.custom.BuildingRepositoryCustom;
import com.laptrinhjavaweb.utils.ValidateUtils;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class BuildingRepositoryImpl implements BuildingRepositoryCustom {

    // cách 3: sử dụng builder - common search
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<BuildingEntity> findBuilding(BuildingSearchBuilder builder) {
        try {
            StringBuilder sql = new StringBuilder("SELECT * from building as b ");
            sql = buildingJoinQuerry(builder, sql);
            sql.append(" where 1 = 1 ");
            sql = buildingSqlPart1WithBuilder(builder, sql);
            sql = buildingSqlPart2WithBuilder(builder, sql);
            sql.append(" group by b.id");
            Query query = entityManager.createNativeQuery(sql.toString(), BuildingEntity.class);
            return query.getResultList();
        }
        catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    private StringBuilder buildingSqlPart2WithBuilder(BuildingSearchBuilder builder, StringBuilder sql) {
        // rentare from
        if (ValidateUtils.isValid(builder.getRentAreaFrom())) {
            sql.append(" and EXISTS (select * from rentarea as ra where b.id = ra.building_id and ra.value >= " + builder.getRentAreaFrom() + ")");
        }
        // rentare to
        if (ValidateUtils.isValid(builder.getRentAreaTo())) {
            sql.append(" and EXISTS (select * from rentarea as ra where b.id = ra.building_id and ra.value <= " + builder.getRentAreaTo() + ")");
        }
        // rentprice from
        if (ValidateUtils.isValid(builder.getRentPriceFrom())) {
            sql.append(" and b.rentprice >= " + builder.getRentPriceFrom());
        }
        if (ValidateUtils.isValid(builder.getRentPriceTo())) {
            sql.append(" and b.rentprice <= " + builder.getRentPriceTo());
        }
        // types
        if (builder.getTypes() != null && builder.getTypes().size() > 0) {
            sql.append(" and (");
            String types = builder.getTypes().stream().map(item -> (" b.type like '%" + item + "%'")).collect(Collectors.joining(" or "));
            sql.append(types);
            sql.append(" )");
        }
        if (ValidateUtils.isValid(builder.getStaffID())) {
            sql.append(" and u.id = " + builder.getStaffID());
        }
        return sql;
    }



    private StringBuilder buildingJoinQuerry(BuildingSearchBuilder builder, StringBuilder sql) {
        if (ValidateUtils.isValid(builder.getRentAreaFrom()) || ValidateUtils.isValid(builder.getRentAreaFrom())) {
            sql.append(" inner join rentarea as ra on ra.id = b.id");
        }
        if (ValidateUtils.isValid(builder.getStaffID())) {
            sql.append( " inner join assignmentbuilding as ab on ab.building_id = b.id inner join user as u on ab.user_id = u.id ");
        }
        return sql;
    }

    // sử dụng java reflection
    private StringBuilder buildingSqlPart1WithBuilder(BuildingSearchBuilder builder, StringBuilder sql) {
        Field[] fields = BuildingSearchBuilder.class.getDeclaredFields();
        try {
            for (Field field : fields) {
                field.setAccessible(true);
                String fieldName = field.getName();
                if (!fieldName.equals("types") && !fieldName.startsWith("rentArea")
                        && !fieldName.equals("staffID")
                        && !fieldName.startsWith("rentPrice")) {
                    // getValue
                    Object objectValue = field.get(builder);
                    if (objectValue != null && objectValue != "") {
                        if (objectValue instanceof String) {
                            sql.append(" and b." + fieldName.toLowerCase() + " like '%" + objectValue + "%'");

                        } else if (objectValue instanceof Integer) {
                            sql.append(" and b." + fieldName.toLowerCase() + " = " + objectValue + "");
                        }
                    }
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return sql;
    }
    }
//        try {
//            StringBuilder querry = new StringBuilder("SELECT * FROM building as b ");
//            StringBuilder sqlJoin = new StringBuilder();
//            StringBuilder sqlWhere = new StringBuilder(" where 1=1 ");
//            buidSqlCommonUsingBuider(builder, sqlWhere);
//            buidSqlSpecial(builder, sqlJoin, sqlWhere);
//            querry.append(sqlJoin).append(sqlWhere).append(" GROUP BY b.id");
//            Query query = entityManager.createNativeQuery(querry.toString(), BuildingEntity.class);
//            return query.getResultList();
//        } catch (Exception e) {
//            e.printStackTrace();
//            return new ArrayList<>();
//        }
//    }
//
//    // sử dụng java reflection
//    private StringBuilder buidSqlCommonUsingBuider(BuildingSearchBuilder builder, StringBuilder sql) {
//        Field[] fields = BuildingSearchBuilder.class.getDeclaredFields();
//        try {
//            for (Field field : fields) {
//                field.setAccessible(true);
//                String fieldName = field.getName();
//                if (!fieldName.equals("types") && !fieldName.startsWith("rentarea")
//                                               && !fieldName.equals("staffID")
//                                               && !fieldName.startsWith("costrent")) {
//
//                    Object objectValue = field.get(builder);
//                    if (objectValue != null) {
//                        if (objectValue instanceof String) {
//                            sql.append(" and b." + fieldName.toLowerCase() + " like '%" + objectValue + "%'");
//
//                        } else if (objectValue instanceof Integer) {
//                            sql.append(" and b." + fieldName.toLowerCase() + " = " + objectValue + "");
//                        }
//                    }
//                }
//            }
//        } catch (IllegalAccessException  e) {
//            e.printStackTrace();
//        }
//        return sql;
//    }
//
//    private String buidSqlSpecial(BuildingSearchBuilder builder, StringBuilder sqlJoin, StringBuilder sqlWhere) {
//        Integer rentAreaFrom = builder.getRentAreaFrom();
//        Integer rentAreaTo = builder.getRentAreaTo();
//        Integer rentPriceFrom = builder.getRentPriceFrom();
//        Integer rentPriceTo = builder.getRentPriceTo();
//
//        if (!checkInputSearch.isNullInt(rentPriceFrom)) {
//            sqlJoin.append(" and b.rentprice <= " + rentPriceFrom + "");
//        }
//        if (!checkInputSearch.isNullInt(rentPriceTo)) {
//            sqlJoin.append(" and b.rentprice >= " + rentPriceTo + "");
//        }
//
//        // rentarea
//        if (!checkInputSearch.isNullInt(rentAreaFrom) || !checkInputSearch.isNullInt(rentAreaTo)) {
//            sqlJoin.append(" and EXISTS (SELECT * FROM rentarea ra WHERE ra.building_id = b.id and ");
//            if (!checkInputSearch.isNullInt(rentAreaFrom)) {
//                sqlJoin.append(" ra.value >= " + rentAreaFrom + "");
//            }
//            if (!checkInputSearch.isNullInt(rentAreaTo)) {
//                sqlJoin.append(" ra.value <= " + rentAreaTo + "");
//            }
//            sqlJoin.append(")");
//        }
//
//        // search staff
//        Integer staff = builder.getStaffID();
//        if (staff != null) {
//            sqlJoin.append(
//                    " inner join assignmentbuilding as ab on b.id = ab.building_id inner join user as u  on ab.user_id = u.id  ");
//            sqlWhere.append(" and u.id = '" + staff + "'");
//        }
//
//        // types //
//        if (builder.getTypes() != null && !builder.getTypes().isEmpty()) {
////            sqlJoin.append(" inner join buildingrenttype as br on b.id = br.buildingid \r\n"
////                    + " inner join renttype as rt on br.renttypeid = rt.id ");
//            sqlJoin.append(" and (");
//            String types = builder.getTypes().stream().map(item -> " b.type LIKE '%" + item + "%'").collect(Collectors.joining(" or "));
//            sqlJoin.append(types);
//            sqlJoin.append(")");
//        }
//        return sqlJoin.toString();
//    }
//}