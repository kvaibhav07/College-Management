package com.collegemgmt.model;

import javax.persistence.*;


@Entity
@Table(name="HIERARCHY_MASTER")
@IdClass( com.collegemgmt.model.CompoundHierarchy.class)
/**
 * class-name: Hierarchy.java
 * Assigning hierarchy for everyone 
 * from the institution to the section
 *   
 * @author 
 * @version 1.0
 * @since 2016-02-23  
 *
 */
public class Hierarchy {
	/**
	 * School of a person
	 */

	@Id
	@Column(name="SCHOOL")
	private String school;

	/**
	 * Standard of a person
	 */

	@Id
	@Column(name="STANDARD")
	private String standard;

	/**
	 * Section of a person
	 */
	@Id
	@Column(name="SECTION")
	private String section;

	/**
	 * Institution of a person
	 */
	@Id
	@Column(name="INSTITUTION")
	private String institution;

	/**
	 * Time_Stamp is the Current time of person 
	 */
	@Column(name="TIME_STAMP")
	private String timeStamp;

	/**
	 * Gets the current time  of the person
	 * @return this person's(current timestam) Time_Stamp
	 */
	public String getTimeStamp() {
		return timeStamp;
	}

	/**
	 * Changes the current time
	 * @return current timestamp new timestam
	 */


	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}


	/**
	 * Gets the name of the institution
	 * @return institution, current name of the institution
	 */

	public String getInstitution() {
		return institution;
	}

	/**
	 * Changes the name of the institution
	 * @param institution, new name of the institution
	 */

	public void setInstitution(String institution) {
		this.institution = institution;
	}

	/**
	 * Gets the name of the school
	 * @return school, current name of the school
	 */
	public String getSchool() {
		return school;
	}

	/**
	 * Changes the name of the school
	 * @param school, new name of the school
	 */

	public void setSchool(String school) {
		this.school = school;
	}

	/**
	 * Gets the name of the standard
	 * @return standard, current name of the standard
	 */

	public String getStandard() {
		return standard;
	}
	/**
	 * Changes the name of the standard
	 * @param standard, new name of the standard
	 */
	public void setStandard(String standard) {
		this.standard = standard;
	}
	/**
	 * Gets the name of the section
	 * @return section, current name of the section
	 */

	public String getSection() {
		return section;
	}

	/**
	 * Changes the name of the section
	 * @param section, new name of the section
	 */
	public void setSection(String section) {
		this.section = section;
	}



}






