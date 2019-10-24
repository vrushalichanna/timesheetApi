package com.innovecture.timesheetapi.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserUploadController {

	@RequestMapping()
	public ResponseEntity<Void> getDataFile(@RequestBody Object object){
		return null;
	}
}
