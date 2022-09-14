package com.gfg.gfgsample.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gfg.gfgsample.service.GeekEmployeeService;

@Controller
@RequestMapping("mvc")
public class GeekEmployeeMvcController {
	
	private final GeekEmployeeService geekEmployeeService;
	
	public GeekEmployeeMvcController(GeekEmployeeService geekEmployeeService) {
		this.geekEmployeeService = geekEmployeeService;
	}
	
	@GetMapping("geekemployees")
	public String getGeekEmployees(Model model) {
		model.addAttribute("geekemployees", geekEmployeeService.findAll());
		return "geekemployee-list";
	}

}
