package com.gsmart.services;

import java.util.List;

import com.gsmart.model.Band;
import com.gsmart.util.GSmartServiceException;

public interface BandServices {
	
	public List<Band> getBandList() throws GSmartServiceException;

	public void addBand(Band band) throws GSmartServiceException;

	public void editBand(Band band) throws GSmartServiceException;

	public void deleteBand(Band band)throws GSmartServiceException;

}
