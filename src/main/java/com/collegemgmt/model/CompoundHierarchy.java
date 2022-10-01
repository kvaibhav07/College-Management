package com.collegemgmt.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
/**
 * class-name: CompoundHierarchy.java
 * Assigning hierarchy for everyone 
 * from the institution to the section
 *   
 * @author 
 * @version 1.0
 * @since 2016-02-23  
 *
 */
@Embeddable

public class CompoundHierarchy  implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * institution of a person
	 */
	private String institution;
	/**
	 * School of a person
	 */
	private String school;
	/**
	 * standard of a person
	 */
	private String standard;
	/**
	 * section of a person
	 */
	private String  section;
	
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
	 * Gets the name of the School
	 * @return School, current name of the School
	 */
	public String getSchool() {
		return school;
	}
	/**
	 * Changes the name of the School
	 * @param School, new name of the School
	 */
	public void setSchool(String school) {
		this.school = school;
	}
	/**
	 * Gets the name of the Standard
	 * @return Standard, current name of the Standard
	 */
	public String getStandard() {
		return standard;
	}
	/**
	 * Changes the name of the Standard
	 * @param Standard, new name of the Standard
	 */
	public void setStandard(String standard) {
		this.standard = standard;
	}
	/**
	 * Gets the name of the Section
	 * @return Section, current name of the Section
	 */
	public String getSection() {
		return section;
	}
	/**
	 * Changes the name of the Section
	 * @param Section, new name of the Section
	 */
	public void setSection(String section) {
		this.section = section;
	}
	
	

}