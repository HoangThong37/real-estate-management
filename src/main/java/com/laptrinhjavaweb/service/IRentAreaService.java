package com.laptrinhjavaweb.service;

import com.laptrinhjavaweb.dto.RentAreaDTO;
import com.laptrinhjavaweb.entity.BuildingEntity;

import java.util.List;

public interface IRentAreaService {

    void saveAllRentArea(List<RentAreaDTO> listRentAreaDTO, BuildingEntity buildingEntity);
}

