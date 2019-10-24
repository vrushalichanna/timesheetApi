package com.innovecture.timesheetapi.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.innovecture.timesheetapi.model.Timesheet;

@Repository
public interface TimesheetRepo extends CrudRepository<Timesheet, Long> {

}
