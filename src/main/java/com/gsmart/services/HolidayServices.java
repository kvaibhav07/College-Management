package com.gsmart.services;

import java.util.List;

import com.gsmart.model.Holiday;
import com.gsmart.util.GSmartServiceException;

public interface HolidayServices {

	public List<Holiday> getHolidayList() throws GSmartServiceException;

	public void addHoliday(Holiday holiday) throws GSmartServiceException;

	public void editHoliday(Holiday holiday) throws GSmartServiceException;

	public void deleteHoliday(Holiday holiday)throws GSmartServiceException;

}
