package com.laptrinhjavaweb.service;


import com.laptrinhjavaweb.dto.BuildingDTO;

import java.util.List;


public interface IBuildingService {
    List<BuildingDTO> findAll();
    void save(BuildingDTO buildingDTO);
}
