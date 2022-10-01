package com.collegemgmt.services;

import java.util.List;

import com.collegemgmt.model.Holiday;
import com.collegemgmt.util.collegemgmtServiceException;

public interface HolidayServices {

	public List<Holiday> getHolidayList() throws collegemgmtServiceException;

	public void addHoliday(Holiday holiday) throws collegemgmtServiceException;

	public void editHoliday(Holiday holiday) throws collegemgmtServiceException;

	public void deleteHoliday(Holiday holiday)throws collegemgmtServiceException;

}
