/*
* class name: HierarchyDao.java

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

package com.gsmart.dao;

import java.util.List;

import com.gsmart.model.Hierarchy;
import com.gsmart.util.GSmartDatabaseException;

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
	public List<Hierarchy> getHierarchyList() throws GSmartDatabaseException;
	/**
	 * @param hierarchy instanceOf {@link Hierarchy}
	 * @return Nothing
	 * @throws Exception
	 */
	public void addHierarchy(Hierarchy hierarchy) throws GSmartDatabaseException;
	/**
	 * @param hierarchy instanceOf {@link Hierarchy}
	 * @return Nothing
	 * @throws Exception
	 */
	public void editHierarchy(Hierarchy hierarchy) throws GSmartDatabaseException;
	/**
	 * @param hierarchy instanceOf {@link Hierarchy}
	 * @return Nothing
	 * @throws Exception
	 */
	public void deleteHierarchy(Hierarchy hierarchy)throws GSmartDatabaseException;


}