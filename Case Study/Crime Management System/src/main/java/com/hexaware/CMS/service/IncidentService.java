package com.hexaware.CMS.service;


import com.hexaware.CMS.entity.Incident;

public interface IncidentService {

	Incident generateIncident(Incident incident);
	Integer countIncident(Integer userId,String incidentType);
	Boolean deleteIncident(Integer incidentId);
}
