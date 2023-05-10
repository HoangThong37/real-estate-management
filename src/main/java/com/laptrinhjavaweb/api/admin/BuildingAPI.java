package com.laptrinhjavaweb.api.admin;

import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.dto.request.BuildingDeleteRequest;
import com.laptrinhjavaweb.dto.response.BuildingSearchResponse;
import com.laptrinhjavaweb.dto.response.ResponseDTO;
import com.laptrinhjavaweb.dto.response.StaffResponseDTO;
import com.laptrinhjavaweb.exception.BuildingNotFoundException;
import com.laptrinhjavaweb.service.impl.BuildingService;
import com.laptrinhjavaweb.service.impl.UserService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
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

    // giao tòa nhà cho nhân viên quản lí
    @PostMapping("/{buildingid}/assignment")
    public Long assignmentBuilding(@RequestBody List<Long> userId,
                                   @PathVariable("buildingid") Long buildingId) {
        Long id = buildingService.assignmentBuilding(userId, buildingId);
        return id;
    }


    // update building
    @PutMapping
    public BuildingDTO updateBuilding(@RequestBody(required = false) BuildingDTO buildingDTO) {
        buildingService.updateBuilding(buildingDTO);

        return buildingDTO;
    }

    // delete building n
    @DeleteMapping
    public BuildingDeleteRequest deleteBuilding(@RequestBody BuildingDeleteRequest buildingDeleteRequest) throws NotFoundException {
        buildingService.removeBuilding(buildingDeleteRequest);
        return buildingDeleteRequest;
    }

}
