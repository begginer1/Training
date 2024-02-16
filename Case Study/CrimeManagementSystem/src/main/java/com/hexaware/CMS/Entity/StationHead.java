package com.hexaware.CMS.entity;


import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "station_head")

public class StationHead {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="station_head_id")
	private int id;
	private String name;
	private String email;
	
	
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name="stationhead_officer_mapping",joinColumns=@JoinColumn(name="station_head_id",referencedColumnName = "station_head_id"),inverseJoinColumns = @JoinColumn(name="officer_id",referencedColumnName = "officer_id"))
	private List<Officer> OfficerList=new ArrayList();

	public StationHead() {
		super();
	}

	public StationHead(int id, String name, String email, List<Officer> officerList) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		OfficerList = officerList;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Officer> getOfficerList() {
		return OfficerList;
	}

	public void setOfficerList(List<Officer> officerList) {
		OfficerList = officerList;
	}
		
}


	
	