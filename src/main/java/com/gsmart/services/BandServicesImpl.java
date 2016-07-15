package com.gsmart.services;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gsmart.dao.BandDao;
import com.gsmart.model.Band;
import com.gsmart.util.GSmartDatabaseException;
import com.gsmart.util.GSmartServiceException;

@Service
public class BandServicesImpl implements BandServices {

	final Logger logger = Logger.getLogger(BandServicesImpl.class);

	@Autowired
	private BandDao bandDao;

	@Override
	public List<Band> getBandList() throws GSmartServiceException {
		logger.debug("Running :: BandServiceImpl.getBandList()");
		try {
			return bandDao.getBandList();
		} catch (GSmartDatabaseException exception) {
			throw (GSmartServiceException) exception;
		} catch (Exception e) {
			throw new GSmartServiceException(e.getMessage());
		}

	}

	@Override
	public void addBand(Band band) throws GSmartServiceException {
		logger.debug("Start :: BandServiceImpl.addBand()");
		try {
			bandDao.addBand(band);
		} catch (GSmartDatabaseException exception) {
			throw (GSmartServiceException) exception;
		} catch (Exception e) {
			throw new GSmartServiceException(e.getMessage());
		}
		logger.debug("End :: BandServiceImpl.addBand()");
	}

	@Override
	public void editBand(Band band) throws GSmartServiceException {
		logger.debug("Start :: BandServiceImpl.editBand()");
		try {
			bandDao.editBand(band);
		} catch (GSmartDatabaseException exception) {
			throw (GSmartServiceException) exception;
		} catch (Exception e) {
			throw new GSmartServiceException(e.getMessage());
		}
		logger.debug("End :: BandServiceImpl.editBand()");
	}

	@Override
	public void deleteBand(Band band) throws GSmartServiceException {
		logger.debug("Start :: BandServiceImpl.deleteBand()");
		try {
			bandDao.deleteBand(band);
		} catch (GSmartDatabaseException exception) {
			throw (GSmartServiceException) exception;
		} catch (Exception e) {
			throw new GSmartServiceException(e.getMessage());
		}
		logger.debug("End :: BandServiceImpl.deleteBand()");
	}

}
