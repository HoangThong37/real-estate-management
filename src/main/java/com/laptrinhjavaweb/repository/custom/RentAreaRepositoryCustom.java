package com.laptrinhjavaweb.repository.custom;

import com.laptrinhjavaweb.entity.BuildingEntity;
import com.laptrinhjavaweb.entity.RentareaEntity;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RentAreaRepositoryCustom  {

    //void saveAllByBuilding(List<RentareaEntity> listRentArea, BuildingEntity buildingEntity);

    List<RentareaEntity> findByRentArea(Long id);

    void saveRentAreas(List<RentareaEntity> listRentAreaEntity, BuildingEntity buildingEntity);
}
