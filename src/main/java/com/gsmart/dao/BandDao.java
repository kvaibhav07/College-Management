package com.gsmart.dao;

import java.util.List;

import com.gsmart.model.Band;
import com.gsmart.util.GSmartDatabaseException;

public interface BandDao {
	
	public List<Band> getBandList() throws GSmartDatabaseException;


	public void addBand(Band band) throws GSmartDatabaseException;


	public void editBand(Band band) throws GSmartDatabaseException;


	public void deleteBand(Band band)throws GSmartDatabaseException;

}
