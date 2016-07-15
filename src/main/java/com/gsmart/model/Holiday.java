package com.gsmart.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "HOLIDAY_MASTER")
public class Holiday {

	/**
	 * Holiday date
	 */
	@Id
	@Column(name="HOLIDAY_DATE")
	private String holidayDate;
	
	/**
	 * description of holiday
	 */
	@Column(name="DESCRIPTION")
	private String description;
	
	/**
	 * time stamp
	 */
	@Column(name="TIME_STAMP")
	private String timeStamp;


	/**
	 * Gets the HolidayDate
	 * @return HolidayDate, current HolidayDate
	 */
	public String getHolidayDate() {
		return holidayDate;
	}
	
	/**
	 * Sets the Holiday Date
	 * @return updatedTime new updated Time
	 */
	public void setHolidayDate(String holidayDate) {
		this.holidayDate = holidayDate;
	}

	

	/**
	 * Gets the Description
	 * @return Description, current Description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Sets the Description of Holiday Date
	 * @return updatedTime new updated Time
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	

	/**
	 * Gets the TimeStamp
	 * @return TimeStamp, current TimeStamp
	 */
	public String getTimeStamp() {
		return timeStamp;
	}

	/**
	 * Sets the Time Stamp
	 * @return updatedTime new updated Time
	 */
	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}
	
	
}
