package com.hexaware.CMS.serviceImpl;

import java.util.List;
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
		Optional<Incident> incidentOpt=incidentRepostory.findById(incident_id);
		user.setIncident(List.of(incidentOpt.get()));
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

	

	@Override
	public Optional<List<Incident>> getAllIncident(int userId) throws NotExistException {
		Optional<List<Incident>> incidentList=incidentRepostory.findAllFkUserId(userId);
		if(incidentList==null)
		{
			throw new NotExistException("No Incident to show");
		}
			return incidentList;
	}

	@Override
	public Optional<Incident> AddIncident(int user_id, Incident incident) throws NotExistException {
		Optional<User> userOpt=userRepository.findById(user_id);
		if(userOpt.isEmpty())
		{
			throw new NotExistException("User Not found");
		}
		List <Incident> incidentList=userOpt.get().getIncident();
		incidentList.add(incident);
		userOpt.get().setIncident(incidentList);
		userRepository.save(userOpt.get());
		return Optional.of(incident);
		
	}

	@Override
	public Optional<Integer> getIdByEmail(String email) throws NotExistException {
	Integer userId;
		try {
		userId=userRepository.getIdByEmail(email);
		}
		catch(Exception e)
		{
			throw new NotExistException("User with email Not found");
		}
		return Optional.of(userId);
	}


	

	
	
}


	

	
	
	
	

