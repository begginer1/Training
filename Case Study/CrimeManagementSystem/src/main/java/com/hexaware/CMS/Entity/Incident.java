package com.hexaware.CMS.entity;

import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.ManyToMany;

import jakarta.persistence.Table;

@Entity
@Table(name = "incident")

public class Incident {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "incident_id")
	private Integer  id;
	
	private String status;
	
	@Column(name="incident_type")
	private String incidentType;
	@Column(name="item_name")
	private String itemName;
	@Column(name="item_amount")
	private String itemAmount;	
	private String image;
	private String description;
	private String location;
	
	@CreationTimestamp
	@Column(name="creation_date")
	private String CreationDate;	
	
	@JsonIgnore
	@ManyToMany(mappedBy="incidentList")
	private List<Officer> officerList;
	public Incident() {
		super();
	}
	public Incident(Integer id, String status, String incidentType, String itemName, String itemAmount, String image,
			String description, String location, List<Officer> officerList) {
		super();
		this.id = id;
		this.status = status;
		this.incidentType = incidentType;
		this.itemName = itemName;
		this.itemAmount = itemAmount;
		this.image = image;
		this.description = description;
		this.location = location;
		this.officerList = officerList;
	}
	
	public Incident(Incident incident) {
		super();
		this.id = incident.id;
		this.status = incident.status;
		this.incidentType = incident.incidentType;
		this.itemName = incident.itemName;
		this.itemAmount = incident.itemAmount;
		this.image = incident.image;
		this.description = incident.description;
		this.location = incident.location;
		this.officerList = incident.officerList;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getIncidentType() {
		return incidentType;
	}
	public void setIncidentType(String incidentType) {
		this.incidentType = incidentType;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getItemAmount() {
		return itemAmount;
	}
	public void setItemAmount(String itemAmount) {
		this.itemAmount = itemAmount;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public List<Officer> getOfficerList() {
		return officerList;
	}
	public void setOfficerList(List<Officer> officerList) {
		this.officerList = officerList;
	}
	
	
}