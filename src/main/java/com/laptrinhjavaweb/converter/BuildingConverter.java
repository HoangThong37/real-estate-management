package com.laptrinhjavaweb.converter;

import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.dto.RoleDTO;
import com.laptrinhjavaweb.dto.response.BuildingSearchResponse;
import com.laptrinhjavaweb.entity.BuildingEntity;
import com.laptrinhjavaweb.entity.RoleEntity;
import com.laptrinhjavaweb.enums.DistrictsEnum;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BuildingConverter {

    @Autowired
    private ModelMapper modelMapper;

    public BuildingDTO convertToDTO(BuildingEntity entity) {
        BuildingDTO dto = modelMapper.map(entity, BuildingDTO.class);
        return dto;
    }

    public BuildingEntity convertToEntity(BuildingDTO dto) {
        BuildingEntity entity = modelMapper.map(dto, BuildingEntity.class);
        return entity;
    }

    // convert Entity-to-BuildingSearchResponse
    public BuildingSearchResponse convertEntityToBuildingResponse(BuildingEntity entity) {
        String districtName = "";
        for (DistrictsEnum item : DistrictsEnum.values()) {
            districtName = item.getDistrictValue();
            break;
        }
        String address = entity.getStreet() + " - " + entity.getWard() + " - " + districtName;
        BuildingSearchResponse response = modelMapper.map(entity, BuildingSearchResponse.class);
        response.setAddress(address);
        return response;
    }


    // convert to buildingSearchRequest



}