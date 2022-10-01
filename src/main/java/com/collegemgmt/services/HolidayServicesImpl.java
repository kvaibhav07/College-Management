package com.collegemgmt.services;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.collegemgmt.dao.HolidayDao;
import com.collegemgmt.model.Holiday;
import com.collegemgmt.util.collegemgmtDatabaseException;
import com.collegemgmt.util.collegemgmtServiceException;

@Service
public class HolidayServicesImpl implements HolidayServices {

	
final Logger logger = Logger.getLogger(HolidayServicesImpl.class);
	
	@Autowired
	private HolidayDao holidayDao;
		
	
	@Override
	public List<Holiday> getHolidayList() throws collegemgmtServiceException {
	
	logger.debug("Running :: HolidayServiceImpl.getHolidayList()");
	try {
		return holidayDao.getHolidayList();
	} catch (collegemgmtDatabaseException exception) {
		throw (collegemgmtServiceException) exception;
	} catch (Exception e) {
		throw new collegemgmtServiceException(e.getMessage());
	}

	}

	@Override
	public void addHoliday(Holiday holiday) throws collegemgmtServiceException {
		logger.debug("Start :: HolidayServiceImpl.addHoliday()");
		try {
			holidayDao.addHoliday(holiday);
		} catch (collegemgmtDatabaseException exception) {
			throw (collegemgmtServiceException) exception;
		} catch (Exception e) {
			throw new collegemgmtServiceException(e.getMessage());
		}
		logger.debug("End :: HolidayServiceImpl.addHoliday()");
		
	}

	@Override
	public void editHoliday(Holiday holiday) throws collegemgmtServiceException {
		logger.debug("Start :: HolidayServiceImpl.editHoliday()");
		try {
			holidayDao.editHoliday(holiday);
		} catch (collegemgmtDatabaseException exception) {
			throw (collegemgmtServiceException) exception;
		} catch (Exception e) {
			throw new collegemgmtServiceException(e.getMessage());
		}
		logger.debug("End :: HolidayServiceImpl.editHoliday()");
	}

	@Override
	public void deleteHoliday(Holiday holiday) throws collegemgmtServiceException {
		logger.debug("Start :: HolidayServiceImpl.deleteHoliday()");
		try {
			holidayDao.deleteHoliday(holiday);
		} catch (collegemgmtDatabaseException exception) {
			throw (collegemgmtServiceException) exception;
		} catch (Exception e) {
			throw new collegemgmtServiceException(e.getMessage());
		}
		logger.debug("End :: HolidayServiceImpl.deleteHoliday()");

	}

}
