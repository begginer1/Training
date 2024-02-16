package com.hexaware.CMS.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.CMS.dto.GenerateReportDTO;
import com.hexaware.CMS.entity.Incident;
import com.hexaware.CMS.entity.User;
import com.hexaware.CMS.service.UserService;

@RestController
@RequestMapping("api/v1/User/")
public class UserController {

	private UserService userService;

	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}

	@PostMapping("CreateUser")
	public User CreateUser(@RequestBody User user) {
		return userService.generateIncident(user);
	}

	@GetMapping("GenerateReport")
	public GenerateReportDTO GetReport(@RequestParam int inc_id) {
		return userService.generateReportById(inc_id);
	}

	@GetMapping("TrackProgress")
	public Incident GetStatus(@RequestParam int inc_id) {
		return userService.trackIncidentById(inc_id);
	}

}
