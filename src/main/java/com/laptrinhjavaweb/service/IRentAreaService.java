package com.laptrinhjavaweb.service;

import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.dto.RentAreaDTO;
import com.laptrinhjavaweb.entity.BuildingEntity;

import java.util.List;

public interface IRentAreaService {

    //void saveAllRentAreaByBuilding(List<RentAreaDTO> listRentArea, BuildingDTO buildingDTO);


    void saveAllRentArea(List<RentAreaDTO> listRentAreaDTO, BuildingEntity buildingEntity);
}

