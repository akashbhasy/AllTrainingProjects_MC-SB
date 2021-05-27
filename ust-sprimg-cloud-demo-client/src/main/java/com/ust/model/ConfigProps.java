package com.ust.model;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
@ConfigurationProperties("project")
public class ConfigProps {

	private String projectID;
	private String projectName;
	private String projectLocation;
	private String projectcost;
	private String projectStatus;
}
