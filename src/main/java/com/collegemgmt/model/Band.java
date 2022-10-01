package com.collegemgmt.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

/**
 * class-name: Band.java 
 * Assigning band for everyone who enrolled in the school
 * from the principal to the students
 * 
 * @author :Kuvar Vaibhav Singh
 * @version 1.0
 * @since 2016-02-23
 *
 */
@Entity
@Table(name = "BAND_MASTER")
@IdClass(com.collegemgmt.model.CompoundBand.class)
public class Band {

	/**
	 * Band Id of a person
	 */
	@Id
	@Column(name = "BAND_ID")
	private int bandId;
	/**
	 * Designation of the particular person 
	 */
	@Id
	@Column(name = "DESIGNATION")
	private String designation;
	/**
	 * Role of the particular person 
	 */
	@Id
	@Column(name = "ROLE")
	private String role;
	/**
	 * timeStamp is the Time when the band entity is added
	 */
	@Column(name = "TIME_STAMP")
	private String timeStamp;

	/**
	 * Gets the bandId of the person
	 * 
	 * @return this person's(current bandId) BandId
	 */
	public int getBandId() {
		return bandId;
	}

	/**
	 * Changes the BandId of the person
	 * 
	 * @param bandId
	 *            new Band Id of the person
	 */
	public void setBandId(int bandId) {
		this.bandId = bandId;
	}

	/**
	 * Gets the designation of the person
	 * 
	 * @return this person's or current designation
	 */
	public String getDesignation() {
		return designation;
	}

	/**
	 * Changes the Designation of the person
	 * 
	 * @param designation
	 *            new designation of the person
	 */
	public void setDesignation(String designation) {
		this.designation = designation;
	}

	/**
	 * Gets the role of the person
	 * 
	 * @return role current role of the person
	 */
	public String getRole() {
		return role;
	}

	/**
	 * Changes the role of the person
	 * 
	 * @return role new role of the person
	 */
	public void setRole(String role) {
		this.role = role;
	}

	/**
	 * Gets the entry time
	 * 
	 * @return timeStamp current timeStamp
	 */
	public String getTimeStamp() {
		return timeStamp;
	}

	/**
	 * Changes the entry time
	 * 
	 * @return timeStamp new timeStamp
	 */
	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}

}
