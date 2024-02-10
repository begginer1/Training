package com.hexaware.CMS.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

//@Entity
//@Table(name = "petit_larceny")

public class PetitLarceny implements ITypeOfIncident {
	private String descrption;
	private String itemName;
	private String location;
	private String amount;

	public PetitLarceny() {
		super();
	}

	public PetitLarceny(String descrption, String itemName, String location, String amount) {
		super();
		this.descrption = descrption;
		this.itemName = itemName;
		this.location = location;
		this.amount = amount;
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

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "PetitLarceny [descrption=" + descrption + ", itemName=" + itemName + ", location=" + location
				+ ", amount=" + amount + "]";
	}

}
