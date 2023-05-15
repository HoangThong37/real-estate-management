package com.laptrinhjavaweb.repository.custom;

import com.laptrinhjavaweb.buider.BuildingSearchBuilder;
import com.laptrinhjavaweb.entity.BuildingEntity;
import com.laptrinhjavaweb.entity.UserEntity;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BuildingRepositoryCustom {

    // sử dụng buider
    List<BuildingEntity> findBuilding(BuildingSearchBuilder builder);
    void assignmentBuilding(List<UserEntity> userEntities, BuildingEntity buildingEntity);

    List<BuildingEntity> pageBuilding(Pageable pageable, BuildingSearchBuilder builder);


}
