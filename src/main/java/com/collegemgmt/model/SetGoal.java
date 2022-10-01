package com.collegemgmt.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name="SET_GOALS")
public class SetGoal {
	
	@Id
	@Column(name="ROLE")
	private String role;
	
	@Lob
	@Column(name="PERSONAL")
	private String personal;
	
	@Lob
	@Column(name="SELFIMPROVEMENT")
	private String selfImprovement;
	
	@Lob
	@Column(name="PRODUCTIVITY")
	private String productivity;
	
	@Lob
	@Column(name="QUALITY")
	private String quality;
	
	
	@Column(name="TIME_STAMP")
	private String timeStamp;
	
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getPersonal() {
		return personal;
	}
	public void setPersonal(String personal) {
		this.personal = personal;
	}
	public String getSelfImprovement() {
		return selfImprovement;
	}
	public void setSelfImprovement(String selfImprovement) {
		this.selfImprovement = selfImprovement;
	}
	public String getProductivity() {
		return productivity;
	}
	public void setProductivity(String productivity) {
		this.productivity = productivity;
	}
	public String getQuality() {
		return quality;
	}
	public void setQuality(String quality) {
		this.quality = quality;
	}
	public String getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}
	
	

}
