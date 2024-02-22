package com.hexaware.CMS.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.CMS.dto.IncidentDTO;
import com.hexaware.CMS.dto.UserDTO;
import com.hexaware.CMS.entity.Incident;
import com.hexaware.CMS.entity.User;
import com.hexaware.CMS.exception.AlreadyExistException;
import com.hexaware.CMS.exception.NotExistException;
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
	public ResponseEntity<User>CreateUser(@RequestBody UserDTO userDto) throws AlreadyExistException{
		User user=new User(userDto);
		userService.generateIncident(user);
		 userDto=new UserDTO(user);
		return ResponseEntity.ok(user);
	}

	@GetMapping("GenerateReport")
	public UserDTO GetReport(@RequestParam int inc_id) throws NotExistException {
		User user=userService.generateReportById(inc_id).get();
		UserDTO userDto=new UserDTO(user);
	return userDto;
	}

	@GetMapping("TrackProgress")
	public IncidentDTO GetStatus(@RequestParam int inc_id) throws NotExistException {
		Incident incident=userService.trackIncidentById(inc_id).get();
		IncidentDTO incidentDto= new IncidentDTO(incident);
	return incidentDto;
	}

}
