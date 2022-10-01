package com.collegemgmt.services;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.collegemgmt.dao.FeeDao;
import com.collegemgmt.model.Fee;
import com.collegemgmt.util.collegemgmtDatabaseException;
import com.collegemgmt.util.collegemgmtServiceException;

@Service
public class FeeServicesImpl implements FeeServices {

	final Logger logger = Logger.getLogger(FeeServicesImpl.class);

	@Autowired
	private FeeDao feeDao;

	@Override
	public List<Fee> getFeeList() throws collegemgmtServiceException {
		logger.debug("Running :: FeeServiceImpl.getFeeList()");
		try {
			return feeDao.getFeeList();
		} catch (collegemgmtDatabaseException exception) {
			throw (collegemgmtServiceException) exception;
		} catch (Exception e) {
			throw new collegemgmtServiceException(e.getMessage());
		}

	}

	@Override
	public void addFee(Fee fee) throws collegemgmtServiceException {
		logger.debug("Start :: FeeServiceImpl.addFee()");
		try {
			feeDao.addFee(fee);
		} catch (collegemgmtDatabaseException exception) {
			throw (collegemgmtServiceException) exception;
		} catch (Exception e) {
			throw new collegemgmtServiceException(e.getMessage());
		}
		logger.debug("End :: FeeServiceImpl.addFee()");
	}

	@Override
	public void editFee(Fee fee) throws collegemgmtServiceException {
		logger.debug("Start :: FeeServiceImpl.editFee()");
		try {
			feeDao.editFee(fee);
		} catch (collegemgmtDatabaseException exception) {
			throw (collegemgmtServiceException) exception;
		} catch (Exception e) {
			throw new collegemgmtServiceException(e.getMessage());
		}
		logger.debug("End :: FeeServiceImpl.editFee()");
	}

	@Override
	public void deleteFee(Fee fee) throws collegemgmtServiceException {
		logger.debug("Start :: FeeServiceImpl.deleteFee()");
		try {
			feeDao.deleteFee(fee);
		} catch (collegemgmtDatabaseException exception) {
			throw (collegemgmtServiceException) exception;
		} catch (Exception e) {
			throw new collegemgmtServiceException(e.getMessage());
		}
		logger.debug("End :: FeeServiceImpl.deleteFee()");
	}

}