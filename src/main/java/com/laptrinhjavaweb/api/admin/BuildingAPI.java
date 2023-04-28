package com.laptrinhjavaweb.api.admin;

import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.dto.response.ResponseDTO;
import com.laptrinhjavaweb.service.impl.BuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController("buildingAPIOfAdmin")
@RequestMapping("/api/building")
public class BuildingAPI {

    @Autowired
    private BuildingService buildingService;

    @PostMapping
    public BuildingDTO createBuilding(@RequestBody BuildingDTO buildingDTO) {
        buildingService.save(buildingDTO);
        return buildingDTO;
    }

    // api load satff
    @GetMapping("/{buildingid}/staffs")
    public ResponseDTO loadData() {

        return null;
    }


}
