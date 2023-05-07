package com.laptrinhjavaweb.api.admin;

import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.dto.request.BuildingDeleteRequest;
import com.laptrinhjavaweb.dto.response.BuildingSearchResponse;
import com.laptrinhjavaweb.dto.response.ResponseDTO;
import com.laptrinhjavaweb.exception.BuildingNotFoundException;
import com.laptrinhjavaweb.service.impl.BuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@RestController("buildingAPIOfAdmin")
@RequestMapping("/api/building")
public class BuildingAPI {

    @Autowired
    private BuildingService buildingService;

//    @GetMapping()
//    public List<BuildingSearchResponse> searchBuilding(@RequestParam(required = false) Map<String, Object> fieldSearch,
//                                                        @RequestParam(required = false) List<String> types)
//            throws SQLException {
//        return buildingService.findAll(fieldSearch, types);
//    }

    @PostMapping
    public BuildingDTO createBuilding(@RequestBody(required = false) BuildingDTO buildingDTO) {
        return buildingService.save(buildingDTO);
    }


    // api load satff
    @GetMapping("/{buildingid}/staff")
    public ResponseDTO loadData() {

        return null;
    }

    // giao tòa nhà cho nhân viên quản lí
    @PostMapping("/{buildingid}/assignment")
    public Long assignmentBuilding(@RequestBody List<Long> userId,
                                   @PathVariable("buildingid") Long buildingId) {
        Long id = buildingService.assignmentBuilding(userId, buildingId);
        return id;
    }


    // update
    @PutMapping("/edit")
    public BuildingDTO updateBuilding(@RequestBody BuildingDTO buildingDTO) {

        return buildingDTO;
    }

    // delete n id
    @DeleteMapping()
    public BuildingDeleteRequest updateBuilding(@RequestBody BuildingDeleteRequest buildingDelete) {
        try {
            BuildingDeleteRequest deleteBuilding =  buildingService.removeBuilding(buildingDelete);
            return deleteBuilding;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error api delete building");
            return null;
        }
    }


}
