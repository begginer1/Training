package com.hexaware.CMS.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.CMS.entity.Incident;
import com.hexaware.CMS.entity.Officer;
import com.hexaware.CMS.service.OfficerService;


@RestController
@RequestMapping("api/v1/Officer/")
public class OfficerController {

		private OfficerService officerService;


		public OfficerController(OfficerService officerService) {
			super();
			this.officerService = officerService;
		}

		
		@GetMapping("ViewIncident")
		public Incident ViewIncident(@RequestParam int incident_id) {
			return officerService.viewIncident(incident_id);
		}
		
		@GetMapping("DownloadIncident")
		public Incident DownloadIncident(@RequestParam int incident_id) {
			return officerService.downloadIncidentdetails(incident_id);
		}
		
}
