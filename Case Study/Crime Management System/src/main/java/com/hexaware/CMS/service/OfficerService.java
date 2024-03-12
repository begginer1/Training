package com.hexaware.CMS.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.hexaware.CMS.entity.Incident;
import com.hexaware.CMS.entity.Officer;
import com.hexaware.CMS.exception.NotExistException;

@Service
public interface OfficerService {
	public Officer addOfficer(Officer officer);
	
	public Optional<Incident> viewIncident(int incident) throws NotExistException;
	
	public Optional<Incident> downloadIncidentdetails(int incident) throws NotExistException;
	public Optional<Incident> ChangeStatusToClosed(int incident) throws NotExistException;
	
}
