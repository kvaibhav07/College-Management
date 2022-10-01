package com.collegemgmt.services;

import java.util.List;

import com.collegemgmt.model.Hierarchy;
import com.collegemgmt.util.collegemgmtServiceException;

/**
 * class-name: HierarchyService.java
 * Assigning hierarchy for everyone 
 * from the institution to the section
 *   
 * @author 
 * @version 1.0
 * @since 2016-02-23  
 *
 */
/*
 *This is the HierarchyService.
 *It is an Interface.
 */

public interface HierarchyServices {
	/* All the abstract methods are defined in this Interface */
	
	public List<Hierarchy> getHierarchyList() throws collegemgmtServiceException;

	public void addHierarchy(Hierarchy hierarchy) throws collegemgmtServiceException;

	public void editHierarchy(Hierarchy hierarchy) throws collegemgmtServiceException;

	public void deleteHierarchy(Hierarchy hierarchy)throws collegemgmtServiceException;

	
	
}