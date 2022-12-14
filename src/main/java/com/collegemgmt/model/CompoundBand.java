package com.collegemgmt.model;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class CompoundBand implements Serializable {
	private static final long serialVersionUID = 1L;

	private int bandId;
	private String designation;
	private String role;
	
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


}
