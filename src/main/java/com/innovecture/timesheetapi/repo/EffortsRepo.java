package com.innovecture.timesheetapi.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.innovecture.timesheetapi.model.Efforts;

@Repository
public interface EffortsRepo extends CrudRepository<Efforts, Long> {

}
