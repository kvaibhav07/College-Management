package com.collegemgmt.services;

import java.util.List;

import com.collegemgmt.model.Inventory;
import com.collegemgmt.util.collegemgmtServiceException;
/**
 * Provides services for {@link InventoryController}
 * The functionalities are defined in {@link InventoryServicesImpl}  
 * @author :
 * @version 1.0
 * @since 2016-02-23  
 */

public interface InventoryServices {
	
	/**
	 * @return list of inventory entities available in the INVENTORY Table
	 * @throws user define Exception
	 * @see List
	 */
	
	public List<Inventory>getInventoryList() throws collegemgmtServiceException;
	
	/**
	 * @param inventory instanceOf {@link Inventory}
	 * @return nothing
	 * @throws user define Exception
	 */
	public void addInventory(Inventory inventory) throws collegemgmtServiceException;
	
	/**
	 * @param inventory instanceOf {@link Inventory}
	 * @return nothing
	 * @throws user define Exception
	 */
	public void editInventory(Inventory inventory)throws collegemgmtServiceException;
	
	/**
	 * @param inventory instanceOf {@link Inventory}
	 * @return nothing
	 * @throws user define Exception
	 */
	public void deleteInventory(Inventory inventory) throws collegemgmtServiceException;
}
