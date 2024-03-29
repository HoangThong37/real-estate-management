package com.laptrinhjavaweb.repository.custom.impl;

import com.laptrinhjavaweb.entity.UserEntity;
import com.laptrinhjavaweb.repository.custom.UserRepositoryCustom;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<UserEntity> getAllStaff() {
        StringBuilder sql = new StringBuilder("Select * from user as u inner join user_role as ur on u.id = ur.user_id ");
        sql.append(" where ur.role_id = 2 and u.status = 1 ");

        Query query = entityManager.createNativeQuery(sql.toString(), UserEntity.class);
        return query.getResultList();
    }

    @Override
    public List<UserEntity> getAllStaffByBuilding(Long buildingId) { // lấy tất cả nhân viên giữ tòa nhà (a,b,c)
        StringBuilder sql = new StringBuilder("select * from user as u inner join assignmentbuilding as ab on u.id = ab.user_id ");
        sql.append(" where ab.building_id = ").append(buildingId);

        Query query = entityManager.createNativeQuery(sql.toString(), UserEntity.class);
        return query.getResultList();
    }

    // 'phân trang' Pageable pageable
    @Override
    public List<UserEntity> getAllUsers(Pageable pageable) {

        StringBuilder sql = new StringBuilder(buildQueryFilter())
                .append(" LIMIT ").append(pageable.getPageSize()).append("\n")
                .append(" OFFSET ").append(pageable.getOffset());
        System.out.println("Final query: " + sql.toString());

        Query query = entityManager.createNativeQuery(sql.toString(), UserEntity.class);
        return query.getResultList();
    }

    @Override
    public int countTotalItem() {
        String sql = buildQueryFilter();
        Query query = entityManager.createNativeQuery(sql.toString());
        return query.getResultList().size();
    }

    private String buildQueryFilter() {
        String sql = "SELECT * FROM users u WHERE u.status = 1";
        return sql;
    }
}