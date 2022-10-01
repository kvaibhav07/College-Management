package com.collegemgmt.dao;

import java.util.List;

import com.collegemgmt.model.Fee;
import com.collegemgmt.util.collegemgmtDatabaseException;

public interface FeeDao{
	

	public List<Fee> getFeeList() throws collegemgmtDatabaseException;


	public void addFee(Fee fee) throws collegemgmtDatabaseException;


	public void editFee(Fee fee) throws collegemgmtDatabaseException;


	public void deleteFee(Fee fee)throws collegemgmtDatabaseException;
    
	public Fee getFeeStructure(String standard);
}