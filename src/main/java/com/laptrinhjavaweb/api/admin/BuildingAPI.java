package com.laptrinhjavaweb.api.admin;

import com.laptrinhjavaweb.dto.BuildingDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("buildingAPIOfAdmin")
//@RequestMapping("/api/building")
public class BuildingAPI {

    @PostMapping("/api/building")
    public BuildingDTO createBuilding(@RequestBody BuildingDTO buildingDTO) {

        return buildingDTO;
    }
}

// ->