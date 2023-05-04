package com.laptrinhjavaweb.service;


import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.dto.request.BuildingDeleteRequest;
import com.laptrinhjavaweb.dto.response.BuildingSearchResponse;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;


public interface IBuildingService {
    List<BuildingDTO> findAll();
    void save(BuildingDTO buildingDTO);

    Map<String, String> getBuildingTypes();
    List<BuildingSearchResponse> getBuildingList(Map<String, Object> fieldSearch, List<String> types) throws SQLException;

    Long assignmentBuilding(List<Long> userId, Long buildingId);
    BuildingDeleteRequest removeBuilding(BuildingDeleteRequest buildingDelete);
}
