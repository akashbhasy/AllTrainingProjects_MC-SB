package com.ust.ems.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.ust.ems.model.Employee;

@Controller
public class EmployeeController {

	@GetMapping("/employee")
	public String hello(Model model) {
		model.addAttribute("employee",new Employee());
		return "ustemployee";
	}
	
	@GetMapping("/resultPPP")
	public String result(@ModelAttribute Employee employee) {
		return "result";
	}
	
	
}
