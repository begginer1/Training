package com.hexaware.CMS.service;

import java.util.List;

import com.hexaware.CMS.entity.Incident;
import com.hexaware.CMS.entity.Officer;
import com.hexaware.CMS.entity.StationHead;


public interface StationHeadService {
	public StationHead createStationHead(StationHead stationhead);
	List <Officer>removeOfficer(int officer_id);
	Officer addOfficer(Officer officer);
	Incident ChangeStatusFromCloseToVerified(Incident incident);
	List<Incident> ViewAllIncidents();
	Incident AssignOfficerToIncident(Incident incident,Officer officer);
	List<Officer>ViewAllOfficer();
}
