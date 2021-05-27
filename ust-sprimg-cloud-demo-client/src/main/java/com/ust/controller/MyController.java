package com.ust.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ust.model.ConfigProps;
@RestController
public class MyController {
	@Autowired
	ConfigProps configprop;
	@RequestMapping("/displayproperties")
	public String displayProperties() {
		String msg="projectID"+configprop.getProjectID()+"prohectName"+configprop.getProjectName()+"Location"+configprop.getProjectLocation()+"Cost"+configprop.getProjectcost()+"Status"+configprop.getProjectStatus();
		return msg;
	}

}
