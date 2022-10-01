package com.collegemgmt.dao;

import java.util.List;

import com.collegemgmt.model.RolePermission;
import com.collegemgmt.util.collegemgmtBaseException;

public interface PermissionDao {

	public List<RolePermission> getPermissionList() throws collegemgmtBaseException;

	public void addPermission(RolePermission permission) throws collegemgmtBaseException;

	public void deletePermission(RolePermission permission) throws collegemgmtBaseException;

	public void editPermission(RolePermission permission)throws collegemgmtBaseException;

	
}
