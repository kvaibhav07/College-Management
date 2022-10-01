package com.collegemgmt.services;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.collegemgmt.dao.HierarchyDao;
import com.collegemgmt.model.Hierarchy;
import com.collegemgmt.util.collegemgmtServiceException;


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
	public List<Hierarchy> getHierarchyList() throws collegemgmtServiceException {
		logger.debug("Running :: HierarchyServicesImpl.getHierarchyList()");
		return hierarchyDao.getHierarchyList();
	}
	/*This addHierarchy() method will add Hierarchy value from the Hierarchy DAO and return to  Hierarchy Controller.*/


@Override
	public void addHierarchy(Hierarchy hierarchy) throws collegemgmtServiceException {
		logger.debug("Start :: HierarchyServicesImpl.addHierarchy()");
		try{
		hierarchyDao.addHierarchy(hierarchy);
		}
		catch (Exception e) {
			throw new collegemgmtServiceException(e.getMessage());
		}
		logger.debug("End :: HierarchyServicesImpl.addHierarchy()");
	}

/*This editHierarchy() method will edit Hierarchy value from the Hierarchy DAO and return to Hierarchy Controller.*/
	@Override
	public void editHierarchy(Hierarchy hierarchy) throws collegemgmtServiceException  {
		logger.debug("Start :: HierarchyServicesImpl.editHierarchy()");
		hierarchyDao.editHierarchy(hierarchy);
		logger.debug("End :: HierarchyServicesImpl.editHierarchy()");
	}

	/*This deleteHierarchy() method will delete Hierarchy  value from the Hierarchy  DAO and return to Hierarchy  Controller.*/

	@Override
	public void deleteHierarchy(Hierarchy hierarchy) throws collegemgmtServiceException {
		logger.debug("Start :: HierarchyServicesImpl.deleteHierarchy()");
		hierarchyDao.deleteHierarchy(hierarchy);		
		logger.debug("End :: HierarchyServicesImpl.deleteHierarchy()");
	}
	
}