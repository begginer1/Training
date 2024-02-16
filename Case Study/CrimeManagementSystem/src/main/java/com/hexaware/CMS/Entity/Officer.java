package com.hexaware.CMS.entity;


import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "officer")

public class Officer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="officer_id")
	private int id;

	private String name;

	@Column(name="badge_number")
	private String badgeNumber;
	
	@Column(name="officer_rank")
	private String rank;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name="officer_incident_mapping",joinColumns=@JoinColumn(name="officer_id",referencedColumnName ="officer_id"),inverseJoinColumns = @JoinColumn(name="incident_id",referencedColumnName = "incident_id"))
	private List<Incident> incidentList=new ArrayList<>();
	

	public Officer() {
		super();
	}


	public Officer(int id, String name, String badgeNumber, String rank, List<Incident> incidentList) {
		super();
		this.id = id;
		this.name = name;
		this.badgeNumber = badgeNumber;
		this.rank = rank;
		this.incidentList = incidentList;
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

}