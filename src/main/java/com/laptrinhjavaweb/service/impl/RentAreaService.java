package com.laptrinhjavaweb.service.impl;

import com.laptrinhjavaweb.converter.BuildingConverter;
import com.laptrinhjavaweb.converter.RentAreaConverter;
import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.dto.RentAreaDTO;
import com.laptrinhjavaweb.entity.BuildingEntity;
import com.laptrinhjavaweb.entity.RentareaEntity;
import com.laptrinhjavaweb.repository.BuildingRepository;
import com.laptrinhjavaweb.repository.RentAreaRepository;
import com.laptrinhjavaweb.repository.custom.RentAreaRepositoryCustom;
import com.laptrinhjavaweb.service.IRentAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RentAreaService implements IRentAreaService {

    @Autowired
    private BuildingConverter buildingConverter;

    @Autowired
    private RentAreaConverter rentAreaConverter;

    @Autowired
    private RentAreaRepository rentAreaRepository;

    @Autowired
    private BuildingRepository buildingRepository;

    @Override
    public void saveAllRentArea(List<RentAreaDTO> listRentAreaDTO, BuildingEntity buildingEntity) {
        // convert dto -> entity -> save

        List<RentareaEntity> listRentAreaEntity = new ArrayList<>();

            for (RentAreaDTO item : listRentAreaDTO) {
                RentareaEntity rentareaEntity = rentAreaConverter.convertToEntity(item);
                listRentAreaEntity.add(rentareaEntity);
            }

        BuildingEntity building = buildingRepository.findById(buildingEntity.getId()).get();
        rentAreaRepository.saveRentAreas(listRentAreaEntity, building);
    }
}






