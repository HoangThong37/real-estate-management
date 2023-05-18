package com.laptrinhjavaweb.service;


import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.dto.request.AssignmentBuildingRequest;
import com.laptrinhjavaweb.dto.request.BuildingDeleteRequest;
import com.laptrinhjavaweb.dto.request.BuildingSearchRequest;
import com.laptrinhjavaweb.dto.response.BuildingSearchResponse;
import javassist.NotFoundException;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;


public interface IBuildingService {
    List<BuildingDTO> findAll();
    BuildingDTO findBuildingById(Long id);
    Map<String, String> getBuildingTypes();

    void assignmentBuilding(AssignmentBuildingRequest assignmentBuildingRequest, Long buildingId);
    //void assignmentBuilding(List<Long> listUserId, Long buildingId);
    List<BuildingSearchResponse> findAll(BuildingSearchRequest buildingSearchRequest);
    BuildingDTO updateBuilding(BuildingDTO buildingDTO);

    // test
    List<BuildingSearchResponse> pageBuilding(Pageable pageable, BuildingSearchRequest buildingSearchRequest);
    int getTotalItems();
    //void delete(long[] ids);
    void delete(List<Long> buildingIds) throws NotFoundException;
    void removeBuilding(BuildingDeleteRequest buildingDeleteRequest) throws NotFoundException;

    //BuildingDTO createBuilding(BuildingDTO buildingDTO);




}
