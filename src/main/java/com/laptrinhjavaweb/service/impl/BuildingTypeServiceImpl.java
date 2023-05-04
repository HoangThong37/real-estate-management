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
        List<BuildingTypesResponse> result = new ArrayList<>();
        for (BuildingTypesEnum item : BuildingTypesEnum.values()) {
            BuildingTypesResponse types = new BuildingTypesResponse();
            types.setCode(item.name());
            types.setName(item.getBuildingTypeValue());
            if (buildingDTO.getTypes() != null) {
                for (String check : buildingDTO.getTypes()) {
                    if (check.equals(item.name())) { // ktra xem có tòa nhà chưa
                        types.setChecked("checked");
                    }
                }
            }
            result.add(types);
        }
        return result;
    }
}
