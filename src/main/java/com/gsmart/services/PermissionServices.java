package com.gsmart.services;

import java.util.List;

import com.gsmart.model.RolePermission;
import com.gsmart.util.GSmartServiceException;

public interface PermissionServices {

	public List<RolePermission> getPermissionList() throws GSmartServiceException;

	public void editPermission(RolePermission permission) throws GSmartServiceException;

	public void deletePermission(RolePermission permission) throws GSmartServiceException;

	public void addPermission(RolePermission permission) throws GSmartServiceException;
}
