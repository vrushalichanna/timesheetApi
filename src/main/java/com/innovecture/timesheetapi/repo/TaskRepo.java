package com.innovecture.timesheetapi.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.innovecture.timesheetapi.model.Task;

@Repository
public interface TaskRepo extends CrudRepository<Task, Long> {

}
