package com.innovecture.timesheetapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.innovecture.timesheetapi.repo.EffortsRepo;

@Service
public class EffortsService {

	@Autowired
	private EffortsRepo effortsRepo;
}
