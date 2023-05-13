package com.laptrinhjavaweb.repository;

import com.laptrinhjavaweb.entity.AssignBuildingEntity;
import com.laptrinhjavaweb.entity.BuildingEntity;
import com.laptrinhjavaweb.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssignmentBuildingRepository extends JpaRepository<AssignBuildingEntity, Long> {

    AssignBuildingEntity findByBuildingAndUser(BuildingEntity building, UserEntity user);
}
