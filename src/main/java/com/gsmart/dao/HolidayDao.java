package com.gsmart.dao;

import java.util.List;


import com.gsmart.model.Holiday;
import com.gsmart.util.GSmartDatabaseException;

public interface HolidayDao {

	public List<Holiday> getHolidayList() throws GSmartDatabaseException;


	public void addHoliday(Holiday holiday) throws GSmartDatabaseException;


	public void editHoliday(Holiday holiday) throws GSmartDatabaseException;


	public void deleteHoliday(Holiday holiday)throws GSmartDatabaseException;

}
