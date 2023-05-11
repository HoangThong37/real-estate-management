package com.laptrinhjavaweb.service.impl;

import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.dto.response.BuildingTypesResponse;
import com.laptrinhjavaweb.enums.BuildingTypesEnum;
import com.laptrinhjavaweb.service.IBuildingTypeService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BuildingTypeServiceImpl implements IBuildingTypeService {

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

    @Override
    public List<BuildingTypesResponse> getAllByBuilding(BuildingDTO buildingDTO) {
        //System.out.println(" In building type service : " + buildingDTO.getTypes());// TANG_TRET, NGUYEN_CAN
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
    }
}
