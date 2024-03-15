package com.hexaware.CMS.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.hexaware.CMS.dto.IncidentDto;
import com.hexaware.CMS.entity.Incident;
import com.hexaware.CMS.entity.Officer;
import com.hexaware.CMS.entity.User;
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


	@Override
	public Optional<Officer> getIdByEmail(String email) throws NotExistException {
		Officer officer=null;
		try {
		 officer=officerRepository.getIdByEmail(email).get(0);
			
		}
			catch(Exception e)
			{
				throw new NotExistException("User with email Not found");
			}
			return Optional.of(officer);
		}


	@Override
	public Optional<List<Incident>> viewOfficerAssignIncident(int officerId) throws NotExistException {

		List<Incident> incidentList=incidentRepository.findByOfficerListId(officerId);
		
		if(incidentList.isEmpty())
		{
			throw new NotExistException("No Incident Assigned");
		} 
//		
		return Optional.ofNullable(incidentRepository.findByOfficerListId(officerId));
	}

}
