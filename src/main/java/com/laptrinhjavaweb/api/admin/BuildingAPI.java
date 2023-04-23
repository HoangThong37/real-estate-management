package com.laptrinhjavaweb.api.admin;

import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.service.impl.BuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("buildingAPIOfAdmin")
public class BuildingAPI {

    @Autowired
    private BuildingService buildingService;

    @PostMapping("/api/building")
    public BuildingDTO createBuilding(@RequestBody BuildingDTO buildingDTO) {
        buildingService.save(buildingDTO);
        return buildingDTO;
    }
}
