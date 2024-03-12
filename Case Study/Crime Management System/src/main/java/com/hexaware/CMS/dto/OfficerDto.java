package com.hexaware.CMS.dto;


import java.util.ArrayList;
import java.util.List;

import com.hexaware.CMS.entity.Incident;
import com.hexaware.CMS.entity.Officer;



public class OfficerDto {
	
	private int id;

	private String name;

	private String badgeNumber;
	
	private String rank;
	private List<Incident> incidentList=new ArrayList<>();
	
	private String email;
	public OfficerDto() {
		super();
	}


	public OfficerDto(String name, String badgeNumber, String rank, List<Incident> incidentList) {
		super();
		this.name = name;
		this.badgeNumber = badgeNumber;
		this.rank = rank;
		this.incidentList = incidentList;
		this.email=email;
	}


	public OfficerDto( Officer officer) {
		super();
		this.id = officer.getId();
		this.name = officer.getName();
		this.badgeNumber = officer.getBadgeNumber();
		this.rank = officer.getRank();
		this.incidentList = officer.getIncidentList();
		this.email=officer.getEmail();
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getBadgeNumber() {
		return badgeNumber;
	}


	public void setBadgeNumber(String badgeNumber) {
		this.badgeNumber = badgeNumber;
	}


	public String getRank() {
		return rank;
	}


	public void setRank(String rank) {
		this.rank = rank;
	}


	public List<Incident> getIncidentList() {
		return incidentList;
	}


	public void setIncidentList(List<Incident> incidentList) {
		this.incidentList = incidentList;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}

}