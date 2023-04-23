package com.laptrinhjavaweb.converter;

import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.dto.RoleDTO;
import com.laptrinhjavaweb.entity.BuildingEntity;
import com.laptrinhjavaweb.entity.RoleEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BuildingConverter {
	
	@Autowired
	private ModelMapper modelMapper;
	
	public BuildingDTO convertToDto(BuildingEntity entity) {
		BuildingDTO result = modelMapper.map(entity, BuildingDTO.class);
        return result;
    }

    public BuildingEntity convertToEntity(BuildingDTO dto) {
        BuildingEntity result = modelMapper.map(dto, BuildingEntity.class);
        return result;
    }
}
