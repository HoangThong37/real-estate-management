package com.laptrinhjavaweb.repository.custom;

import com.laptrinhjavaweb.buider.BuildingSearchBuilder;
import com.laptrinhjavaweb.entity.BuildingEntity;

import java.util.List;

public interface BuildingRepositoryCustom {

    // sử dụng buider
    List<BuildingEntity> findBuilding(BuildingSearchBuilder builder);
}
