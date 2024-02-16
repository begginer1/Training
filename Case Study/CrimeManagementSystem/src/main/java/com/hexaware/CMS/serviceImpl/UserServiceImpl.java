package com.hexaware.CMS.serviceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hexaware.CMS.dto.GenerateReportDTO;
import com.hexaware.CMS.entity.Incident;
import com.hexaware.CMS.entity.User;
import com.hexaware.CMS.repository.IncidentRepository;
import com.hexaware.CMS.repository.OfficerRepository;
import com.hexaware.CMS.repository.UserRepository;
import com.hexaware.CMS.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	private UserRepository userRepository;
	private IncidentRepository incidentRepostory; 
	private OfficerRepository officerRepository;
    
	
	
	public UserServiceImpl(UserRepository userRepository,IncidentRepository incidentRepostory,OfficerRepository officerRepository) {
		super();
		this.userRepository = userRepository;
		this.incidentRepostory=incidentRepostory;
		this.officerRepository=officerRepository;
	}

	@Override
	public User generateIncident(User user) {
		return this.userRepository.save(user);
	}
	
	@Override
	public GenerateReportDTO generateReportById(int incident_id) {
		int user_id=userRepository.getUserId(incident_id);
		System.out.println(user_id);
		User user=userRepository.getUser(user_id);
		// officer
//		int officer_id= officerRepository.IncidentOfficerMapping(incident_id);
//		Officer officer=officerRepository.getOfficer(officer_id);
		return new GenerateReportDTO(user,null);
	}


	@Override
	public Incident trackIncidentById(int incident_id) {
		
		return incidentRepostory.findByid(incident_id);
	}


	

	
	
}


	

	
	
	
	

