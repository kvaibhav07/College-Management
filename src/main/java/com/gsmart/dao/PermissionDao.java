package com.gsmart.dao;

import java.util.List;

import com.gsmart.model.RolePermission;
import com.gsmart.util.GSmartBaseException;

public interface PermissionDao {

	public List<RolePermission> getPermissionList() throws GSmartBaseException;

	public void addPermission(RolePermission permission) throws GSmartBaseException;

	public void deletePermission(RolePermission permission) throws GSmartBaseException;

	public void editPermission(RolePermission permission)throws GSmartBaseException;

	
}
