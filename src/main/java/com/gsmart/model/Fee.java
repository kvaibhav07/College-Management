package com.gsmart.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "FEE_MASTER")
//@IdClass(com.gsmart.model.CompoundFee.class)
public class Fee {
	@Id
	@Column(name = "STANDARD")
	private String standard;
	@Column(name = "TIME_STAMP")
	private String timeStamp;
	@Column(name = "SPORTS_FEE")
	private Integer sportsFee;
	@Column(name = "TUITION_FEE")
	private Integer tuitionFee;
	@Column(name = "TRANSPORTATION_FEE")
	private Integer transportationFee;
	@Column(name = "MISCELLANEOUS_FEE")
	private Integer miscellaneousFee;
	@Column(name = "TOTAL_FEE")
	private Integer totalFee;
	
	public String getStandard() {
		return standard;
	}
	public void setStandard(String standard) {
		this.standard = standard;
	}
	public String getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}
	public Integer getSportsFee() {
		return sportsFee;
	}
	public void setSportsFee(Integer sportsFee) {
		this.sportsFee = sportsFee;
	}
	public Integer getTuitionFee() {
		return tuitionFee;
	}
	public void setTuitionFee(Integer tuitionFee) {
		this.tuitionFee = tuitionFee;
	}
	public Integer getTransportationFee() {
		return transportationFee;
	}
	public void setTransportationFee(Integer transportationFee) {
		this.transportationFee = transportationFee;
	}
	public Integer getMiscellaneousFee() {
		return miscellaneousFee;
	}
	public void setMiscellaneousFee(Integer miscellaneousFee) {
		this.miscellaneousFee = miscellaneousFee;
	}
	public Integer getTotalFee() {
		return totalFee;
	}
	public void setTotalFee(Integer totalFee) {
		this.totalFee = totalFee;
	}
	
	
}