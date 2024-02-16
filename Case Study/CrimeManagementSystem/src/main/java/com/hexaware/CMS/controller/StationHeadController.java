package com.hexaware.CMS.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.CMS.entity.Incident;
import com.hexaware.CMS.entity.Officer;
import com.hexaware.CMS.entity.StationHead;
import com.hexaware.CMS.service.OfficerService;
import com.hexaware.CMS.service.StationHeadService;

@RestController
@RequestMapping("api/v1/Stationhead/")
public class StationHeadController {

	private StationHeadService stationHeadService;
	private OfficerService officerService;

	public StationHeadController(StationHeadService stationHeadService,OfficerService officerService) {
		super();
		this.stationHeadService = stationHeadService;
		this.officerService=officerService;
	}

	@PostMapping("CreateStationhead")
	public StationHead CreateStationHead(@RequestBody StationHead stationhead) {
		return stationHeadService.createStationHead(stationhead);
	}

//	@DeleteMapping("DeleteOfficer")
//	public List<Officer> RemoveOfficer(@RequestParam int officer_id) {
//
//		return stationHeadService.removeOfficer(officer_id);
//	}

	@PostMapping("RegisterOfficer")
	public Officer AddOfficer(@RequestBody Officer officer) {

		return stationHeadService.addOfficer(officer);
	}

//	@PutMapping("ChangeStatus")
//	public Incident ChangeStatus(@RequestBody Incident incident) {
//		return stationHeadService.ChangeStatusFromCloseToVerified(incident);
//	}

	@GetMapping("ViewAllIncident")
	public List<Incident> ViewAllIncidents() {
		return stationHeadService.ViewAllIncidents();
	}

//	@GetMapping("ViewAllOfficer")
//	public List<Officer> ViewAllOfficer() {
//		return stationHeadService.ViewAllOfficer();
//
//	}
}
