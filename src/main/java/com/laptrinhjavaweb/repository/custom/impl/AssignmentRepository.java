//package com.laptrinhjavaweb.repository.custom.impl;
//
//import com.laptrinhjavaweb.entity.AssignBuildingEntity;
//import com.laptrinhjavaweb.entity.BuildingEntity;
//import com.laptrinhjavaweb.entity.UserEntity;
//import com.laptrinhjavaweb.repository.custom.AssignmentRepositoryCustom;
//import org.springframework.stereotype.Repository;
//
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//import javax.persistence.Query;
//
//@Repository
//public class AssignmentRepository implements AssignmentRepositoryCustom {
//
//    @PersistenceContext
//    private EntityManager entityManager;
//
//    @Override
//    public int deleteAssignment(BuildingEntity building, UserEntity user) {
//
//        StringBuilder sql = new StringBuilder("DELETE FROM assignmentbuilding WHERE ");
//        sql.append(" building_id = ").append(building).append(" AND user_id = ").append(user);
//
//        Query query = entityManager.createNativeQuery(sql.toString(), AssignBuildingEntity.class);
//        return query.executeUpdate();
//    }
//}
