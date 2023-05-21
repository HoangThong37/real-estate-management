package com.laptrinhjavaweb.repository.custom;

import com.laptrinhjavaweb.buider.BuildingSearchBuilder;
import com.laptrinhjavaweb.entity.BuildingEntity;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BuildingRepositoryCustom {

    // sử dụng buider
    List<BuildingEntity> findBuilding(BuildingSearchBuilder builder);

    List<BuildingEntity> pageBuilding(Pageable pageable, BuildingSearchBuilder builder);

}
