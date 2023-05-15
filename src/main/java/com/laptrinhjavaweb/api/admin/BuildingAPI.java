package com.laptrinhjavaweb.api.admin;

import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.dto.request.AssignmentBuildingRequest;
import com.laptrinhjavaweb.dto.request.BuildingDeleteRequest;
import com.laptrinhjavaweb.dto.request.BuildingSearchRequest;
import com.laptrinhjavaweb.dto.response.BuildingSearchResponse;
import com.laptrinhjavaweb.dto.response.ResponseDTO;
import com.laptrinhjavaweb.dto.response.StaffResponseDTO;
import com.laptrinhjavaweb.exception.BuildingNotFoundException;
import com.laptrinhjavaweb.service.impl.BuildingService;
import com.laptrinhjavaweb.service.impl.UserService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/building")
public class BuildingAPI {

    @Autowired
    private BuildingService buildingService;

    @Autowired
    private UserService userService;

    @PostMapping
    public BuildingDTO createBuilding(@RequestBody(required = false) BuildingDTO buildingDTO) {
        return buildingService.createBuilding(buildingDTO);
    }

    // api load satff
    @GetMapping("/{id}/staff")
    public List<StaffResponseDTO> loadStaffByBuilding(@PathVariable("id") Long id) {
        return userService.finAllStaffByBuilding(id);
    }

    // assigment building to staff
    // test
    @PostMapping("/{id}/assignment")
    public AssignmentBuildingRequest assignmentBuilding(@RequestBody(required = false) AssignmentBuildingRequest assignmentBuilding
            ,@PathVariable("id") Long buildingId) {
        buildingService.assignmentBuilding(assignmentBuilding, buildingId);
        return assignmentBuilding;
    }


    // update building
    @PutMapping
    public BuildingDTO updateBuilding(@RequestBody(required = false) BuildingDTO buildingDTO) {
        BuildingDTO buildingUpdate = buildingService.updateBuilding(buildingDTO);

        return buildingUpdate;
    }

    // delete building n
    @DeleteMapping
    public BuildingDeleteRequest deleteBuilding(@RequestBody BuildingDeleteRequest buildingDeleteRequest) throws NotFoundException {
        buildingService.removeBuilding(buildingDeleteRequest);
        return buildingDeleteRequest;
    }

    // page
    @PostMapping("/page")
    public List<BuildingSearchResponse> pageBuilding(Pageable pageable, BuildingSearchRequest buildingSearch) {
        // set result list
        // set total items
        return buildingService.pageBuilding(pageable, buildingSearch);
    }


}
