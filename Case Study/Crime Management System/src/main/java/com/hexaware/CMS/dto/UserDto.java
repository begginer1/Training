package com.hexaware.CMS.dto;

import java.math.BigInteger;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

import com.hexaware.CMS.entity.Incident;
import com.hexaware.CMS.entity.User;


//user-incidentList one to many
//stationhead-incidentList 1 to many
//1 station head -officer many to many

public class UserDto {
	
	private Integer id;
	
	private BigInteger aadharNumber;
	private String name;
	
	private String panNumber;
	
	private LocalDate dateOfBirth;
	private String email;
	private String address;
	private int age;
	
	
	private	List<Incident> incident=new ArrayList<>();
	public UserDto() {
		super();
	}
	
	
	public UserDto(BigInteger aadharNumber, String name, String panNumber, LocalDate dateOfBirth,String email, String address,List<Incident> incident) {
		super();
	
		this.aadharNumber = aadharNumber;
		this.name = name;
		this.panNumber = panNumber;
		this.dateOfBirth = dateOfBirth;
		this.email=email;
		this.address = address;
		this.incident = incident;
	}


	public UserDto(User user) {
		super();
		this.id = user.getId();
		this.aadharNumber = user.getAadharNumber();
		this.name = user.getName();
		this.panNumber = user.getPanNumber();
		this.dateOfBirth = user.getDateOfBirth();
		this.email=user.getEmail();
		this.address = user.getAddress();
		this.age = user.getAge();
		this.incident = user.getIncident();
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
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(LocalDate dateOfBirth) {
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

	
	
	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "UserDto [id=" + id + ", aadharNumber=" + aadharNumber + ", name=" + name + ", panNumber=" + panNumber
				+ ", dateOfBirth=" + dateOfBirth + ", email=" + email + ", address=" + address + ", age=" + age
				+ ", incident=" + incident + "]";
	}

	

}