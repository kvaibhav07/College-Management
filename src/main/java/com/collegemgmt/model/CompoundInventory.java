
package com.collegemgmt.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
/**
 * This is the CompoundInventory.
 * @author :
 */

@Embeddable

public class CompoundInventory implements Serializable{
	private static final long serialVersionUID = 1L;

	 private String category;
	 private String itemType;
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getItemType() {
		return itemType;
	}
	public void setItemType(String itemType) {
		this.itemType = itemType;
	}
	 
	

}
