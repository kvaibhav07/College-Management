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

import com.gsmart.model.RolePermission;
import com.gsmart.services.PermissionServices;
import com.gsmart.util.CalendarCalculator;
import com.gsmart.util.Constants;
import com.gsmart.util.GSmartBaseException;
import com.gsmart.util.IAMResponse;

@Controller
@RequestMapping(Constants.PERMISSION)
public class PermissionController {

	@Autowired
	PermissionServices permissionServices;

	final Logger logger = Logger.getLogger(PermissionController.class);

	@RequestMapping( method = RequestMethod.GET)
	public ResponseEntity<List<RolePermission>> getPermission() throws GSmartBaseException {
		logger.debug("Start :: PermissionController.getPermission()");
		List<RolePermission> rolePermissionList = null;
		try {			
			rolePermissionList = permissionServices.getPermissionList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.debug("End :: PermissionController.getPermission()");
		return new ResponseEntity<List<RolePermission>>(rolePermissionList, HttpStatus.OK);
	}

	@RequestMapping( method = RequestMethod.POST)
	public ResponseEntity<IAMResponse> addPermission(@RequestBody RolePermission permission) throws GSmartBaseException {
		logger.debug("Start :: PermissionController.addPermission()");
		IAMResponse myResponse;
		permission.setTimeStamp(CalendarCalculator.getTimeStamp());
		permissionServices.addPermission(permission);
		myResponse = new IAMResponse("success");
		logger.debug("End :: PermissionController.addPermission()");
		return new ResponseEntity<IAMResponse> (myResponse, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.PUT)
	public  ResponseEntity<IAMResponse> editPermission(@RequestBody RolePermission permission) throws GSmartBaseException {
		logger.debug("Start :: PermissionController.editPermission()");
		IAMResponse myResponse;
		permissionServices.editPermission(permission);
		myResponse = new IAMResponse("success");
		logger.debug("End :: PermissionController.editPermission()");
		return new ResponseEntity<IAMResponse> (myResponse, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.DELETE)
	public  ResponseEntity<IAMResponse> deletePermission(@RequestBody RolePermission permission) throws GSmartBaseException {
		logger.debug("Start :: PermissionController.deletePermission()");
		IAMResponse myResponse;
		permissionServices.deletePermission(permission);
		myResponse = new IAMResponse("success");
		logger.debug("End :: PermissionController.deletePermission()");
		return new ResponseEntity<IAMResponse> (myResponse, HttpStatus.OK);
	}

}