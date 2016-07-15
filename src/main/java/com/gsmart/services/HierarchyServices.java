/*
* class name: HierarchyService.java

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

import com.gsmart.model.Hierarchy;
import com.gsmart.util.GSmartServiceException;

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
	
	public List<Hierarchy> getHierarchyList() throws GSmartServiceException;

	public void addHierarchy(Hierarchy hierarchy) throws GSmartServiceException;

	public void editHierarchy(Hierarchy hierarchy) throws GSmartServiceException;

	public void deleteHierarchy(Hierarchy hierarchy)throws GSmartServiceException;

	
	
}