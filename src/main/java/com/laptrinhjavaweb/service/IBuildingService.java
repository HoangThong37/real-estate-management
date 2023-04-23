package com.laptrinhjavaweb.service;


import com.laptrinhjavaweb.dto.BuildingDTO;

import java.util.List;
import java.util.Map;

public interface IBuildingService {
    List<BuildingDTO> findAll();
    void save(BuildingDTO buildingDTO);

}
