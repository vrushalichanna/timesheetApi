package com.innovecture.timesheetapi.services;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.innovecture.timesheetapi.model.User;
import com.innovecture.timesheetapi.repo.UserRepo;

import dto.LoginDTO;

@Service		
public class UserService {

	@Autowired
	UserRepo userRepo;
	
	public List<User> getUserList(){
		List<User> userList =  new ArrayList<>();
		 this.userRepo.findAll().forEach(a->userList.add(a));
		 return userList;
	}
	
	public Optional<User> getUser(Long id) {
		return this.userRepo.findById(id);
	}
	
	public User saveUser(User user) {
		userRepo.save(user);
		return user;
	}
	
	public void deleteById(Long id) {
		userRepo.deleteById(id);
	}

	public User updateUser(Long id, User user) {
	User newUser = null;
		if(user.getId() == null) {
			newUser =  new User();
		}
		else {
			Optional<User> optUser = userRepo.findById(user.getId());
			newUser= optUser.get();
			
		}
		newUser.setFirstName(user.getFirstName());
		newUser.setLastName(user.getLastName());
		newUser.setEmailId(user.getEmailId());
		newUser.setDepartment(user.getDepartment());
		newUser.setPrimaryContactNo(user.getPrimaryContactNo());
		newUser.setSecondaryContactNo(user.getSecondaryContactNo());
		newUser.setEmployeeId(user.getEmployeeId());
		newUser.setEmergencyContactNo(user.getEmergencyContactNo());
		newUser.setAddress(user.getAddress());
		userRepo.save(newUser);
		return user;
	}

	public LoginDTO getUser(String name, String password) {
		User user = userRepo.findByUserNameAndPassword(name,password);
		LoginDTO authorizedUser = new LoginDTO();
		if(user != null) {
	
			authorizedUser.setFirstName(user.getFirstName());
			authorizedUser.setLastName(user.getLastName());
			authorizedUser.setEmailId(user.getEmailId());
			userRepo.save(user);
			return authorizedUser;
		}
		else {
		return null;
	}
	}



}
