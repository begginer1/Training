package com.hexaware.CMS.service;

import org.springframework.stereotype.Service;

import com.hexaware.CMS.entity.Incident;
import com.hexaware.CMS.entity.Officer;

@Service
public interface OfficerService {
	public Officer addOfficer(Officer officer);
	
	public Incident viewIncident(int incident);
	
	public Incident downloadIncidentdetails(int incident);
}
