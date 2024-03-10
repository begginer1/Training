package com.hexaware.CMS.dto;

import java.time.LocalDate;
import java.util.Set;

import com.hexaware.CMS.entity.Incident;
import com.hexaware.CMS.entity.Officer;



public class IncidentDto {

	private Integer id;
	private String status;
	private String incidentType;

	private String itemName;
	
	private String itemAmount;	
	private String image;
	private String description;
	private String location;
	private LocalDate dateOfIncident;
	private Set<Officer> officerList;
	public IncidentDto() {
		super();
	}
	public IncidentDto( String incidentType, String itemName, String itemAmount, String image,
			String description, String location, Set<Officer> officerList, LocalDate dateOfIncident) {
		super();
		
		this.incidentType = incidentType;
		this.itemName = itemName;
		this.itemAmount = itemAmount;
		this.image = image;
		this.description = description;
		this.location = location;
		this.officerList = officerList;
		this.dateOfIncident=dateOfIncident;
	}
	
	public IncidentDto(Incident incident) {
		super();
		this.id=incident.getId();
		this.status=incident.getStatus();
		this.incidentType = incident.getIncidentType();
		this.itemName = incident.getItemName();
		this.itemAmount = incident.getItemAmount();
		this.image = incident.getImage();
		this.description = incident.getDescription();
		this.location = incident.getLocation();
		this.officerList = incident.getOfficerList();
		this.dateOfIncident=incident.getDateOfIncident();
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
	public Set<Officer> getOfficerList() {
		return officerList;
	}
	
	public void setOfficerList(Set<Officer> officerList) {
		this.officerList = officerList;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public LocalDate getDateOfIncident() {
		return dateOfIncident;
	}
	public void setDateOfIncident(LocalDate date_Of_Incident) {
		this.dateOfIncident = date_Of_Incident;
	}
	
	
	
	
}