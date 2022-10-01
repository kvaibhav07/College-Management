package com.collegemgmt.services;

import java.util.List;

import com.collegemgmt.model.Fee;
import com.collegemgmt.util.collegemgmtServiceException;

public interface FeeServices 
{

	
	public List<Fee> getFeeList() throws collegemgmtServiceException;

	public void addFee(Fee fee) throws collegemgmtServiceException;

	public void editFee(Fee fee) throws collegemgmtServiceException;

	public void deleteFee(Fee fee)throws collegemgmtServiceException;


}