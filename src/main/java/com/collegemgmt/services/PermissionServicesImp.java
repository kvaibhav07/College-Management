
package com.collegemgmt.services;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.collegemgmt.dao.PermissionDao;
import com.collegemgmt.model.RolePermission;
import com.collegemgmt.util.collegemgmtDatabaseException;
import com.collegemgmt.util.collegemgmtServiceException;
@Service
public class PermissionServicesImp implements PermissionServices {
	
	@Autowired
	PermissionDao permissionDao;
	
	final Logger logger = Logger.getLogger(PermissionServicesImp.class);
	
	@Override
	public List<RolePermission> getPermissionList()  throws collegemgmtServiceException{ 
		
		logger.debug("Running :: PermissionServiceImpl.getPermissionList()");
		try {
			return permissionDao.getPermissionList();
		} catch (collegemgmtDatabaseException exception) {
			throw (collegemgmtServiceException) exception;
		} catch (Exception e) {
			throw new collegemgmtServiceException(e.getMessage());
		}

	}

	@Override
	public void addPermission(RolePermission permission) throws collegemgmtServiceException {
		logger.debug("Running :: PermissionServiceImpl.getPermissionList()");
		try {
			 permissionDao.addPermission(permission);
		} catch (collegemgmtDatabaseException exception) {
			throw (collegemgmtServiceException) exception;
		} catch (Exception e) {
			throw new collegemgmtServiceException(e.getMessage());
		}

	}

	@Override
	public void editPermission(RolePermission permission) throws collegemgmtServiceException{
		logger.debug("Running :: PermissionServiceImpl.getPermissionList()");
		try {
			 permissionDao.editPermission(permission);
		} catch (collegemgmtDatabaseException exception) {
			throw (collegemgmtServiceException) exception;
		} catch (Exception e) {
			throw new collegemgmtServiceException(e.getMessage());
		}
		
	}

	@Override
	public void deletePermission(RolePermission permission) throws collegemgmtServiceException {
		logger.debug("Running :: PermissionServiceImpl.getPermissionList()");
		try {
			 permissionDao.deletePermission(permission);
		} catch (collegemgmtDatabaseException exception) {
			throw (collegemgmtServiceException) exception;
		} catch (Exception e) {
			throw new collegemgmtServiceException(e.getMessage());
		}
		
	}
	

	}