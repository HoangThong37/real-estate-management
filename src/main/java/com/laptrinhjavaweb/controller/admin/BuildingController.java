package com.laptrinhjavaweb.controller.admin;

import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.dto.request.BuildingSearchRequest;
import com.laptrinhjavaweb.entity.UserEntity;
import com.laptrinhjavaweb.service.IBuildingTypeService;
import com.laptrinhjavaweb.service.impl.BuildingService;
import com.laptrinhjavaweb.service.impl.DistrictService;
import com.laptrinhjavaweb.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/admin")
public class BuildingController {

	@Autowired
	private BuildingService buildingService;

	@Autowired
	private IBuildingTypeService buildingTypeService;

	@Autowired
	private UserService userService;

	@Autowired
	private DistrictService districtService;

	@GetMapping("/building-list")
	public ModelAndView buildingList(@ModelAttribute("modelSearch") BuildingSearchRequest request,
									 @RequestParam(required = false) Map<String, Object> params,
									 @RequestParam(required = false) List<String> types) {
		try {
			ModelAndView mav = new ModelAndView("admin/building/list");
			mav.addObject("buildings", buildingService.getBuildingList(params, types));
			mav.addObject("staffmaps", userService.getAllStaff());
			mav.addObject("districts", districtService.getAllDistrict());
			mav.addObject("buildingTypes", buildingTypeService.getAll());
			return mav;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@GetMapping("/building-edit")
	public ModelAndView buildingEdit() {
		ModelAndView mav = new ModelAndView("admin/building/edit");
		mav.addObject("buildingModel", new BuildingDTO());
		return mav;
	}
}
