package com.hexaware.CMS.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

//@Entity
//@Table(name = "lost_property")

public class LostPorperty implements ITypeOfIncident {
	private String descrption;
	private String itemName;
	private String location;

	public LostPorperty() {
		super();
	}

	public LostPorperty(String descrption, String itemName, String location) {
		super();
		this.descrption = descrption;
		this.itemName = itemName;
		this.location = location;
	}

	public String getDescrption() {
		return descrption;
	}

	public void setDescrption(String descrption) {
		this.descrption = descrption;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "LostPorperty [descrption=" + descrption + ", itemName=" + itemName + ", location=" + location + "]";
	}

}