package com.innovecture.timesheetapi.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="projects")
public class Projects implements Serializable{

	private static final long serialVersionUID = 4911589601824853193L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long projectsId;
	private String name;
	private String description;
	
	
	public Projects() {}

	public Long getProjectsId() {
		return projectsId;
	}

	public void setProjectsId(Long projectsId) {
		this.projectsId = projectsId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
