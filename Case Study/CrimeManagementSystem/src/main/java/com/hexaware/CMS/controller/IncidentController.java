package com.hexaware.CMS.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.CMS.entity.Incident;
import com.hexaware.CMS.service.IncidentService;

@RestController
@RequestMapping("api/v1/incident/")

public class IncidentController {

		private IncidentService incidentService;

		public IncidentController(IncidentService incidentService) {
			super();
			this.incidentService = incidentService;
		}



		@PostMapping("generateIncident")
		public Incident createIncident(@RequestBody Incident incident) {
			return incidentService.generateIncident(incident);
		}
	}


