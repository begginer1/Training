package com.hexaware.CMS.serviceImpl;

import org.springframework.stereotype.Service;

import com.hexaware.CMS.entity.Incident;
import com.hexaware.CMS.entity.Officer;
import com.hexaware.CMS.repository.IncidentRepository;
import com.hexaware.CMS.repository.OfficerRepository;
import com.hexaware.CMS.service.OfficerService;

@Service
public class OfficerServiceImpl implements OfficerService{

	private OfficerRepository  officerRepository;
	private IncidentRepository incidentRepository;
	
	
	public OfficerServiceImpl(OfficerRepository officerRepository,IncidentRepository incidentRepository) {
		super();
		this.officerRepository = officerRepository;
		this.incidentRepository=incidentRepository;
	}


	@Override
	public Officer addOfficer(Officer officer) {
		return officerRepository.save(officer);
	}


	@Override
	public Incident viewIncident(int incident_id) {
		
		return incidentRepository.findByid(incident_id);
	}


	@Override
	public Incident downloadIncidentdetails(int incident_id) {
		return incidentRepository.findByid(incident_id);
		
	}

}
