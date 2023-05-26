package com.laptrinhjavaweb.service.impl;

import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.dto.response.BuildingTypesResponse;
import com.laptrinhjavaweb.enums.BuildingTypesEnum;
import com.laptrinhjavaweb.service.IBuildingTypeService;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class BuildingTypeService implements IBuildingTypeService {

    @Override
    public List<BuildingTypesResponse> getAll() {
        List<BuildingTypesResponse> result = new ArrayList<>();
        for (BuildingTypesEnum item : BuildingTypesEnum.values()) {
            BuildingTypesResponse types = new BuildingTypesResponse();
            types.setCode(item.name());
            types.setName(item.getBuildingTypeValue());
            result.add(types);
        }
        return result;
    }

    // apply java 8
    @Override
    public List<BuildingTypesResponse> getAllByBuilding(BuildingDTO buildingDTO) {
        List<String> types = Optional.ofNullable(buildingDTO.getTypes()).orElse(Collections.emptyList());
        return Arrays.stream(BuildingTypesEnum.values())
                .map(item -> {
                    BuildingTypesResponse response = new BuildingTypesResponse();
                    response.setCode(item.name());
                    response.setName(item.getBuildingTypeValue());
                    if (types.contains(item.name())) {
                        response.setChecked("checked");
                    }
                    return response;
                })
                .collect(Collectors.toList());
    }

/*    @Override
    public List<BuildingTypesResponse> getAllByBuilding(BuildingDTO buildingDTO) {
        List<BuildingTypesResponse> result = new ArrayList<>();
        for (BuildingTypesEnum item : BuildingTypesEnum.values()) {    // TANG_TRET, NGUYEN_CAN, noi_that
            BuildingTypesResponse types = new BuildingTypesResponse(); // code, name, checked
            types.setCode(item.name());
            types.setName(item.getBuildingTypeValue());
            if (buildingDTO.getTypes() != null) {
                for (String check : buildingDTO.getTypes()) {
                    if (check.equals(item.name())) {
                        types.setChecked("checked");
                    }
                }
            }
            result.add(types);
        }
        return result;
    }*/
}
