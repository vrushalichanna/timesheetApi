package com.innovecture.timesheetapi.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.innovecture.timesheetapi.model.User;

@Repository
public interface UserRepo extends CrudRepository<User, Long> {


	User findByUserNameAndPassword(String name, String password);

	
}
