package com.gsmart.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gsmart.model.Hierarchy;
import com.gsmart.services.HierarchyServices;
import com.gsmart.util.CalendarCalculator;
import com.gsmart.util.Constants;
import com.gsmart.util.GSmartBaseException;
import com.gsmart.util.IAMResponse;

@Controller
@RequestMapping(Constants.Hierarchy)
public class HierarchyController {

	@Autowired
	HierarchyServices hierarchyServices;

	final Logger logger = Logger.getLogger(HierarchyController.class);

	@RequestMapping( method = RequestMethod.GET)
	public ResponseEntity<List<Hierarchy>> getHierarchy() throws GSmartBaseException {
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
	public ResponseEntity<IAMResponse> addHierarchy(@RequestBody Hierarchy hierarchy) throws GSmartBaseException {
		logger.debug("Start :: HierarchyController.addHierarchy()");
		IAMResponse myResponse;
		hierarchy.setTimeStamp(CalendarCalculator.getTimeStamp());
		hierarchyServices.addHierarchy(hierarchy);
		myResponse = new IAMResponse("success");
		logger.debug("End :: HierarchyController.addHierarchy()");
		return new ResponseEntity<IAMResponse> (myResponse, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.PUT)
	public  ResponseEntity<IAMResponse> editHierarchy(@RequestBody Hierarchy hierarchy) throws GSmartBaseException {
		logger.debug("Start :: HierarchyController.editHierarchy()");
		IAMResponse myResponse;
		hierarchyServices.editHierarchy(hierarchy);
		myResponse = new IAMResponse("success");
		logger.debug("End :: HierarchyController.editHierarchy()");
		return new ResponseEntity<IAMResponse> (myResponse, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.DELETE)
	public  ResponseEntity<IAMResponse> deleteHierarchy(@RequestBody Hierarchy hierarchy) throws GSmartBaseException {
		logger.debug("Start :: HierarchyController.deleteHierarchy()");
		IAMResponse myResponse;
		hierarchyServices.deleteHierarchy(hierarchy);
		myResponse = new IAMResponse("success");
		logger.debug("End :: HierarchyController.deleteHierarchy()");
		return new ResponseEntity<IAMResponse> (myResponse, HttpStatus.OK);
	}

}
