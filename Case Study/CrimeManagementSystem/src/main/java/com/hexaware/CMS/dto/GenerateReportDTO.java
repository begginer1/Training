package com.hexaware.CMS.dto;

import java.util.ArrayList;
import java.util.List;

import com.hexaware.CMS.entity.Incident;
import com.hexaware.CMS.entity.Officer;
import com.hexaware.CMS.entity.User;

public class GenerateReportDTO {
	private User user;
	
	private Officer officer;

	public User getUser() {
		return user;
	}
	public GenerateReportDTO(User user, Officer officer) {
		super();
		this.user = user;
		this.officer = officer;
	}
	
	

	public void setUser(User user) {
		this.user = user;
	}

	

	public Officer getOfficer() {
		return officer;
	}

	public void setOfficer(Officer officer) {
		this.officer = officer;
	}

}
