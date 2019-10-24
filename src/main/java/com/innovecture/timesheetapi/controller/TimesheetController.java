package com.innovecture.timesheetapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.innovecture.timesheetapi.model.Timesheet;
import com.innovecture.timesheetapi.services.TimesheetService;

@RestController
public class TimesheetController {

	@Autowired
	private TimesheetService timesheetService;
	
	@GetMapping("/timesheet")
	public ResponseEntity<List<Timesheet>> getTimesheets(){
		return new ResponseEntity<>(timesheetService.getTimesheets(),HttpStatus.OK);
	}
	
	@GetMapping("/timesheet/{id}")
	public ResponseEntity<Timesheet> getTimesheetById(@PathVariable Long id) {
		 if(timesheetService.getTimesheetById(id).isPresent()) {
			 return new ResponseEntity<>(timesheetService.getTimesheetById(id).get(),HttpStatus.OK);
		 }else {
			 return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		 }
	}
	
	@PostMapping("/timesheet")
	public ResponseEntity<Timesheet> saveTimesheet(@RequestBody Timesheet timesheet){
		return new ResponseEntity<>(timesheetService.saveTimesheet(timesheet),HttpStatus.OK);
	}
	
	@DeleteMapping("/timesheet/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable Long id){
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
}
