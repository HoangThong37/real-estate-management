package com.laptrinhjavaweb.service.impl;

import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.dto.response.DistrictResponse;
import com.laptrinhjavaweb.enums.DistrictsEnum;
import com.laptrinhjavaweb.service.IDistrictService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DistrictService implements IDistrictService {

    @Override
    public List<DistrictResponse> getAllDistrict() {
        List<DistrictResponse> result = new ArrayList<>();
        for (DistrictsEnum item : DistrictsEnum.values()) {
             DistrictResponse response = new DistrictResponse();
             response.setCode(item.name());
             response.setName(item.getDistrictValue());
             result.add(response);
        }
        return result;
    }

    @Override
    public List<DistrictResponse> getDistrictByBuilding(BuildingDTO buildingDTO) {
        List<DistrictResponse> result = new ArrayList<>();
        try {
            for (DistrictsEnum item : DistrictsEnum.values()) {
                DistrictResponse response = new DistrictResponse();
                response.setCode(item.name());
                response.setName(item.getDistrictValue());
                if (buildingDTO.getDistrict() != null && buildingDTO.getDistrict().equals(item.name())) {
                    response.setSelected("selected");
                    //result.add(response);
                }
                result.add(response);
            }
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error districtService");
            return new ArrayList<>();
        }
    }
}
