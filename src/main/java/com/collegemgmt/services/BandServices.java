package com.collegemgmt.services;

import java.util.List;

import com.collegemgmt.model.Band;
import com.collegemgmt.util.collegemgmtServiceException;

/**
 * Provides services for {@link BandController}.
 * The functionalities are defined in {@link BandServicesImpl}
 * @author :Kuvar Vaibhav Singh
 * @version 1.0
 * @since 2016-02-23
 */
public interface BandServices {
	
	/**
	 * @return list of Band entities available in the Band Table
	 * @throws collegemgmtServiceException
	 */
	public List<Band> getBandList() throws collegemgmtServiceException;
	
	/**
	 * @param band instanceOf {@link Band}
	 * @return nothing
	 * @throws collegemgmtServiceException
	 */
	public void addBand(Band band) throws collegemgmtServiceException;
	
	/**
	 * @param band instanceOf {@link Band}
	 * @return nothing
	 * @throws collegemgmtServiceException
	 */
	public void editBand(Band band) throws collegemgmtServiceException;
	
	/**
	 * @param band instanceOf {@link Band}
	 * @return nothing
	 * @throws collegemgmtServiceException
	 */
	public void deleteBand(Band band)throws collegemgmtServiceException;

}
