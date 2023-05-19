package com.laptrinhjavaweb.api.admin;

import com.laptrinhjavaweb.dto.BuildingDTO;
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
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/building")
public class BuildingAPI {

    @Autowired
    private BuildingService buildingService;

    @Autowired
    private UserService userService;

/*    @PostMapping
    public BuildingDTO createBuilding(@RequestBody(required = false) BuildingDTO buildingDTO) {
        return buildingService.createBuilding(buildingDTO);
    }*/

    // api load satff
    @GetMapping("/{id}/staff")
    public List<StaffResponseDTO> loadStaffByBuilding(@PathVariable("id") Long id) {
        return userService.finAllStaffByBuilding(id);
    }

    // assigment building to staff
    // test
    @PostMapping("/{id}/assignment")
    public List<Long> assignmentBuilding(@RequestBody(required = false)  List<Long> staffIds
                                        ,@PathVariable("id") Long buildingId) {
        buildingService.assignmentBuilding(staffIds, buildingId);
        return staffIds;
    }


    // update building
    @PutMapping
    public BuildingDTO updateBuilding(@RequestBody(required = false) BuildingDTO buildingDTO) {
        BuildingDTO buildingUpdate = buildingService.updateBuilding(buildingDTO);

        return buildingUpdate;
    }

    // delete building n
    /*@DeleteMapping
    public ResponseEntity<Void> deleteBuilding(@RequestBody BuildingDeleteRequest buildingDeleteRequest) throws NotFoundException {
        buildingService.removeBuilding(buildingDeleteRequest);
        return ResponseEntity.noContent().build();
    }*/

   /*    @DeleteMapping
    public ResponseEntity<Void> deleteBuildings(@RequestBody long[] ids) { // @RequestBody
        if (ids.length > 0) {
            buildingService.delete(ids);
        }
        return ResponseEntity.noContent().build();
    }*/

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
        // set result list
        // set total items
        return buildingService.pageBuilding(pageable, buildingSearch);
    }


}