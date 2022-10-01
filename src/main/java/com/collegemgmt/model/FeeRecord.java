package com.collegemgmt.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "FeeRecord")
//@IdClass(com.collegemgmt.model.CompoundFeeRecord.class)
public class FeeRecord 
{
	@Id
	@Column(name="STUDENT_ID")
	private int studentId;
	@Id
	@Column(name="STANDARD")
	private String standard;
	@Id
	@Column(name="MONTH_YEAR")
	private String monthYear;
	@Column(name="TOTAL_FEE")
	private int totalFee;
	@Column(name="STUDENT_NAME")
	private String studentName;
	@Column(name="PAID_DATE")
	private String paidDate;
	@Column(name="PAID_FEE")
	private int paidFee;
	@Column(name="BALANCE_FEE")
	private int balanceFee;
	@Column(name="MODE_OF_PAYMENT")
	private String modeOfPayment;
	@Column(name="CONSESSION")
	private String consession;
	@Column(name="CONSESSION_AMT")
	private int consessionAmt;
	@Column(name="FEE_STATUS")
	private String feeStatus;
	@Column(name="SPORTS_FEE")
	private int sportsFee;
	@Column(name="TUTION_FEE")
	private int tuitionFee;
	@Column(name="TRANSPORTATION_FEE")
	private int transportationFee;
	@Column(name="MISCELLANEOUS_FEE")
	private int miscellaneousFee;
	@Column(name="SMARTID")
	private Integer smartId;
	
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getStandard() {
		return standard;
	}
	public void setStandard(String standard) {
		this.standard = standard;
	}
	public String getMonthYear() {
		return monthYear;
	}
	public void setMonthYear(String monthYear) {
		this.monthYear = monthYear;
	}
	public int getTotalFee() {
		return totalFee;
	}
	public void setTotalFee(int totalFee) {
		this.totalFee = totalFee;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getPaidDate() {
		return paidDate;
	}
	public void setPaidDate(String paidDate) {
		this.paidDate = paidDate;
	}
	public int getPaidFee() {
		return paidFee;
	}
	public void setPaidFee(int paidFee) {
		this.paidFee = paidFee;
	}
	public int getBalanceFee() {
		return balanceFee;
	}
	public void setBalanceFee(int balanceFee) {
		this.balanceFee = balanceFee;
	}
	public String getModeOfPayment() {
		return modeOfPayment;
	}
	public void setModeOfPayment(String modeOfPayment) {
		this.modeOfPayment = modeOfPayment;
	}
	public String getConsession() {
		return consession;
	}
	public void setConsession(String consession) {
		this.consession = consession;
	}
	public int getConsessionAmt() {
		return consessionAmt;
	}
	public void setConsessionAmt(int consessionAmt) {
		this.consessionAmt = consessionAmt;
	}
	public String getFeeStatus() {
		return feeStatus;
	}
	public void setFeeStatus(String feeStatus) {
		this.feeStatus = feeStatus;
	}
	public int getSportsFee() {
		return sportsFee;
	}
	public void setSportsFee(int sportsFee) {
		this.sportsFee = sportsFee;
	}
	public int getTuitionFee() {
		return tuitionFee;
	}
	public void setTuitionFee(int tuitionFee) {
		this.tuitionFee = tuitionFee;
	}
	public int getTransportationFee() {
		return transportationFee;
	}
	public void setTransportationFee(int transportationFee) {
		this.transportationFee = transportationFee;
	}
	public int getMiscellaneousFee() {
		return miscellaneousFee;
	}
	public void setMiscellaneousFee(int miscellaneousFee) {
		this.miscellaneousFee = miscellaneousFee;
	}
	public Integer getSmartId() {
		return smartId;
	}
	public void setSmartId(Integer smartId) {
		this.smartId = smartId;
	}
	
}