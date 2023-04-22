package com.laptrinhjavaweb.controller.admin;

import com.laptrinhjavaweb.dto.BuildingDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller(value = "buildingControllerOfAdmin")
public class BuildingController {

	@RequestMapping(value = "/admin/building-list", method = RequestMethod.GET)
	public ModelAndView buildingList(@ModelAttribute("modelSearch") BuildingDTO buildingDTO) {
		ModelAndView mav = new ModelAndView("admin/building/list");
		// mav.addObject("buildingModelSearch", new BuildingDTO());
		mav.addObject("modelSearch", buildingDTO); // gửi đi và nhận vào đều là modelSearch
		return mav;
	}

	@RequestMapping(value = "/admin/building-edit", method = RequestMethod.GET)
	public ModelAndView buildingEdit() {
		ModelAndView mav = new ModelAndView("admin/building/edit");
		mav.addObject("buildingModel", new BuildingDTO());
		return mav;
	}
}
