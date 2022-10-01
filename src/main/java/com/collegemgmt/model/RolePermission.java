
package com.collegemgmt.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name="PERMISSION_MASTER")
@IdClass(com.collegemgmt.model.RolePermissionCompound.class)
public class RolePermission implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "TIMESTAMP")
	private String timeStamp;
	
	@Id
	@Column(name="ROLE")
	private String role;
	
	@Id
	@Column(name="MODULE_NAME")
	private String moduleName;
	
	@Column(name="P_ADD")
	private String add="N";
	
	@Column(name="P_VIEW")
	private String view="N";
	
	@Column(name="P_EDIT")
	private String edit="N";
	
	@Column(name="P_DEL")
	private String del="N";
	
	public String getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getModuleName() {
		return moduleName;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

	public String getAdd() {
		return add;
	}

	public void setAdd(String add) {
		this.add = add;
	}

	public String getView() {
		return view;
	}

	public void setView(String view) {
		this.view = view;
	}

	public String getEdit() {
		return edit;
	}

	public void setEdit(String edit) {
		this.edit = edit;
	}

	public String getDel() {
		return del;
	}

	public void setDel(String del) {
		this.del = del;
	}


	
}