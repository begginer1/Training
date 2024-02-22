package com.hexaware.CMS.service;

import java.util.List;
import java.util.Optional;

import com.hexaware.CMS.entity.Incident;
import com.hexaware.CMS.entity.User;
import com.hexaware.CMS.exception.AlreadyExistException;
import com.hexaware.CMS.exception.NotExistException;

public interface UserService {
	User generateIncident(User user) throws AlreadyExistException;
	Optional<User> generateReportById(int query) throws NotExistException;
	Optional<Incident> trackIncidentById(int incident_id)throws NotExistException;;
	
	
}
