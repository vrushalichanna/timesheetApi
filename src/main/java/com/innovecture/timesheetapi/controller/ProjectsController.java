package com.innovecture.timesheetapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.innovecture.timesheetapi.model.Projects;
import com.innovecture.timesheetapi.services.ProjectsService;
@CrossOrigin
@RestController
public class ProjectsController {

	@Autowired
	private ProjectsService projectService;
	
	@GetMapping("/projects")
	public ResponseEntity<List<Projects>> getProjects(){
		return new ResponseEntity<>(projectService.getProjects(),HttpStatus.OK);
	}
	
	@GetMapping("/projects/{id}")
	public ResponseEntity<Projects> getProject(@PathVariable Long id){
		if(this.projectService.findById(id).isPresent()) {
			return new ResponseEntity<>(this.projectService.findById(id).get(),HttpStatus.OK);
		}else {
			return new ResponseEntity<Projects>(HttpStatus.NO_CONTENT);
		}
	}
	
	@PostMapping("/projects")
	public ResponseEntity<Projects> saveProjects(@RequestBody Projects project){
		return new ResponseEntity<>(this.projectService.saveProject(project),HttpStatus.OK);
	}
	
	@DeleteMapping("/projects/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable Long id){
		this.projectService.deleteById(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
