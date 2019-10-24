package com.innovecture.timesheetapi.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.innovecture.timesheetapi.model.Timesheet;
import com.innovecture.timesheetapi.repo.TimesheetRepo;

@Service
public class TimesheetService {

	@Autowired
	private TimesheetRepo timesheetRepo;
	
	public List<Timesheet> getTimesheets(){
		List<Timesheet> list=  new ArrayList<>();
		timesheetRepo.findAll().forEach(a->list.add(a));
		return list;
	}
	
	public Optional<Timesheet> getTimesheetById(Long id) {
		return this.timesheetRepo.findById(id);
	}
	
	public Timesheet saveTimesheet(Timesheet timesheet) {
		this.timesheetRepo.save(timesheet);
		return timesheet;
	}
	
	public void deleteById(Long id) {
		this.timesheetRepo.deleteById(id);
	}
	
}
