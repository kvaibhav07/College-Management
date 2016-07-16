
package com.gsmart.services;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gsmart.dao.PermissionDao;
import com.gsmart.model.RolePermission;
import com.gsmart.util.GSmartDatabaseException;
import com.gsmart.util.GSmartServiceException;
@Service
public class PermissionServicesImp implements PermissionServices {
	
	@Autowired
	PermissionDao permissionDao;
	
	final Logger logger = Logger.getLogger(PermissionServicesImp.class);
	
	@Override
	public List<RolePermission> getPermissionList()  throws GSmartServiceException{ 
		
		logger.debug("Running :: PermissionServiceImpl.getPermissionList()");
		try {
			return permissionDao.getPermissionList();
		} catch (GSmartDatabaseException exception) {
			throw (GSmartServiceException) exception;
		} catch (Exception e) {
			throw new GSmartServiceException(e.getMessage());
		}

	}

	@Override
	public void addPermission(RolePermission permission) throws GSmartServiceException {
		logger.debug("Running :: PermissionServiceImpl.getPermissionList()");
		try {
			 permissionDao.addPermission(permission);
		} catch (GSmartDatabaseException exception) {
			throw (GSmartServiceException) exception;
		} catch (Exception e) {
			throw new GSmartServiceException(e.getMessage());
		}

	}

	@Override
	public void editPermission(RolePermission permission) throws GSmartServiceException{
		logger.debug("Running :: PermissionServiceImpl.getPermissionList()");
		try {
			 permissionDao.editPermission(permission);
		} catch (GSmartDatabaseException exception) {
			throw (GSmartServiceException) exception;
		} catch (Exception e) {
			throw new GSmartServiceException(e.getMessage());
		}
		
	}

	@Override
	public void deletePermission(RolePermission permission) throws GSmartServiceException {
		logger.debug("Running :: PermissionServiceImpl.getPermissionList()");
		try {
			 permissionDao.deletePermission(permission);
		} catch (GSmartDatabaseException exception) {
			throw (GSmartServiceException) exception;
		} catch (Exception e) {
			throw new GSmartServiceException(e.getMessage());
		}
		
	}
	

	}