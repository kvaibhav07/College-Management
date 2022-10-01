package com.collegemgmt.services;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.collegemgmt.dao.InventoryDao;
import com.collegemgmt.model.Inventory;
import com.collegemgmt.util.collegemgmtDatabaseException;
import com.collegemgmt.util.collegemgmtServiceException;

/**
 * Provides implementation for services declared in  {@link InventoryServices} interface.
 * it will go to {@link inventoryDao}
 * @author :
 * @version 1.0
 * @since 2016-02-23  
 */
@Service
public class InventoryServicesImpl implements InventoryServices {
	
	
	final Logger logger= Logger. getLogger(InventoryServicesImpl.class);
	
	@Autowired
	private InventoryDao inventoryDao;
	
	/**
	 * @return calls {@link InventoryDao}'s <code>getInventoryList()</code> method
	 * @see List 
	 */

	@Override
	public List<Inventory> getInventoryList() throws collegemgmtServiceException {
		logger.debug("Running ::InventoryServicesImpl.getInventoryList()" );
		try {
			return inventoryDao.getInventoryList();
		} catch (collegemgmtDatabaseException Exception ) {
			throw(collegemgmtServiceException) Exception;
			
		}catch (Exception e) {
			throw new collegemgmtServiceException(e.getMessage());
		}
		
		
	}

	/**
	 * calls {@link InventoryDao}'s <code>addInventory(...)</code> method
	 * @param inventory an instance of {@link Inventory} class
	 * @throws user define Exception
	 */
	@Override
	public void addInventory(Inventory inventory) throws collegemgmtServiceException {
		logger.debug("Start :: InventoryServicesImpl.addInventory()");
		try {
			inventoryDao.addInventory(inventory);
			
		}catch (collegemgmtDatabaseException exception) {
			throw (collegemgmtServiceException) exception;
		} 
		catch (Exception e) {
			throw new collegemgmtServiceException(e.getMessage());
		}
		logger.debug("End :: InventoryServicesImpl.addInventory()");
		
	}

	/**
	 * calls {@link InventoryDao}'s <code>editInventory(...)</code> method
	 * @param inventory an instance of {@link Inventory} class
	 * @throws user define Exception
	 */
	
	@Override
	public void editInventory(Inventory inventory) throws collegemgmtServiceException {
		logger.debug("Start :: InventoryServicesImpl.editInventory()");
		try {
			inventoryDao.editInventory(inventory);
			
		} catch (collegemgmtDatabaseException exception) {
			throw (collegemgmtServiceException) exception;
		} 
		catch (Exception e) {

			throw new collegemgmtServiceException(e.getMessage());
			
		}
		
		logger.debug("End :: InventoryServicesImpl.editInventory()");
	}

	/**
	 * calls {@link InventoryDao}'s <code>deleteInventory(...)</code> method
	 * @param inventory an instance of {@link Inventory} class
	 * @throws user define Exception
	 */	
	@Override
	public void deleteInventory(Inventory inventory) throws collegemgmtServiceException {
		
		logger.debug("Start :: InventoryServicesImpl.deleteInventory()");
		try {
			inventoryDao.deleteInventory(inventory);
			
		}catch (collegemgmtDatabaseException exception) {
			throw (collegemgmtServiceException) exception;
		}  
		catch (Exception e) {
			throw new collegemgmtServiceException(e.getMessage());
		}
		
		logger.debug("End :: InventoryServicesImpl.deleteInventory()");
			
	}

}
