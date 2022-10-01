package com.collegemgmt.dao;

import java.util.List;

import com.collegemgmt.model.Band;
import com.collegemgmt.util.collegemgmtDatabaseException;
/**
 * 
 * Defines the behavior of all services provided in {@link BandServicesImpl}
 * The functionalities are implemented in {@link BandDaoImpl}
 * 
 * @author :Kuvar Vaibhav Singh
 * @version 1.0
 * @since 2016-02-23  
 */
public interface BandDao {
	
	/**
	 * @return list of Band entities available in the {@link Band} Table
	 * @throws collegemgmtDatabaseException
	 */
	public List<Band> getBandList() throws collegemgmtDatabaseException;
	
	/**
	 * @param band instanceOf {@link Band}
	 * @return Nothing
	 * @throws collegemgmtDatabaseException
	 */

	public void addBand(Band band) throws collegemgmtDatabaseException;
	
	/**
	 * @param band instanceOf {@link Band}
	 * @return Nothing
	 * @throws collegemgmtDatabaseException
	 */

	public void editBand(Band band) throws collegemgmtDatabaseException;

	/**
	 * @param band instanceOf {@link Band}
	 * @return Nothing
	 * @throws collegemgmtDatabaseException
	 */
	public void deleteBand(Band band)throws collegemgmtDatabaseException;

}
