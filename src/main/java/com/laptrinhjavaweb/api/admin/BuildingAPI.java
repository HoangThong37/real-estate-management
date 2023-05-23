package com.laptrinhjavaweb.api.admin;

import com.laptrinhjavaweb.dto.AssignmentDTO;
import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.dto.request.BuildingSearchRequest;
import com.laptrinhjavaweb.dto.response.BuildingSearchResponse;
import com.laptrinhjavaweb.dto.response.StaffResponseDTO;
import com.laptrinhjavaweb.service.impl.BuildingService;
import com.laptrinhjavaweb.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/building")
public class BuildingAPI {

    @Autowired
    private BuildingService buildingService;

    @Autowired
    private UserService userService;

    // api load satff
    @GetMapping("/{id}/staff")
    public List<StaffResponseDTO> loadStaffByBuilding(@PathVariable("id") Long id) {
        return userService.finAllStaffByBuilding(id);
    }

    // assigment building to staff
/*    @PostMapping("/{id}/assignment")
    public Long assignmentBuilding(@RequestBody(required = false) List<Long> staffIds
                                        ,@PathVariable("id") Long buildingId) {
        buildingService.assignmentBuilding(staffIds, buildingId);
        return buildingId;
    }*/

    @PostMapping("/assignment")
    public Long assignmentBuilding(@RequestBody(required = false) AssignmentDTO assignmentDTO) {
        buildingService.assignmentBuilding(assignmentDTO);
        return assignmentDTO.getBuildingid();
        //return null;
    }

    // update building
    @PutMapping
    public BuildingDTO updateBuilding(@RequestBody(required = false) BuildingDTO buildingDTO) {
        BuildingDTO buildingUpdate = buildingService.updateBuilding(buildingDTO);

        return buildingUpdate;
    }


    @DeleteMapping
    public ResponseEntity<Void> deleteBuildings(@RequestBody List<Long> ids) { // @RequestBody
        if (ids.size() != 0) {
            buildingService.delete(ids);
        }
        return ResponseEntity.noContent().build();
    }

    // page
    @PostMapping("/page")
    public List<BuildingSearchResponse> pageBuilding(Pageable pageable, BuildingSearchRequest buildingSearch) {
        return buildingService.pageBuilding(pageable, buildingSearch);
    }

}