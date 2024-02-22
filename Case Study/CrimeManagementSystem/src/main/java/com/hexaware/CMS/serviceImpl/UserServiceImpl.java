package com.hexaware.CMS.serviceImpl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.hexaware.CMS.entity.Incident;
import com.hexaware.CMS.entity.User;
import com.hexaware.CMS.exception.AlreadyExistException;
import com.hexaware.CMS.exception.NotExistException;
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
	public User generateIncident(User user) throws AlreadyExistException {
		try{
		 user=userRepository.save(user);
	}
		catch(Exception e)
		{
			throw new AlreadyExistException(e.getMessage());
		}
		return user;
	}
	
	@Override
	public Optional<User> generateReportById(int incident_id) throws NotExistException {
		User user=null;
		try
		{
		int user_id=userRepository.getUserId(incident_id);
		 user=userRepository.getUser(user_id);
		}
		catch(Exception e)
		{
		throw new NotExistException(e.getMessage());
		}
		return Optional.ofNullable(user);
		}


	@Override
	public Optional<Incident> trackIncidentById(int incident_id) throws NotExistException  {
		Optional<Incident> IncidentOpt=incidentRepostory.findById(incident_id);
		if(IncidentOpt.isEmpty())
		{
			throw new NotExistException("Incident Not found");
		}
		return IncidentOpt;
	}


	

	
	
}


	

	
	
	
	

