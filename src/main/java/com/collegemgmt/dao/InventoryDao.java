
package com.collegemgmt.dao;

import java.util.List;

import com.collegemgmt.model.Inventory;
import com.collegemgmt.util.collegemgmtDatabaseException;

/**
 * 
 * Defines the behavior of all services provided in {@link InventoryServicesImpl}
 * The functionalities are implemented in {@link InventoryServicesImpl}
 * 
 * @author :
 * @version 1.0
 * @since 2016-02-23  
 */

public interface InventoryDao {
	
	/**
	 * @return list of inventory entities available in the {@link INVENTORY} Table
	 * @throws collegemgmtDatabaseException
	 */
	
	public List<Inventory>getInventoryList() throws collegemgmtDatabaseException;
	/**
	 * @param inventory instanceOf {@link Inventory}
	 * @return Nothing
	 * @throws  user define Exception
	 */
	
	
	public void addInventory(Inventory inventory)throws collegemgmtDatabaseException;
	
	/**
	 * @param inventory instanceOf {@link Inventory}
	 * @return Nothing
	 * @throws  user define Exception
	 */
	public void editInventory(Inventory inventory)throws collegemgmtDatabaseException;
	
	/**
	 * @param inventory instanceOf {@link Inventory}
	 * @return Nothing
	 * @throws  user define Exception
	 */
	public void deleteInventory(Inventory inventory)throws collegemgmtDatabaseException;
	

}
