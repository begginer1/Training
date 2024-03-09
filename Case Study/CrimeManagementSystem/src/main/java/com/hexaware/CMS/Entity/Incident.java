package com.hexaware.CMS.entity;

import java.time.LocalDate;
import java.util.Set;

import org.hibernate.annotations.CreationTimestamp;

import com.hexaware.CMS.dto.IncidentDto;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
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
	private  LocalDate date_Of_Incident;
	
	@CreationTimestamp
	@Column(name="creation_date")
	private LocalDate CreationDate;	
	
	
	@ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinTable(name="officer_incident_mapping",joinColumns= @JoinColumn(name="incident_id",referencedColumnName = "incident_id"),inverseJoinColumns = @JoinColumn(name="officer_id",referencedColumnName ="officer_id"))
	private Set<Officer> officerList;
	public Incident() {
		super();
	}
	public Incident(Integer id, String status, String incidentType, String itemName, String itemAmount, String image,
			String description, String location,LocalDate date_Of_Incident, Set<Officer> officerList) {
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
		this.date_Of_Incident=date_Of_Incident;
	}
	
	public Incident(IncidentDto incident) {
		super();
		this.status = "Initiated";
		this.incidentType = incident.getIncidentType();
		this.itemName = incident.getItemName();
		this.itemAmount = incident.getItemAmount();
		this.image = incident.getImage();
		this.description = incident.getDescription();
		this.location = incident.getLocation();
		this.officerList = incident.getOfficerList();
		this.date_Of_Incident=incident.getDate_Of_Incident();
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
	public Set<Officer> getOfficerList() {
		return officerList;
	}
	
	public void setOfficerList(Set<Officer> officerList) {
		this.officerList = officerList;
	}
	
	public LocalDate getCreationDate() {
		return CreationDate;
	}
	public void setCreationDate(LocalDate creationDate) {
		CreationDate = creationDate;
	}
	
	
	
	public LocalDate getDate_Of_Incident() {
		return date_Of_Incident;
	}
	public void setDate_Of_Incident(LocalDate date_Of_Incident) {
		this.date_Of_Incident = date_Of_Incident;
	}
	@Override
	public String toString() {
		return "Incident [id=" + id + ", status=" + status + ", incidentType=" + incidentType + ", itemName=" + itemName
				+ ", itemAmount=" + itemAmount + ", image=" + image + ", description=" + description + ", location="
				+ location + ", date_Of_Incident=" + date_Of_Incident + ", CreationDate=" + CreationDate
				+ ", officerList=" + officerList + "]";
	}
	
	
	
	
}