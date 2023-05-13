package com.laptrinhjavaweb.converter;
import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.dto.RentAreaDTO;
import com.laptrinhjavaweb.entity.RentareaEntity;
import com.laptrinhjavaweb.repository.BuildingRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RentAreaConverter {
	
	@Autowired
	private ModelMapper modelMapper;

    @Autowired
    private BuildingConverter buildingConverter;

    @Autowired
    private BuildingRepository buildingRepository;

    // convert entity -> dto
	public RentAreaDTO convertToDto(RentareaEntity entity) {
        RentAreaDTO result = modelMapper.map(entity, RentAreaDTO.class);
        return result;
    }

    // convert dto -> entity
    public RentareaEntity convertToEntity(RentAreaDTO dto) {
        RentareaEntity result = modelMapper.map(dto, RentareaEntity.class);
        result.setBuilding(buildingRepository.findById(dto.getBuildingid()));
        return result;
    }

    public List<RentAreaDTO> convertRentAreaDto(Long buildingIdAfter,BuildingDTO buildingDTO) {
        List<RentAreaDTO> result = new ArrayList<>();

        BuildingDTO buildingDTORentArea  = buildingConverter.convertToDTOCustom(buildingRepository.findById(buildingDTO.getId()));
        if (buildingDTORentArea.getRentArea().equals(buildingDTO.getRentArea())) {
            return new ArrayList<>();
        }

        String[] rentArea = buildingDTO.getRentArea() != null ? buildingDTO.getRentArea().trim().split(",") : null;
        if (rentArea != null) {
            for (String item : rentArea) {
                RentAreaDTO rentAreaDTO = new RentAreaDTO();
                rentAreaDTO.setValue(Integer.parseInt(item));
                rentAreaDTO.setBuildingid(buildingIdAfter);
                result.add(rentAreaDTO);
            }
            return result;
        } else {
            return new ArrayList<>();
        }
    }
}
