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

import com.hexaware.CMS.dto.IncidentDTO;
import com.hexaware.CMS.dto.UserDTO;
import com.hexaware.CMS.entity.Incident;
import com.hexaware.CMS.entity.User;
import com.hexaware.CMS.exception.AlreadyExistException;
import com.hexaware.CMS.exception.NotExistException;
import com.hexaware.CMS.service.UserService;

@CrossOrigin("http://localhost:3000")
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
	@PostMapping("AddIncident/{user_id}")
	public ResponseEntity<IncidentDTO>AddIncident(@PathVariable int user_id, @RequestBody IncidentDTO incidentDto) throws NotExistException{
		Incident incident=new Incident(incidentDto);
		userService.AddIncident(user_id, incident);
		incidentDto=new IncidentDTO(incident);
		return ResponseEntity.ok(incidentDto);
	}

	@GetMapping("GenerateReport")
	public UserDTO GetReport(@RequestParam int incidentId) throws NotExistException {
		User user=userService.generateReportById(incidentId).get();
		UserDTO userDto=new UserDTO(user);
	return userDto;
	}

	@GetMapping("TrackProgress")
	public IncidentDTO GetStatus(@RequestParam int incidentId) throws NotExistException {
		Incident incident=userService.trackIncidentById(incidentId).get();
		IncidentDTO incidentDto= new IncidentDTO(incident);
	return incidentDto;
	}

	@GetMapping("GetAllIncident/{userId}")
	public List<IncidentDTO> GetIncident(@PathVariable int userId) throws NotExistException {
		Optional<List<Incident>> incidentOpt=userService.getAllIncident(userId);
		List<IncidentDTO> incidentDtoList =new ArrayList<>();
		for(Incident incident:incidentOpt.get() )
			incidentDtoList.add(new IncidentDTO(incident));
	return incidentDtoList;
	}
	
	
}
