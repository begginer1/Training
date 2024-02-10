package com.hexaware.CMS.Entity;

import java.math.BigInteger;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "user")

public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	@Column(name = "aadhar_number")
	private BigInteger aadharNumber;
	private String name;
	@Column(name = "pan_number")
	private String panNumber;
	@Column(name = "date_of_birth")
	private Date dateOfBirth;

	private String address;
	private int age;
	
	public User() {
		super();
	}

	public User(int id, BigInteger aadharNumber, String name, String panNumber, Date dateOfBirth, String address,
			int age) {
		super();
		this.id = id;
		this.aadharNumber = aadharNumber;
		this.name = name;
		this.panNumber = panNumber;
		this.dateOfBirth = dateOfBirth;
		this.address = address;
		this.age = age;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
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


}