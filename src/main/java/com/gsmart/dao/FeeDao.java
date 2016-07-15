package com.gsmart.dao;

import java.util.List;

import com.gsmart.model.Fee;
import com.gsmart.util.GSmartDatabaseException;

public interface FeeDao{
	

	public List<Fee> getFeeList() throws GSmartDatabaseException;


	public void addFee(Fee fee) throws GSmartDatabaseException;


	public void editFee(Fee fee) throws GSmartDatabaseException;


	public void deleteFee(Fee fee)throws GSmartDatabaseException;
    
	public Fee getFeeStructure(String standard);
}