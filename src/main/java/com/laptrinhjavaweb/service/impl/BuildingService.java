package com.laptrinhjavaweb.service.impl;

import com.laptrinhjavaweb.buider.BuildingSearchBuilder;
import com.laptrinhjavaweb.converter.BuildingConverter;
import com.laptrinhjavaweb.converter.RentAreaConverter;
import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.dto.RentAreaDTO;
import com.laptrinhjavaweb.dto.request.AssignmentBuildingRequest;
import com.laptrinhjavaweb.dto.request.BuildingDeleteRequest;
import com.laptrinhjavaweb.dto.request.BuildingSearchRequest;
import com.laptrinhjavaweb.dto.response.BuildingSearchResponse;
import com.laptrinhjavaweb.entity.AssignBuildingEntity;
import com.laptrinhjavaweb.entity.BuildingEntity;
import com.laptrinhjavaweb.entity.RentareaEntity;
import org.apache.tomcat.util.codec.binary.Base64;
import com.laptrinhjavaweb.entity.UserEntity;
import com.laptrinhjavaweb.enums.BuildingTypesEnum;
import com.laptrinhjavaweb.repository.AssignmentBuildingRepository;
import com.laptrinhjavaweb.repository.BuildingRepository;

import com.laptrinhjavaweb.repository.RentAreaRepository;
import com.laptrinhjavaweb.repository.UserRepository;
import com.laptrinhjavaweb.service.IBuildingService;
import com.laptrinhjavaweb.utils.UploadFileUtils;
import javassist.NotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.PersistenceContext;
import java.io.File;
import java.util.*;

@Service
public class BuildingService implements IBuildingService {

	@Autowired
	private RentAreaRepository rentAreaRepository;

	@Autowired
	private RentAreaService rentAreaService;

	@Autowired
	private RentAreaConverter rentAreaConverter;

	@Autowired
	private BuildingRepository buildingRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private AssignmentBuildingRepository assignmentRepo;

	@Autowired
	private BuildingConverter buildingConverter;

	@Autowired
	private UploadFileUtils uploadFileUtils;

	@Override
	public List<BuildingDTO> findAll() {
		List<BuildingDTO> result = new ArrayList<>();
		List<BuildingEntity> buildingEntities = buildingRepository.findAll();
		for (BuildingEntity item : buildingEntities) {
			BuildingDTO buildingDTO = buildingConverter.convertToDTO(item);
			result.add(buildingDTO);
		}
		return result;
	}

/*	@Override
	@Transactional
	public BuildingDTO createBuilding(BuildingDTO buildingDTO) {
		BuildingEntity buildingEntity = buildingConverter.convertToEntityCustom(buildingDTO);
		BuildingEntity building = buildingRepository.save(buildingEntity);

		if (buildingDTO.getRentArea() != null) {
			List<RentAreaDTO> listRentAreaDTO = rentAreaConverter.convertToRentArea(buildingEntity.getId(), buildingDTO);
			rentAreaService.saveAllRentArea(listRentAreaDTO, building);
		}
		BuildingDTO buildingDTOAfter = buildingConverter.convertToDTOCustom(building);
		return buildingDTOAfter;
	}*/

	@Override
	@Transactional
	public BuildingDTO updateBuilding(BuildingDTO buildingDTO) {
		BuildingEntity buildingEntity = buildingConverter.convertToEntityCustom(buildingDTO); // trả ra cho dto
		BuildingEntity building = buildingRepository.save(buildingEntity);

		try {
			if (buildingDTO.getId() != null) {
				rentAreaRepository.deleteByBuilding_Id(buildingDTO.getId());
			}
			if (buildingDTO.getRentArea() != null) {
				List<RentAreaDTO> listRentAreaDTO = rentAreaConverter.convertToRentArea(building.getId(), buildingDTO);
				rentAreaService.saveAllRentArea(listRentAreaDTO, building);
			}
            BuildingEntity foundBuilding = buildingRepository.findById(buildingEntity.getId()).get();

			buildingEntity.setImage(foundBuilding.getImage());
			saveThumbnail(buildingDTO, buildingEntity);   // save thumbnail

			BuildingDTO buildingdto = buildingConverter.convertToDTOCustom(building);
			return buildingdto;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error building update in service");
		}
		return null;
	}
	@Override
	public BuildingDTO findBuildingById(Long id) {
		if (id != null) {
			BuildingEntity buildingEntity = buildingRepository.findById(id).get();
			//BuildingEntity buildingEntity = buildingRepository.findOne(id);
			BuildingDTO buildingDTO = buildingConverter.convertToDTOCustom(buildingEntity);
			return buildingDTO;
		}
		return null;
	}

	@Override
	public Map<String, String> getBuildingTypes() {
		Map<String, String> buildingTypes = new HashMap<>();
		for (BuildingTypesEnum item : BuildingTypesEnum.values()) {
			buildingTypes.put(item.toString(), item.getBuildingTypeValue());
		}
		return buildingTypes;
	}



	@Override
	public List<BuildingSearchResponse> findAll(BuildingSearchRequest buildingSearchRequest) {
		List<BuildingSearchResponse> result = new ArrayList<>();
		BuildingSearchBuilder buildingSearchBuilder = convertParamToBuilder(buildingSearchRequest);
		List<BuildingEntity> buildingEntities = buildingRepository.findBuilding(buildingSearchBuilder);
		for (BuildingEntity item : buildingEntities) {
			result.add(buildingConverter.convertEntityToBuildingResponse(item));
		}
		return result;
	}

	private BuildingSearchBuilder convertParamToBuilder(BuildingSearchRequest buildingSearchRequest) {
		try {
			BuildingSearchBuilder result = new BuildingSearchBuilder.Builder()
					.setName(buildingSearchRequest.getName())
					.setFloorArea(buildingSearchRequest.getFloorArea())
					.setDistrict(buildingSearchRequest.getDistrictCode())
					.setWard(buildingSearchRequest.getWard())
					.setStreet(buildingSearchRequest.getStreet())
					.setNumberOfBasement(buildingSearchRequest.getNumberOfBasement())
					.setDirection(buildingSearchRequest.getDirection())
					.setLevel(buildingSearchRequest.getLevel())
					.setRentAreaFrom(buildingSearchRequest.getRentAreaFrom())
					.setRentAreaTo(buildingSearchRequest.getRentAreaTo())
					.setRentPriceFrom(buildingSearchRequest.getRentPriceFrom())
					.setRentPriceTo(buildingSearchRequest.getRentPriceTo())
					.setManagerName(buildingSearchRequest.getManagerName())
					.setManagerPhone(buildingSearchRequest.getManagerPhone())
					.setStaffID(buildingSearchRequest.getStaffId())
					.setTypes(buildingSearchRequest.getTypes())
					.build();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	// test
	@Override
	@Transactional
	public void assignmentBuilding(AssignmentBuildingRequest assignmentBuildingRequest, Long buildingID) {
		List<UserEntity> userEntities = new ArrayList<>();
		for (Integer item : assignmentBuildingRequest.getStaffIds()) {
			userEntities.add(userRepository.findOneById(item.longValue()));
		}
		BuildingEntity buildingEntity = buildingRepository.findById(buildingID).get();
		//BuildingEntity buildingEntity = buildingRepository.findOne(buildingID);
		buildingRepository.assignmentBuilding(userEntities, buildingEntity);

	}

	@Override
	@Transactional
	public void removeBuilding(BuildingDeleteRequest buildingDeleteRequest) throws NotFoundException {
		if (buildingDeleteRequest.getBuildingId() != null) {
			buildingRepository.deleteByIdIn(buildingDeleteRequest.getBuildingId());
		}
	}

	// paging building
	@Override
	public List<BuildingSearchResponse> pageBuilding(Pageable pageable, BuildingSearchRequest buildingSearchRequest) {
		List<BuildingSearchResponse> result = new ArrayList<>();
		BuildingSearchBuilder buildingSearchBuilder = convertParamToBuilder(buildingSearchRequest);
		List<BuildingEntity> buildingEntities = buildingRepository.pageBuilding(pageable, buildingSearchBuilder);
		for (BuildingEntity item : buildingEntities) {
			result.add(buildingConverter.convertEntityToBuildingResponse(item));
		}
		return result;
	}

	@Override
	public int getTotalItems() {
		return (int) buildingRepository.countAllBuilding();
	}

	// update
	@Override
	@Transactional
	public void delete(List<Long> buildingIds) {
	    try {
			if (!buildingIds.isEmpty()) {
				Long count = buildingRepository.countByIdIn(buildingIds);

				if (count != buildingIds.size()) {
					throw new NotFoundException("Building not found!");
				}
				// remove buildings
				buildingRepository.deleteByIdIn(buildingIds);
			}
		} catch (NotFoundException e) {
			e.printStackTrace();
		}
	}

    private void saveThumbnail(BuildingDTO buildingDTO, BuildingEntity buildingEntity) {
        String path = "/building/" + buildingDTO.getImageName();
        if (null != buildingDTO.getImageBase64()) {
            if (null != buildingEntity.getImage()) {
                if (!path.equals(buildingEntity.getImage())) {
                    File file = new File("C:/checkfile/version1" + buildingEntity.getImage());
                    file.delete();
                }
            }
            byte[] bytes = Base64.decodeBase64(buildingDTO.getImageBase64().getBytes());
            uploadFileUtils.writeOrUpdate(path, bytes);
            buildingEntity.setImage(path);
        }
    }

//	delete no cascade
/*	for (Long item : buildingIds) {
        BuildingEntity buildingDelete = buildingRepository.findById(item).get();

        if (buildingDelete.getRentareas().size() > 0) {
            rentAreaRepository.deleteByBuilding_Id(buildingDelete.getId());
        }
        if (buildingDelete.getAssignBuildings().size() > 0) {
            assignmentRepo.deleteByBuilding_Id(buildingDelete.getId());
        }
        buildingRepository.deleteById(buildingDelete.getId());
    }*/




}