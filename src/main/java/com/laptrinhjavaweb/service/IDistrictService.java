package com.laptrinhjavaweb.service;

import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.dto.response.DistrictResponse;

import java.util.List;

public interface IDistrictService {

    List<DistrictResponse> getAllDistrict();  // hiển thị
    List<DistrictResponse> getDistrictByBuilding(BuildingDTO buildingDTO);  // search building by district


}
