package com.collegemgmt.services;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.collegemgmt.dao.BandDao;
import com.collegemgmt.model.Band;
import com.collegemgmt.util.collegemgmtDatabaseException;
import com.collegemgmt.util.collegemgmtServiceException;

/**
 * Provides implementation for services declared in {@link BandServices}
 * interface. it will go to {@link BandDao}
 * 
 * @author :Kuvar Vaibhav Singh
 * @version 1.0
 * @since 2016-02-23
 */
@Service
public class BandServicesImpl implements BandServices {

	final Logger logger = Logger.getLogger(BandServicesImpl.class);

	@Autowired
	private BandDao bandDao;

	/**
	 * @return calls {@link BandDao}'s <code>getBandList()</code> method
	 */
	@Override
	public List<Band> getBandList() throws collegemgmtServiceException {
		logger.debug("Running :: BandServiceImpl.getBandList()");
		try {
			return bandDao.getBandList();
		} catch (collegemgmtDatabaseException exception) {
			throw (collegemgmtServiceException) exception;
		} catch (Exception e) {
			throw new collegemgmtServiceException(e.getMessage());
		}

	}

	/**
	 * calls {@link BandDao}'s <code>addBand(...)</code> method
	 * 
	 * @param band
	 *            an instance of {@link Band} class
	 * @throws collegemgmtServiceException
	 */
	@Override
	public void addBand(Band band) throws collegemgmtServiceException {
		logger.debug("Start :: BandServiceImpl.addBand()");
		try {
			bandDao.addBand(band);
		} catch (collegemgmtDatabaseException exception) {
			throw (collegemgmtServiceException) exception;
		} catch (Exception e) {
			throw new collegemgmtServiceException(e.getMessage());
		}
		logger.debug("End :: BandServiceImpl.addBand()");
	}

	/**
	 * calls {@link BandDao}'s <code>editBand(...)</code> method
	 * 
	 * @param band
	 *            an instance of {@link Band} class
	 * @throws collegemgmtServiceException
	 */
	@Override
	public void editBand(Band band) throws collegemgmtServiceException {
		logger.debug("Start :: BandServiceImpl.editBand()");
		try {
			bandDao.editBand(band);
		} catch (collegemgmtDatabaseException exception) {
			throw (collegemgmtServiceException) exception;
		} catch (Exception e) {
			throw new collegemgmtServiceException(e.getMessage());
		}
		logger.debug("End :: BandServiceImpl.editBand()");
	}

	/**
	 * calls {@link BandDao}'s <code>deleteBand(...)</code> method
	 * 
	 * @param band
	 *            an instance of {@link Band} class
	 * @throws Exception
	 */
	@Override
	public void deleteBand(Band band) throws collegemgmtServiceException {
		logger.debug("Start :: BandServiceImpl.deleteBand()");
		try {
			bandDao.deleteBand(band);
		} catch (collegemgmtDatabaseException exception) {
			throw (collegemgmtServiceException) exception;
		} catch (Exception e) {
			throw new collegemgmtServiceException(e.getMessage());
		}
		logger.debug("End :: BandServiceImpl.deleteBand()");
	}

}
