package com.collegemgmt.dao;

import java.util.List;
import com.collegemgmt.model.Holiday;
import com.collegemgmt.util.collegemgmtDatabaseException;

public interface HolidayDao {

	public List<Holiday> getHolidayList() throws collegemgmtDatabaseException;


	public void addHoliday(Holiday holiday) throws collegemgmtDatabaseException;


	public void editHoliday(Holiday holiday) throws collegemgmtDatabaseException;


	public void deleteHoliday(Holiday holiday)throws collegemgmtDatabaseException;

}
