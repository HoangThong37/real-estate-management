package com.laptrinhjavaweb.repository;

import com.laptrinhjavaweb.entity.BuildingEntity;
import com.laptrinhjavaweb.entity.RentareaEntity;
import com.laptrinhjavaweb.repository.custom.RentAreaRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RentAreaRepository extends RentAreaRepositoryCustom, JpaRepository<RentareaEntity, Long>  {
        List<RentareaEntity> findByBuilding(BuildingEntity buildingEntity);
        void deleteByBuilding_Id(Long id);
        void deleteByBuilding_IdIn(List<Long> id);


}
