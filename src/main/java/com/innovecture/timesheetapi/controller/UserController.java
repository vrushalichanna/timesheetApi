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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.innovecture.timesheetapi.model.User;
import com.innovecture.timesheetapi.services.UserService;

import dto.LoginDTO;
@CrossOrigin
@RestController
@RequestMapping("/api2")
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/user")
	public ResponseEntity<List<User>> getUserlist(){
		return new ResponseEntity<>(userService.getUserList(),HttpStatus.OK);
	}
	
	@GetMapping("/user/{id}")
	public ResponseEntity<User>getUserById(@PathVariable Long id){
		if(userService.getUser(id).isPresent()) {
			return new ResponseEntity<>(userService.getUser(id).get(),HttpStatus.OK);
		}else {
			return new ResponseEntity<>(null,HttpStatus.NO_CONTENT);
		}
	}
	
	@PostMapping("/")
	public ResponseEntity<User> saveUser(@RequestBody User user){
		return new ResponseEntity<>(this.userService.saveUser(user),HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable Long id) {
		this.userService.deleteById(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT); 
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<User> updateUser(@PathVariable Long id,@RequestBody User user){
		if(userService.getUser(id).isPresent()) {
			User obj = userService.updateUser(id,user);
			
		}
		return new ResponseEntity<User>(HttpStatus.OK);
	}
	
	@PostMapping("/login")
	public ResponseEntity<LoginDTO> serviceLogin(@RequestHeader("username") String name,
			@RequestHeader("password") String password) {
		LoginDTO returnbody = userService.getUser(name, password);
		
		if(returnbody != null) {
			return new ResponseEntity<LoginDTO>(returnbody,HttpStatus.OK);
			}
			else {
			return new ResponseEntity(HttpStatus.UNAUTHORIZED);
			}
		}
	
}
