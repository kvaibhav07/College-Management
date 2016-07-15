package com.gsmart.services;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.gsmart.dao.FeeDao;
import com.gsmart.model.Fee;
import com.gsmart.util.GSmartDatabaseException;
import com.gsmart.util.GSmartServiceException;

@Service
public class FeeServicesImpl implements FeeServices {

	final Logger logger = Logger.getLogger(FeeServicesImpl.class);

	@Autowired
	private FeeDao feeDao;

	@Override
	public List<Fee> getFeeList() throws GSmartServiceException {
		logger.debug("Running :: FeeServiceImpl.getFeeList()");
		try {
			return feeDao.getFeeList();
		} catch (GSmartDatabaseException exception) {
			throw (GSmartServiceException) exception;
		} catch (Exception e) {
			throw new GSmartServiceException(e.getMessage());
		}

	}

	@Override
	public void addFee(Fee fee) throws GSmartServiceException {
		logger.debug("Start :: FeeServiceImpl.addFee()");
		try {
			feeDao.addFee(fee);
		} catch (GSmartDatabaseException exception) {
			throw (GSmartServiceException) exception;
		} catch (Exception e) {
			throw new GSmartServiceException(e.getMessage());
		}
		logger.debug("End :: FeeServiceImpl.addFee()");
	}

	@Override
	public void editFee(Fee fee) throws GSmartServiceException {
		logger.debug("Start :: FeeServiceImpl.editFee()");
		try {
			feeDao.editFee(fee);
		} catch (GSmartDatabaseException exception) {
			throw (GSmartServiceException) exception;
		} catch (Exception e) {
			throw new GSmartServiceException(e.getMessage());
		}
		logger.debug("End :: FeeServiceImpl.editFee()");
	}

	@Override
	public void deleteFee(Fee fee) throws GSmartServiceException {
		logger.debug("Start :: FeeServiceImpl.deleteFee()");
		try {
			feeDao.deleteFee(fee);
		} catch (GSmartDatabaseException exception) {
			throw (GSmartServiceException) exception;
		} catch (Exception e) {
			throw new GSmartServiceException(e.getMessage());
		}
		logger.debug("End :: FeeServiceImpl.deleteFee()");
	}

}