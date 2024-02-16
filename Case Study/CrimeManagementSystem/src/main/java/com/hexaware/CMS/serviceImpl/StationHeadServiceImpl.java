package com.hexaware.CMS.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.hexaware.CMS.entity.Incident;
import com.hexaware.CMS.entity.Officer;
import com.hexaware.CMS.entity.StationHead;
import com.hexaware.CMS.repository.IncidentRepository;
import com.hexaware.CMS.repository.OfficerRepository;
import com.hexaware.CMS.repository.StationHeadRepository;
import com.hexaware.CMS.service.IncidentService;
import com.hexaware.CMS.service.StationHeadService;


@Service
public class StationHeadServiceImpl implements StationHeadService{

	private StationHeadRepository stationHeadRepository;
	private OfficerRepository officerRepository;
	private IncidentRepository incidentRepository;
	
	
	public StationHeadServiceImpl(StationHeadRepository stationHeadRepository, OfficerRepository officerRepository,IncidentRepository incidentRepository) {
		super();
		this.stationHeadRepository = stationHeadRepository;
		this.officerRepository=officerRepository;
		this.incidentRepository=incidentRepository;
	}


	@Override
	public StationHead createStationHead(StationHead stationhead) {
		
		return stationHeadRepository.save(stationhead);
	}


	@Override
	public List<Officer> removeOfficer(int officer_id) {
	
		stationHeadRepository.deleteById(officer_id);
		List<StationHead> stationHeadList=stationHeadRepository.findAll();
		List<Officer> OfficerList = new ArrayList<>();
        for (StationHead stationHead : stationHeadList) {
            OfficerList.addAll(stationHead.getOfficerList());
        }
        return OfficerList;
	}


	@Override
	public Officer addOfficer(Officer officer) {
		
		return officerRepository.save(officer);
	}


	@Override
	public Incident ChangeStatusFromCloseToVerified(Incident incident) {
		Incident incidentVerfied=new Incident(incident);
		incidentVerfied.setStatus("Verified");
		return incidentVerfied;
	}


	@Override
	public List<Incident> ViewAllIncidents() {
		return incidentRepository.findAll();
	}


	@Override
	public Incident AssignOfficerToIncident(Incident incident, Officer officer) {
		
		return null;
	}


	@Override
	public List<Officer> ViewAllOfficer() {
		List<StationHead> stationHeadList=stationHeadRepository.findAll();
		List<Officer> OfficerList = new ArrayList<>();
        for (StationHead stationHead : stationHeadList) {
            OfficerList.addAll(stationHead.getOfficerList());
        }
        return OfficerList;
	
	}

}
