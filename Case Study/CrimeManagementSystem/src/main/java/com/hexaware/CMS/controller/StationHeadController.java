package com.hexaware.CMS.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.CMS.dto.IncidentDto;
import com.hexaware.CMS.dto.OfficerDto;
import com.hexaware.CMS.dto.StationHeadDto;
import com.hexaware.CMS.entity.Incident;
import com.hexaware.CMS.entity.Officer;
import com.hexaware.CMS.entity.StationHead;
import com.hexaware.CMS.exception.AlreadyExistException;
import com.hexaware.CMS.exception.NotExistException;
import com.hexaware.CMS.service.StationHeadService;

@RestController
@RequestMapping("api/v1/Stationhead/")
public class StationHeadController {

	private StationHeadService stationHeadService;

	public StationHeadController(StationHeadService stationHeadService) {
		super();
		this.stationHeadService = stationHeadService;
	}

	@PostMapping("CreateStationhead")
	public ResponseEntity<StationHeadDto> CreateStationHead(@RequestBody StationHeadDto stationHeadDto) throws AlreadyExistException{
		StationHead stationHead=new StationHead(stationHeadDto);
		try {
			stationHeadDto=new	StationHeadDto(stationHeadService.createStationHead(stationHead));
		return ResponseEntity.ok(stationHeadDto);
	}
		catch(Exception e)
		{
			throw new AlreadyExistException("Station head Already Exists");
		}
	}

	@DeleteMapping("DeleteOfficer")
	public List<OfficerDto> RemoveOfficer(@RequestParam int officer_id) {

		return stationHeadService.removeOfficer(officer_id).stream().map((officer)->new OfficerDto(officer)).toList();
	}

	@PostMapping("RegisterOfficer")
	public ResponseEntity<OfficerDto> AddOfficer(@RequestBody OfficerDto officerDto)throws AlreadyExistException {
		try {
			Officer officer=new Officer(officerDto); 
			officerDto=new OfficerDto(stationHeadService.addOfficer(officer));
			return ResponseEntity.ok(officerDto);
		}
			catch(Exception e)
			{
				throw new AlreadyExistException("Officer Already Exists");
			}
		
	}

	@PutMapping("ChangeStatus")
	public ResponseEntity<IncidentDto> ChangeStatus(@RequestParam Integer incident_id) throws NotExistException {
		Optional<Incident>incidentOpt=stationHeadService.ChangeStatusFromCloseToVerified(incident_id);
				if(!(incidentOpt.isPresent()))
				throw new NotExistException("Incident Not Found");
				IncidentDto incidentDto=new IncidentDto(incidentOpt.get());
			return ResponseEntity.ok(incidentDto);
	}

	@GetMapping("ViewAllIncident")
	public List<IncidentDto> ViewAllIncidents() {
		return stationHeadService.ViewAllIncidents().stream().map((incident)->new IncidentDto(incident)).toList();
	}

	@GetMapping("ViewAllOfficer")
	public List<Officer> ViewAllOfficer() {
		return stationHeadService.ViewAllOfficer();

	}
	
	@PostMapping("AssignOfficerToIncident/{incident_id}/officer/{officer_id}")
	public ResponseEntity<IncidentDto> AssignOfficerToIncident(@PathVariable Integer incident_id,@PathVariable Integer officer_id) throws NotExistException {
		IncidentDto incidentDto=new IncidentDto(stationHeadService.AssignOfficerToIncident(incident_id,officer_id));
		return ResponseEntity.ok(incidentDto);
	}
}
