package com.hexaware.CMS.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

//@Entity
//@Table(name = "graffiti")

public class Graffiti implements ITypeOfIncident {
	private String descrption;
	private String image;
	private String location;

	public Graffiti() {
		super();
	}

	public Graffiti(String descrption, String image, String location) {
		super();
		this.descrption = descrption;
		this.image = image;
		this.location = location;
	}

	public String getDescrption() {
		return descrption;
	}

	public void setDescrption(String descrption) {
		this.descrption = descrption;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "Graffiti [descrption=" + descrption + ", image=" + image + ", location=" + location + "]";
	}

}
