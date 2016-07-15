package com.gsmart.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gsmart.model.Inventory;
import com.gsmart.util.Constants;
import com.gsmart.util.GSmartDatabaseException;

/**
 * provides the implementation for the methods available in {@link InventoryDao} interface
 * @author :
 * @version 1.0
 * @since 2016-02-23  
 */
@Repository
public class InventoryDaoImpl implements InventoryDao{
	
	@Autowired
	SessionFactory sessionFactory;
	
	Session session=null;
	Transaction transaction=null;
	Query query;
	
	final Logger logger = Logger.getLogger(InventoryDaoImpl.class);
     
	/**
	 * to view the list of records available in {@link INVENTORY} table
	 * @return list of inventory entities available in Inventory
	 * @throws user define Exception
	 */
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Inventory> getInventoryList() throws GSmartDatabaseException {
		logger.debug("Start :: InventoryDaoImpl.getInventoryList()");
		List<Inventory> inventoryList;
		try {
			getconnection();
			query=session.createQuery("from Inventory");
			inventoryList=query.list();
			
		} catch (Exception e) {
			throw new GSmartDatabaseException(e.getMessage());
			
		}finally{
			session.close();
		}
		logger.debug("End :: InventoryDaoImpl.getInventoryList()");
		return inventoryList;
	}

	
	/**
	 * Adds new inventory entity to {@link Inventory}
	 * and save it in the database.
	 * commit the changes in the database.
	 * @param inventory instance of {@link Inventory}
	 * @return Nothing
	 * @throws user define Exception
	 */

	@Override
	public void addInventory(Inventory inventory) throws GSmartDatabaseException {
		
		logger.debug("Start :: InventoryDaoImpl.addInventory()");
		try {
			getconnection();
			session.save(inventory);
			transaction.commit();
			
		} catch (ConstraintViolationException e) {
			throw new GSmartDatabaseException(Constants.CONSTRAINT_VIOLATION);
		}catch (Exception e) {
			throw new GSmartDatabaseException(e.getMessage());
		}finally {
			session.close();
		}
		logger.debug("End :: InventoryDaoImpl.addInventory()");
		
	}
	
	
	/**
	 * Changes the status of INVENTORY Table with {@query timeStamp} as timeStamp by calling {@link executeUpdate} method
	 * and commit the changes in the database.
	 * @param inventory instance of {@link Inventory}
	 * @return Nothing
	 * @throws user define Exception
	 */
	@Override
	public void editInventory(Inventory inventory) throws GSmartDatabaseException {
		logger.debug("Start :: InventoryDaoImpl.editInventory()");
		try {
			getconnection();
			
			query=session.createQuery("update Inventory set category=:category,itemType=:itemType where timeStamp=:timeStamp");
			query.setParameter("timeStamp",inventory.getTimeStamp());
			query.setParameter("category",inventory.getCategory());
			query.setParameter("itemType", inventory.getItemType());
			query.executeUpdate();
			transaction.commit();
			
		} catch (ConstraintViolationException e) {
			throw new GSmartDatabaseException(Constants.CONSTRAINT_VIOLATION);
		}catch (Exception e) {
			throw new GSmartDatabaseException(e.getMessage());
			
		}finally {
			session.close();
		}
		logger.debug("End :: InventoryDaoImpl.editInventory()");
		
	}

	/** 
	 * Delete the record and commit the changes in the database
	 * @param inventory instanceOf {@link Inventory}
	 * @return Nothing
	 * @throws user define Exception
	 */
	@Override
	public void deleteInventory(Inventory inventory) throws GSmartDatabaseException {
		try {
			getconnection();
			session.delete(inventory);
			transaction.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		
	}
	private void getconnection() {
		session = sessionFactory.openSession();
		transaction = session.beginTransaction();
	
	}

}
