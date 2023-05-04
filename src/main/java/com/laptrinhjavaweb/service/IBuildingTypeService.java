package com.laptrinhjavaweb.service;


import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.dto.response.BuildingTypesResponse;

import java.util.List;

public interface IBuildingTypeService {
    List<BuildingTypesResponse> getAll();  // hiển thị all type building
    List<BuildingTypesResponse> getAllByBuilding(BuildingDTO buildingDTO); // checked =
}
