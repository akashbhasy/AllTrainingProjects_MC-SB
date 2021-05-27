package com.pms.ust.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndecController {

	@RequestMapping("/")
	public String index() {
		return"index";
	}
	
	@RequestMapping("/tufail")
	public String kapoor() {
		return"Kapoor";
	}
}
