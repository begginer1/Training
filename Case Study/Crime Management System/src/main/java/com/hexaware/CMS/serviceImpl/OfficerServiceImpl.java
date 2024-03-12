package com.hexaware.CMS.serviceImpl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.hexaware.CMS.entity.Incident;
import com.hexaware.CMS.entity.Officer;
import com.hexaware.CMS.exception.NotExistException;
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
	public Optional<Incident> viewIncident(int incident_id) throws NotExistException {
		
		Optional<Incident> incidentOpt=incidentRepository.findById(incident_id);
		if(incidentOpt.isEmpty())
		{
			throw new NotExistException("Incident Not exist");
		} 
		return incidentOpt;
	}


	@Override
	public Optional<Incident> downloadIncidentdetails(int incident_id) throws NotExistException {
		Optional<Incident> incidentOpt=incidentRepository.findById(incident_id);
		if(incidentOpt.isEmpty())
		{
			throw new NotExistException("Incident Not exist");
		} 
		return incidentOpt;
	}


	@Override
	public Optional<Incident> ChangeStatusToClosed(int incident_id) throws NotExistException {
		Optional<Incident> incidentOpt=incidentRepository.findById(incident_id);
		if(incidentOpt.isEmpty())
			throw new NotExistException("Incident Not exist");
		Incident incident=incidentOpt.get();
		incident.setStatus("Closed");
		return Optional.ofNullable(incidentRepository.save(incident));
	}

}
