package com.collegemgmt.services;

import java.util.List;

import com.collegemgmt.model.RolePermission;
import com.collegemgmt.util.collegemgmtServiceException;

public interface PermissionServices {

	public List<RolePermission> getPermissionList() throws collegemgmtServiceException;

	public void editPermission(RolePermission permission) throws collegemgmtServiceException;

	public void deletePermission(RolePermission permission) throws collegemgmtServiceException;

	public void addPermission(RolePermission permission) throws collegemgmtServiceException;
}
