package com.laptrinhjavaweb.repository;

import com.laptrinhjavaweb.entity.BuildingEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface BuildingRepository extends JpaRepository<BuildingEntity, Long> {
    //List<BuildingEntity> findAllByDistrict();
}
