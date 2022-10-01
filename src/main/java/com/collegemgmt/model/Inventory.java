
package com.collegemgmt.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name="INVENTORY")
@IdClass(com.collegemgmt.model.CompoundInventory.class)
public class Inventory 
{
	/**
	 * name of the category
	 */
	@Id
	@Column(name="CATEGORY")
	private String category;
	
	/**
	 * name of the itemType
	 */
	@Id
	@Column(name="ITEM_TYPE")
	private String itemType;
	
	/**
	 *  Its a time when the  new inventory instance is add or edit
	 */
	@Column(name="TIME_STAMP")
	private String timeStamp;

	/**
	 * Gets the name of the category
	 * @return category, current name of the category
	 */
	
	public String getCategory() {
		return category;
	}

	/**
	 * Changes the name of the category
	 * @param category, new name of the category
	 */
	
	public void setCategory(String category) {
		this.category = category;
	}

	/**
	 * Gets the name of the itemType
	 * @return itemType, current name of the itemType
	 */
	
	public String getItemType() {
		return itemType;
	}

	/**
	 * Changes the name of the itemType
	 * @param itemType, new name of the itemType
	 */
	
	public void setItemType(String itemType) {
		this.itemType = itemType;
	}


	/**
	 * Gets the time from the system when we add or edit 
	 * @return timeStamp, current time  of the system
	 */
	
	public String getTimeStamp() {
		return timeStamp;
	}

	/**
	 * Changes the time of the timeStamp
	 * @param timeStamp, new time 
	 */
	
	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}
	
	
}
