package com.collegemgmt.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.collegemgmt.model.Hierarchy;
import com.collegemgmt.services.HierarchyServices;
import com.collegemgmt.util.CalendarCalculator;
import com.collegemgmt.util.Constants;
import com.collegemgmt.util.collegemgmtBaseException;
import com.collegemgmt.util.IAMResponse;

@Controller
@RequestMapping(Constants.HIERARCHY)
public class HierarchyController {

	@Autowired
	HierarchyServices hierarchyServices;

	final Logger logger = Logger.getLogger(HierarchyController.class);

	@RequestMapping( method = RequestMethod.GET)
	public ResponseEntity<List<Hierarchy>> getHierarchy() throws collegemgmtBaseException {
		logger.debug("Start :: HierarchyController.getHierarchy()");
		List<Hierarchy> hierarchyList = null;
		try {			
			hierarchyList = hierarchyServices.getHierarchyList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.debug("End :: HierarchyController.getHierarchy()");
		return new ResponseEntity<List<Hierarchy>>(hierarchyList, HttpStatus.OK);
	}

	@RequestMapping( method = RequestMethod.POST)
	public ResponseEntity<IAMResponse> addHierarchy(@RequestBody Hierarchy hierarchy) throws collegemgmtBaseException {
		logger.debug("Start :: HierarchyController.addHierarchy()");
		IAMResponse myResponse;
		hierarchy.setTimeStamp(CalendarCalculator.getTimeStamp());
		hierarchyServices.addHierarchy(hierarchy);
		myResponse = new IAMResponse("success");
		logger.debug("End :: HierarchyController.addHierarchy()");
		return new ResponseEntity<IAMResponse> (myResponse, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.PUT)
	public  ResponseEntity<IAMResponse> editHierarchy(@RequestBody Hierarchy hierarchy) throws collegemgmtBaseException {
		logger.debug("Start :: HierarchyController.editHierarchy()");
		IAMResponse myResponse;
		hierarchyServices.editHierarchy(hierarchy);
		myResponse = new IAMResponse("success");
		logger.debug("End :: HierarchyController.editHierarchy()");
		return new ResponseEntity<IAMResponse> (myResponse, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.DELETE)
	public  ResponseEntity<IAMResponse> deleteHierarchy(@RequestBody Hierarchy hierarchy) throws collegemgmtBaseException {
		logger.debug("Start :: HierarchyController.deleteHierarchy()");
		IAMResponse myResponse;
		hierarchyServices.deleteHierarchy(hierarchy);
		myResponse = new IAMResponse("success");
		logger.debug("End :: HierarchyController.deleteHierarchy()");
		return new ResponseEntity<IAMResponse> (myResponse, HttpStatus.OK);
	}

}
