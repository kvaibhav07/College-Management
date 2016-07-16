package com.gsmart.services;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gsmart.dao.HolidayDao;
import com.gsmart.model.Holiday;
import com.gsmart.util.GSmartDatabaseException;
import com.gsmart.util.GSmartServiceException;

@Service
public class HolidayServicesImpl implements HolidayServices {

	
final Logger logger = Logger.getLogger(HolidayServicesImpl.class);
	
	@Autowired
	private HolidayDao holidayDao;
		
	
	@Override
	public List<Holiday> getHolidayList() throws GSmartServiceException {
	
	logger.debug("Running :: HolidayServiceImpl.getHolidayList()");
	try {
		return holidayDao.getHolidayList();
	} catch (GSmartDatabaseException exception) {
		throw (GSmartServiceException) exception;
	} catch (Exception e) {
		throw new GSmartServiceException(e.getMessage());
	}

	}

	@Override
	public void addHoliday(Holiday holiday) throws GSmartServiceException {
		logger.debug("Start :: HolidayServiceImpl.addHoliday()");
		try {
			holidayDao.addHoliday(holiday);
		} catch (GSmartDatabaseException exception) {
			throw (GSmartServiceException) exception;
		} catch (Exception e) {
			throw new GSmartServiceException(e.getMessage());
		}
		logger.debug("End :: HolidayServiceImpl.addHoliday()");
		
	}

	@Override
	public void editHoliday(Holiday holiday) throws GSmartServiceException {
		logger.debug("Start :: HolidayServiceImpl.editHoliday()");
		try {
			holidayDao.editHoliday(holiday);
		} catch (GSmartDatabaseException exception) {
			throw (GSmartServiceException) exception;
		} catch (Exception e) {
			throw new GSmartServiceException(e.getMessage());
		}
		logger.debug("End :: HolidayServiceImpl.editHoliday()");
	}

	@Override
	public void deleteHoliday(Holiday holiday) throws GSmartServiceException {
		logger.debug("Start :: HolidayServiceImpl.deleteHoliday()");
		try {
			holidayDao.deleteHoliday(holiday);
		} catch (GSmartDatabaseException exception) {
			throw (GSmartServiceException) exception;
		} catch (Exception e) {
			throw new GSmartServiceException(e.getMessage());
		}
		logger.debug("End :: HolidayServiceImpl.deleteHoliday()");

	}

}
