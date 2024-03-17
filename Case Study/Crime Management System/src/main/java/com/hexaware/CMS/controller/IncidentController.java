package com.hexaware.CMS.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.CMS.dto.IncidentDto;
import com.hexaware.CMS.entity.Incident;
import com.hexaware.CMS.exception.AlreadyExistException;
import com.hexaware.CMS.exception.NotExistException;
import com.hexaware.CMS.service.IncidentService;

@RestController
@RequestMapping("api/v1/incident/")
@CrossOrigin("http://localhost:3000")
public class IncidentController {

		private IncidentService incidentService;

		public IncidentController(IncidentService incidentService) {
			super();
			this.incidentService = incidentService;
		}

		@PostMapping("generateIncident")
		public IncidentDto createIncident(@RequestBody IncidentDto incidentDto)  {
			Incident incident=new Incident(incidentDto);
			incidentDto=new IncidentDto(incidentService.generateIncident(incident));
			return incidentDto;
		}
		
		@GetMapping("GetIncidentNo/{userId}/{incidentType}")
		public Integer getIncidentCount(@PathVariable Integer userId,@PathVariable String incidentType) 
		{
			return incidentService.countIncident(userId, incidentType);
		}
		
		@GetMapping("GetOfficerAssignIncidentNo")
		public Integer getOfficerAssignIncidentCount(@RequestParam Integer officerId,@RequestParam String incidentType) 
		{
			return incidentService.officerAssignIncidentCount(officerId, incidentType);
		}
		@DeleteMapping("deleteIncident/{incidentId}")
		public Boolean deleteIncident(@PathVariable Integer incidentId) 
		{
			return incidentService.deleteIncident(incidentId);
		}
	}


