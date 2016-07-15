 package com.gsmart.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name="BAND_MASTER")
@IdClass(com.gsmart.model.CompoundBand.class)
public class Band {
	@Id
	@Column(name="BAND_ID")
	private int bandId;
	
	@Id
	@Column(name="DESIGNATION")
	private String designation;
	
	@Id
	@Column(name="ROLE")
	private String role;
	
	@Column(name="TIME_STAMP")
	private String timeStamp;
	

	public int getBandId() {
		return bandId;
	}

	public void setBandId(int bandId) {
		this.bandId = bandId;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}

}
