package com.gsmart.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.support.HttpAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import com.gsmart.model.Inventory;
import com.gsmart.services.InventoryServices;
import com.gsmart.util.CalendarCalculator;
import com.gsmart.util.Constants;
import com.gsmart.util.GSmartBaseException;
import com.gsmart.util.IAMResponse;

/**
 *  class-name : InventoryController.java
 * The InventoryController class implements an application that
 *  displays list of Inventory entities, add new Inventory entity,
 * edit available Inventory entity and delete available Inventory entity.
 * these functionalities are provided in {@link InventoryServices}
 * @author :
 * @version 1.0
 * @since 2016-02-23
 *
 */
@Controller
@RequestMapping(Constants.INVENTORY)
public class InventoryController {
	
	@Autowired
	InventoryServices inventoryServices;
	
	final Logger logger = Logger.getLogger(InventoryController.class);
	
	/**
	 * to view {@link Inventory} details.
	 * @param no parameters
	 * @return returns list of inventory entities present in the INVENTORY table 
	 * @see List
	 */
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity< List<Inventory>>getInventory() throws GSmartBaseException{
		logger.debug("Start :: InventoryController. getInventory");
		List<Inventory>inventoryList=null;
		try {
			inventoryList=inventoryServices.getInventoryList();
			
		} catch (Exception e) 
		{	
           e.printStackTrace();
		}
		logger.debug("End :: InventoryController. getInventory");
		return  new ResponseEntity<List<Inventory>>(inventoryList,HttpStatus.OK);
		
	}
	
	/**
	 * provide access to add a new inventory entity 
	 * @param inventory is instance of {@link Inventory}
	 * @return myResponse
	 */
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<IAMResponse>addInventory(@RequestBody Inventory inventory) throws GSmartBaseException
	{
		logger.debug("Start :: InventoryController.aadInventtory");
		IAMResponse myResponse;
		inventory.setTimeStamp(CalendarCalculator.getTimeStamp());
		inventoryServices.addInventory(inventory);
		myResponse = new IAMResponse("success");
		logger.debug("End :: InventoryController.aadInventtory");
		return new ResponseEntity<IAMResponse>(myResponse,HttpStatus.OK);
		
	}
	

	/*
	 * This method edit the value from INVENTORY Table.  
	 */

	/*
	 * Method Level Mapping "EDIT_INVENTORY".
	 * To perform editing existing Data to INVENTORY Table.
	 */
	
	
	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<IAMResponse> editInventory(@RequestBody Inventory inventory) throws GSmartBaseException
	{
		logger.debug("Start :: InventoryController.editInventtory");
		IAMResponse myResponse;
		inventoryServices.editInventory(inventory);
		myResponse = new IAMResponse("success");
		logger.debug("End :: InventoryController.editInventtory");
		return new ResponseEntity<IAMResponse>(myResponse ,HttpStatus.OK);
		
		
	}
	/*
	 * This method Delete the value from INVENTORY Table. 
	 */

	/*
	 * Method Level Mapping "DELETE_INVENTORY".
	 * To perform deleting Data to INVENTORY Table.
	 */
	
	@RequestMapping(method = RequestMethod.DELETE)
	public ResponseEntity<IAMResponse> deleteInventory(@RequestBody Inventory inventory) throws GSmartBaseException
	{
		logger.debug("Start :: InventoryController.deleteInventtory");
		IAMResponse myResponse;
		inventoryServices.deleteInventory(inventory);
		myResponse = new IAMResponse("success");
		logger.debug("End :: InventoryController.deleteInventtory");
		return new ResponseEntity<IAMResponse>(myResponse, HttpStatus.OK);
		
	}

}
