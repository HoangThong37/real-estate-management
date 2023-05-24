package com.laptrinhjavaweb.controller.admin;

import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.dto.request.BuildingSearchRequest;

import com.laptrinhjavaweb.dto.response.BuildingSearchResponse;
import com.laptrinhjavaweb.service.IBuildingTypeService;
import com.laptrinhjavaweb.service.impl.BuildingService;
import com.laptrinhjavaweb.service.impl.DistrictService;
import com.laptrinhjavaweb.service.impl.UserService;

import com.laptrinhjavaweb.utils.DisplayTagUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


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
	public ModelAndView buildingList(HttpServletRequest request,
									  @ModelAttribute("modelSearch") BuildingSearchRequest buildingSearch) {
		try {
			ModelAndView mav = new ModelAndView("admin/building/list");

			DisplayTagUtils.of(request, buildingSearch);
			Pageable pageable = PageRequest.of(buildingSearch.getPage() - 1, buildingSearch.getMaxPageItems());
			List<BuildingSearchResponse> pageBuilding = buildingService.pageBuilding(pageable, buildingSearch);

            buildingSearch.setListResult(pageBuilding);
            buildingSearch.setTotalItems(buildingService.getTotalItems()); // set tổng số item trong

			mav.addObject("buildings", buildingSearch);
			mav.addObject("staffmaps", userService.getAllStaff());
			mav.addObject("districts", districtService.getAllDistrict());
			mav.addObject("buildingTypes", buildingTypeService.getAll());
			 // mav.addObject("buildings", buildingService.findAll(buildingSearch));

			return mav;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@GetMapping("/building-edit")
	public ModelAndView buildingEdit(@RequestParam(name = "buildingid", required = false) Long id) {
		ModelAndView mav = new ModelAndView("admin/building/edit");

		if (id != null) {  // edit
			mav.addObject("modelBuildingEdit", buildingService.findBuildingById(id));
			mav.addObject("buildingTypes", buildingTypeService.getAllByBuilding(buildingService.findBuildingById(id)));
			mav.addObject("districts", districtService.getDistrictByBuilding(buildingService.findBuildingById(id)));
		}
		else { // add
			mav.addObject("modelBuildingEdit", new BuildingDTO());
			mav.addObject("buildingTypes", buildingTypeService.getAll());
			mav.addObject("districts", districtService.getAllDistrict());
		}
		return mav;
	}
}
