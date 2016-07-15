/*
* class name:HierarchyServicesImpl.java

 *
 * Copyright (c) 2008-2009 Gowdanar Technologies Pvt. Ltd. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Gowdanar
 * Technologies Pvt. Ltd.("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Gowdanar Technologie.
 *
 * GOWDANAR TECHNOLOGIES MAKES NO REPRESENTATIONS OR WARRANTIES ABOUT THE SUITABILITY OF
 * THE SOFTWARE, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED
 * TO THE IMPLIED WARRANTIES OF MERCHANTABILITY, FITNESS FOR A
 * PARTICULAR PURPOSE, OR NON-INFRINGEMENT. GOWDANAR TECHNOLOGIES SHALL NOT BE LIABLE FOR
 * ANY DAMAGES SUFFERED BY LICENSEE AS A RESULT OF USING, MODIFYING OR
 * DISTRIBUTING
 */

package com.gsmart.services;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gsmart.dao.HierarchyDao;
import com.gsmart.model.Hierarchy;
import com.gsmart.util.GSmartServiceException;
import com.gsmart.util.GSmartServiceException;


/**
 * class-name:  HierarchyServicesImpl.java
 * Assigning hierarchy for everyone 
 * from the institution to the section
 *   
 * @author 
 * @version 1.0
 * @since 2016-02-23  
 *
 */
@Service
public class HierarchyServicesImpl implements HierarchyServices {

	final Logger logger = Logger.getLogger(HierarchyServicesImpl.class);
	
	/** This class provides the service to Controller and DAO classes.*/

	/** The variable hierarchyDAO is a reference variable of type HierarchyDao. */
	@Autowired
	HierarchyDao hierarchyDao;
	/*This getHierarchyList() method will get Hierarchy value from the HierarchyDAO and return to Hierarchy Controller.*/

	
	@Override
	public List<Hierarchy> getHierarchyList() throws GSmartServiceException {
		logger.debug("Running :: HierarchyServicesImpl.getHierarchyList()");
		return hierarchyDao.getHierarchyList();
	}
	/*This addHierarchy() method will add Hierarchy value from the Hierarchy DAO and return to  Hierarchy Controller.*/


@Override
	public void addHierarchy(Hierarchy hierarchy) throws GSmartServiceException {
		logger.debug("Start :: HierarchyServicesImpl.addHierarchy()");
		try{
		hierarchyDao.addHierarchy(hierarchy);
		}
		catch (Exception e) {
			throw new GSmartServiceException(e.getMessage());
		}
		logger.debug("End :: HierarchyServicesImpl.addHierarchy()");
	}

/*This editHierarchy() method will edit Hierarchy value from the Hierarchy DAO and return to Hierarchy Controller.*/
	@Override
	public void editHierarchy(Hierarchy hierarchy) throws GSmartServiceException  {
		logger.debug("Start :: HierarchyServicesImpl.editHierarchy()");
		hierarchyDao.editHierarchy(hierarchy);
		logger.debug("End :: HierarchyServicesImpl.editHierarchy()");
	}

	/*This deleteHierarchy() method will delete Hierarchy  value from the Hierarchy  DAO and return to Hierarchy  Controller.*/

	@Override
	public void deleteHierarchy(Hierarchy hierarchy) throws GSmartServiceException {
		logger.debug("Start :: HierarchyServicesImpl.deleteHierarchy()");
		hierarchyDao.deleteHierarchy(hierarchy);		
		logger.debug("End :: HierarchyServicesImpl.deleteHierarchy()");
	}
	
}