package com.gsmart.dao;

import java.util.List;

import com.gsmart.model.Band;
import com.gsmart.util.GSmartDatabaseException;
/**
 * 
 * Defines the behavior of all services provided in {@link BandServicesImpl}
 * The functionalities are implemented in {@link BandDaoImpl}
 * 
 * @author :Nirmal Raj J
 * @version 1.0
 * @since 2016-02-23  
 */
public interface BandDao {
	
	/**
	 * @return list of Band entities available in the {@link Band} Table
	 * @throws GSmartDatabaseException
	 */
	public List<Band> getBandList() throws GSmartDatabaseException;
	
	/**
	 * @param band instanceOf {@link Band}
	 * @return Nothing
	 * @throws GSmartDatabaseException
	 */

	public void addBand(Band band) throws GSmartDatabaseException;
	
	/**
	 * @param band instanceOf {@link Band}
	 * @return Nothing
	 * @throws GSmartDatabaseException
	 */

	public void editBand(Band band) throws GSmartDatabaseException;

	/**
	 * @param band instanceOf {@link Band}
	 * @return Nothing
	 * @throws GSmartDatabaseException
	 */
	public void deleteBand(Band band)throws GSmartDatabaseException;

}
