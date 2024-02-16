package com.hexaware.CMS.entity;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


//user-incidentList one to many
//stationhead-incidentList 1 to many
//1 station head -officer many to many

@Entity
@Table(name = "user")

public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private Integer id;
	@Column(name = "aadhar_number",unique = true,nullable = false)
	private BigInteger aadharNumber;
	private String name;
	@Column(name = "pan_number",unique = true,nullable = false)
	private String panNumber;
	@Column(name = "date_of_birth")
	private String dateOfBirth;

	private String address;
	private int age;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="fk_user_id")
	private	List<Incident> incident=new ArrayList<>();
	public User() {
		super();
	}
	
	
	public User(Integer id, BigInteger aadharNumber, String name, String panNumber, String dateOfBirth, String address,
			int age, List<Incident> incident) {
		super();
		this.id = id;
		this.aadharNumber = aadharNumber;
		this.name = name;
		this.panNumber = panNumber;
		this.dateOfBirth = dateOfBirth;
		this.address = address;
		this.age = age;
		this.incident = incident;
	}


	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public BigInteger getAadharNumber() {
		return aadharNumber;
	}
	public void setAadharNumber(BigInteger aadharNumber) {
		this.aadharNumber = aadharNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPanNumber() {
		return panNumber;
	}
	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public List<Incident> getIncident() {
		return incident;
	}
	public void setIncident(List<Incident> incident) {
		this.incident = incident;
	}


	
	

}