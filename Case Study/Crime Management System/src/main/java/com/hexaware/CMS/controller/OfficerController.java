package com.hexaware.CMS.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.CMS.dto.IncidentDto;
import com.hexaware.CMS.entity.Incident;
import com.hexaware.CMS.entity.Officer;
import com.hexaware.CMS.exception.NotExistException;
import com.hexaware.CMS.service.OfficerService;


@RestController
@RequestMapping("api/v1/Officer/")
@CrossOrigin("http://localhost:3000")
public class OfficerController {

		private OfficerService officerService;


		public OfficerController(OfficerService officerService) {
			super();
			this.officerService = officerService;
		}

		
		@GetMapping("ViewIncidentById")
		public Optional<IncidentDto> ViewIncident(@RequestParam int incidentId)throws NotExistException {
			
			Optional<Incident> incidentOpt= officerService.viewIncident(incidentId);
			IncidentDto incidentDto=new IncidentDto(incidentOpt.get());
			return Optional.ofNullable(incidentDto);
		}
		
		@GetMapping("ViewOfficerAssignIncident")
		public Optional<List<IncidentDto>> ViewOfficerAssignIncident(@RequestParam int officerId)throws NotExistException {
			
			Optional<List<Incident>> incidentListOpt= officerService.viewOfficerAssignIncident(officerId);
			List<IncidentDto> incidentDtoList=new ArrayList<>();
			for(Incident incident:incidentListOpt.get())
			{
				incidentDtoList.add(new IncidentDto(incident));
			}
			return Optional.ofNullable(incidentDtoList);
		}
		
		@GetMapping("DownloadIncidentById")
		public Optional<IncidentDto> DownloadIncident(@RequestParam int incidentId) throws NotExistException {
			Optional<Incident> incidentOpt= officerService.downloadIncidentdetails(incidentId);
			IncidentDto incidentDto=new IncidentDto(incidentOpt.get());
			return Optional.ofNullable(incidentDto);
		}
		
		@PutMapping("ClosedIncidentById")
		public Optional<IncidentDto> ChangeStatus(@RequestParam int incidentId) throws NotExistException {
			Optional<Incident> incidentOpt=officerService.ChangeStatusToClosed(incidentId);
			IncidentDto incidentDto=new IncidentDto(incidentOpt.get());
			return Optional.ofNullable(incidentDto);
		}
		
		@GetMapping("/GetIdByEmail/{email}")
		public Officer getIdByEmail(@PathVariable String email) throws NotExistException
		{
			Officer officer;
			officer=officerService.getIdByEmail(email).get();
			
			return officer;
		}
		
}
