package com.hexaware.CMS.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.CMS.dto.IncidentDto;
import com.hexaware.CMS.dto.UserDto;
import com.hexaware.CMS.entity.Incident;
import com.hexaware.CMS.entity.User;
import com.hexaware.CMS.exception.AlreadyExistException;
import com.hexaware.CMS.exception.NotExistException;
import com.hexaware.CMS.service.UserService;


@RestController
@RequestMapping("api/v1/User")
@CrossOrigin("http://localhost:3000")
public class UserController {

	private UserService userService;

	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}

	@PostMapping("/CreateUser")
	public ResponseEntity<User>CreateUser(@RequestBody UserDto userDto) throws AlreadyExistException{
		User user=new User(userDto);
		userService.generateIncident(user);
		 userDto=new UserDto(user);
		return ResponseEntity.ok(user);
	}
	@PostMapping("/AddIncident/{user_id}")
	public ResponseEntity<IncidentDto>AddIncident(@PathVariable int user_id, @RequestBody IncidentDto incidentDto) throws NotExistException{
		Incident incident=new Incident(incidentDto);
		userService.AddIncident(user_id, incident);
		incidentDto=new IncidentDto(incident);
		return ResponseEntity.ok(incidentDto);
	}

	@GetMapping("/GenerateReport")
	public UserDto GetReport(@RequestParam int incidentId) throws NotExistException {
		User user=userService.generateReportById(incidentId).get();
		UserDto userDto=new UserDto(user);
	return userDto;
	}

	@GetMapping("/TrackProgress")
	public IncidentDto GetStatus(@RequestParam int incidentId) throws NotExistException {
		Incident incident=userService.trackIncidentById(incidentId).get();
		IncidentDto incidentDto= new IncidentDto(incident);
	return incidentDto;
	}

	@GetMapping("/GetAllIncident/{userId}")
	public List<IncidentDto> GetIncident(@PathVariable int userId) throws NotExistException {
		Optional<List<Incident>> incidentOpt=userService.getAllIncident(userId);
		List<IncidentDto> incidentDtoList =new ArrayList<>();
		for(Incident incident:incidentOpt.get() )
			incidentDtoList.add(new IncidentDto(incident));
	return incidentDtoList;
	}
	
	@GetMapping("/GetIdByEmail/{email}")
	public User getIdByEmail(@PathVariable String email) throws NotExistException
	{
		User user;
		user=userService.getIdByEmail(email).get();
		
		return user;
	}
	
	@GetMapping("/GetUser/{userId}")
	public User getUserById(@PathVariable Integer userId) throws NotExistException
	{
		User user=userService.getUserByID(userId).get();
		return user;
	}
	
	
}
