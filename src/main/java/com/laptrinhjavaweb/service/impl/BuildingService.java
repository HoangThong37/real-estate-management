package com.laptrinhjavaweb.service.impl;

import com.laptrinhjavaweb.buider.BuildingSearchBuilder;
import com.laptrinhjavaweb.converter.BuildingConverter;
import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.dto.request.BuildingDeleteRequest;
import com.laptrinhjavaweb.dto.response.BuildingSearchResponse;
import com.laptrinhjavaweb.entity.BuildingEntity;
import com.laptrinhjavaweb.enums.BuildingTypesEnum;
import com.laptrinhjavaweb.repository.BuildingRepository;
import com.laptrinhjavaweb.repository.custom.BuildingRepositoryCustom;
import com.laptrinhjavaweb.service.IBuildingService;
import com.laptrinhjavaweb.utils.MapUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BuildingService implements IBuildingService {

	@Autowired
	private BuildingRepositoryCustom buildingRepoCustom;
	
	@Autowired
	private BuildingRepository buildingRepository;
	
	@Autowired
	private BuildingConverter buildingConverter;


	@Override
	public List<BuildingDTO> findAll() {
		List<BuildingDTO> result = new ArrayList<>();
		List<BuildingEntity> buildingEntities = buildingRepository.findAll();
		for(BuildingEntity item : buildingEntities) {
			BuildingDTO buildingDTO = buildingConverter.convertToDTO(item);
			result.add(buildingDTO);
		}
		return result;
	}

	@Override
	@Transactional
	public void save(BuildingDTO buildingDTO) {
        BuildingEntity buildingEntity = buildingConverter.convertToEntity(buildingDTO);
        buildingRepository.save(buildingEntity);
	}

	@Override
	public BuildingDTO findBuildingById(Long id) {
        if (id != null) {
            BuildingEntity buildingEntity = buildingRepository.findById(id);
            BuildingDTO buildingDTO = buildingConverter.convertToDTO(buildingEntity);
            return buildingDTO;
        }
        return null;
    }

	@Override
	public Map<String, String> getBuildingTypes() {
		Map<String, String> buildingTypes = new HashMap<>();
		for (BuildingTypesEnum item :BuildingTypesEnum.values()) {
			buildingTypes.put(item.toString(), item.getBuildingTypeValue());
		}
		return buildingTypes;
	}

	// cách buider
	@Override
	public List<BuildingSearchResponse> getBuildingList(Map<String, Object> requestParams, List<String> types) throws SQLException {
		List<BuildingSearchResponse> results = new ArrayList<>();
		BuildingSearchBuilder buildingSearchBuilder = convertParamToBuilder(requestParams, types);
		List<BuildingEntity> buildingEntities = buildingRepoCustom.findBuilding(buildingSearchBuilder);

		for (BuildingEntity item : buildingEntities) {
			BuildingSearchResponse response = buildingConverter.convertEntityToBuildingResponse(item);
			results.add(response);
		}
		return results;
	}

	private BuildingSearchBuilder convertParamToBuilder(Map<String, Object> requestParams, List<String> types) {
		try {
			BuildingSearchBuilder result = new BuildingSearchBuilder.Builder()
					.setName(MapUtils.getObject(requestParams, "name", String.class))
					.setFloorArea(MapUtils.getObject(requestParams, "floorarea", Integer.class))
					.setDistrict(MapUtils.getObject(requestParams, "districtid", Integer.class))
					.setWard(MapUtils.getObject(requestParams, "ward", String.class))
					.setStreet(MapUtils.getObject(requestParams, "street", String.class))
					.setNumberOfBasement(MapUtils.getObject(requestParams, "numberofbasement", Integer.class))
					.setDirection(MapUtils.getObject(requestParams, "direction", String.class))
					.setLevel(MapUtils.getObject(requestParams, "level", String.class))
					.setRentAreaFrom(MapUtils.getObject(requestParams, "rentareafrom", Integer.class))
					.setRentAreaTo(MapUtils.getObject(requestParams, "rentareato", Integer.class))
					.setRentPriceFrom(MapUtils.getObject(requestParams, "rentpricefrom", Integer.class))
					.setRentPriceTo(MapUtils.getObject(requestParams, "rentpriceto", Integer.class))
					.setManagerName(MapUtils.getObject(requestParams, "managername", String.class))
					.setStaffID(MapUtils.getObject(requestParams, "staffid", Integer.class))
					.setManagerPhone(MapUtils.getObject(requestParams, "managerphone", String.class))
					.setTypes(types)
					.build();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public BuildingDeleteRequest removeBuilding(BuildingDeleteRequest buildingDelete) {
		if (buildingDelete != null) {
			//buildingRepository.remove(buildingDelete);
		}
		return null;
	}

	@Override
	public Long assignmentBuilding(List<Long> userId, Long buildingId) {
		return null;
	}


}
