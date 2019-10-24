package com.innovecture.timesheetapi.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.innovecture.timesheetapi.model.Projects;

@Repository
public interface ProjectRepo extends CrudRepository<Projects, Long> {

}
