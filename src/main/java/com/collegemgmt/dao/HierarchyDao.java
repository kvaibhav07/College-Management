package com.collegemgmt.dao;

import java.util.List;

import com.collegemgmt.model.Hierarchy;
import com.collegemgmt.util.collegemgmtDatabaseException;

/**
 * class-name: HierarchyDao.java
 * Assigning hierarchy for everyone 
 * from the institution to the section
 *   
 * @author 
 * @version 1.0
 * @since 2016-02-23  
 *
 */
/*
 *This is the HierarchyDao .
 *It is an Interface.
 */
public interface HierarchyDao {

	/**
	 * @return list of Hierarchy entities available in the {@link Hierarchy} Table
	 * @throws Exception
	 */
	public List<Hierarchy> getHierarchyList() throws collegemgmtDatabaseException;
	/**
	 * @param hierarchy instanceOf {@link Hierarchy}
	 * @return Nothing
	 * @throws Exception
	 */
	public void addHierarchy(Hierarchy hierarchy) throws collegemgmtDatabaseException;
	/**
	 * @param hierarchy instanceOf {@link Hierarchy}
	 * @return Nothing
	 * @throws Exception
	 */
	public void editHierarchy(Hierarchy hierarchy) throws collegemgmtDatabaseException;
	/**
	 * @param hierarchy instanceOf {@link Hierarchy}
	 * @return Nothing
	 * @throws Exception
	 */
	public void deleteHierarchy(Hierarchy hierarchy)throws collegemgmtDatabaseException;


}