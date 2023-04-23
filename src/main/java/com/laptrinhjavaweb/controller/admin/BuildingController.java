package com.laptrinhjavaweb.controller.admin;

import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.entity.UserEntity;
import com.laptrinhjavaweb.service.impl.BuildingService;
import com.laptrinhjavaweb.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller(value = "buildingControllerOfAdmin")
public class BuildingController {

	@Autowired
	private BuildingService buildingService;

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/admin/building-list", method = RequestMethod.GET)
	public ModelAndView buildingList(@ModelAttribute("modelSearch") BuildingDTO buildingDTO) {
		ModelAndView mav = new ModelAndView("admin/building/list");
		// mav.addObject("buildingModelSearch", new BuildingDTO());
		mav.addObject("modelSearch", buildingDTO); // gửi đi và nhận vào đều là modelSearch
		mav.addObject("buildings", buildingService.findAll());
		mav.addObject("staffmaps", userService.getStaffMaps());
		return mav;
	}

	@RequestMapping(value = "/admin/building-edit", method = RequestMethod.GET)
	public ModelAndView buildingEdit() {
		ModelAndView mav = new ModelAndView("admin/building/edit");
		mav.addObject("buildingModel", new BuildingDTO());
		return mav;
	}
}
