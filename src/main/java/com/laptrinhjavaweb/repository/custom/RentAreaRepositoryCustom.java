package com.laptrinhjavaweb.repository.custom;

import com.laptrinhjavaweb.entity.BuildingEntity;
import com.laptrinhjavaweb.entity.RentareaEntity;

import java.util.List;

public interface RentAreaRepositoryCustom  {

    void saveAllByBuilding(List<RentareaEntity> listRentArea, BuildingEntity buildingEntity);
}
