package com.hexaware.CMS.service;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.hexaware.CMS.dto.IncidentDTO;
import com.hexaware.CMS.entity.Incident;
import com.hexaware.CMS.entity.User;
import com.hexaware.CMS.exception.AlreadyExistException;
import com.hexaware.CMS.exception.NotExistException;

public interface UserService {
	User generateIncident(User user) throws AlreadyExistException;
	Optional<User> generateReportById(int query) throws NotExistException;
	Optional<Incident> trackIncidentById(int incident_id)throws NotExistException;
	Optional<List<Incident>> getAllIncident(int fkUserId) throws NotExistException;
	Optional<Incident>AddIncident(int user_id,Incident inciden)throws NotExistException;
}
