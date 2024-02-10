package com.hexaware.CMS.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "incident")

public class Incident {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int  id;
	
	private String status;
	
	

	private String itemName;
	private String itemAmount;
	private String image;
	private String descrption;
	private String location;
	public Incident() {
		super();
	}
	public Incident(int id, String status, String itemName, String itemAmount, String image, String descrption,
			String location) {
		super();
		this.id = id;
		this.status = status;
		this.itemName = itemName;
		this.itemAmount = itemAmount;
		this.image = image;
		this.descrption = descrption;
		this.location = location;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
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
	public String getDescrption() {
		return descrption;
	}
	public void setDescrption(String descrption) {
		this.descrption = descrption;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	
}