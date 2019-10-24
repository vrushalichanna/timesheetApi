package com.innovecture.timesheetapi.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.innovecture.timesheetapi.model.Projects;
import com.innovecture.timesheetapi.repo.ProjectRepo;

@Service		
public class ProjectsService {

	@Autowired
	private ProjectRepo projectRepo;
	
	public List<Projects> getProjects(){
		List<Projects> list = new ArrayList<>();
		this.projectRepo.findAll().forEach(a->list.add(a));
		return list;
	}
	
	public Optional<Projects> findById(Long id) {
		return projectRepo.findById(id);
	}
	
	public Projects saveProject(Projects project) {
		this.projectRepo.save(project);
		return project;
	}
	
	public void deleteById(Long id) {
		this.projectRepo.deleteById(id);
	}
}
