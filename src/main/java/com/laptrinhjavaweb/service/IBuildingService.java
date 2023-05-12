package com.laptrinhjavaweb.service;


import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.dto.request.BuildingDeleteRequest;
import com.laptrinhjavaweb.dto.request.BuildingSearchRequest;
import com.laptrinhjavaweb.dto.response.BuildingSearchResponse;
import javassist.NotFoundException;

import java.util.List;
import java.util.Map;


public interface IBuildingService {
    List<BuildingDTO> findAll();
    BuildingDTO createBuilding(BuildingDTO buildingDTO);
    BuildingDTO findBuildingById(Long id);
    Map<String, String> getBuildingTypes();

    Long assignmentBuilding(List<Long> userId, Long buildingId);
    void removeBuilding(BuildingDeleteRequest buildingDeleteRequest) throws NotFoundException;
    List<BuildingSearchResponse> findAll(BuildingSearchRequest buildingSearchRequest);
    BuildingDTO updateBuilding(BuildingDTO buildingDTO);

}
