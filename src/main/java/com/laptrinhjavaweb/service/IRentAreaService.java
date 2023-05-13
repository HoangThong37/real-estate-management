package com.laptrinhjavaweb.service;

import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.dto.RentAreaDTO;

import java.util.List;

public interface IRentAreaService {

    void saveAllRentAreaByBuilding(List<RentAreaDTO> listRentArea, BuildingDTO buildingDTO);

}

