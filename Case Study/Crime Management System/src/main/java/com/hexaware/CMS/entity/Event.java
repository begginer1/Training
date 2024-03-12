package com.hexaware.CMS.entity;



import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="event")
public class Event {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String title; 
	private String  description;
	private Date date;
	private String location;
	private Integer maxAttendees;
	
	private Integer registrationFee;
	
	public Event() {
		super();
	}

	public Event(Integer id, String title, String description, Date date, String location, Integer maxAttendees,
			Integer registrationFee) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.date = date;
		this.location = location;
		this.maxAttendees = maxAttendees;
		this.registrationFee = registrationFee;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Integer getMaxAttendees() {
		return maxAttendees;
	}

	public void setMaxAttendees(Integer maxAttendees) {
		this.maxAttendees = maxAttendees;
	}

	public Integer getRegistrationFee() {
		return registrationFee;
	}

	public void setRegistrationFee(Integer registrationFee) {
		this.registrationFee = registrationFee;
	}

	@Override
	public String toString() {
		return "Event [id=" + id + ", title=" + title + ", description=" + description + ", date=" + date
				+ ", location=" + location + ", maxAttendees=" + maxAttendees + ", registrationFee=" + registrationFee
				+ "]";
	}

	
}
