package com.gsmart.services;

import java.util.List;

import com.gsmart.model.Fee;
import com.gsmart.util.GSmartServiceException;

public interface FeeServices 
{

	
	public List<Fee> getFeeList() throws GSmartServiceException;

	public void addFee(Fee fee) throws GSmartServiceException;

	public void editFee(Fee fee) throws GSmartServiceException;

	public void deleteFee(Fee fee)throws GSmartServiceException;


}