package com.gsmart.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gsmart.model.Band;
import com.gsmart.util.Constants;
import com.gsmart.util.GSmartDatabaseException;

/**
 * provides the implementation for the methods available in {@link BandDao} interface
 * @author :Nirmal Raj J
 * @version 1.0
 * @since 2016-02-23  
 */
@Repository
public class BandDaoImpl implements BandDao {

	@Autowired
	SessionFactory sessionFactory;
	
	Session session = null;
	Transaction transaction = null;
	Query query;

	final Logger logger = Logger.getLogger(BandDaoImpl.class);
	
	/**
	 * to view the list of records available in {@link Band} table
	 * @return list of band entities available in Band
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Band> getBandList() throws GSmartDatabaseException {
		logger.debug("Start :: BandDaoImpl.getBandList()");
		List<Band> bandList;
		try {
			getConnection();
			query = session.createQuery("from Band ");
			bandList = query.list();

		} catch (Exception e) {
			throw new GSmartDatabaseException(e.getMessage());
		} finally {

			session.close();
		}
		logger.debug("End :: BandDaoImpl.getBandList()");
		return bandList;
	}
	
	/**
	 * Adds new band entity to {@link Band} save it in database
	 * @param band instance of Band
	 * @return Nothing
	 */
	@Override
	public void addBand(Band band) throws GSmartDatabaseException {
		logger.debug("Start :: BandDaoImpl.addBand()");
		try {
			getConnection();
			session.save(band);
			transaction.commit();
		} catch (ConstraintViolationException e) {
			throw new GSmartDatabaseException(Constants.CONSTRAINT_VIOLATION);
		} catch (Exception e) {
			throw new GSmartDatabaseException(e.getMessage());
		} finally {
			session.close();
		}
		logger.debug("End :: BandDaoImpl.addBand()");
	}
	
	/**
	 * persists the updated band instance 
	 * @param band instance of {@link Band}
	 * @return Nothing
	 */
	@Override
	public void editBand(Band band) throws GSmartDatabaseException {

		logger.debug("Start :: BandDaoImpl.editBand()");
		try {
			getConnection();
			query = session.createQuery(
					"UPDATE Band set  bandId =:bandId, role=:role, designation=:designation WHERE timeStamp = :timeStamp");
			query.setParameter("timeStamp", band.getTimeStamp());
			query.setParameter("bandId", band.getBandId());
			query.setParameter("role", band.getRole());
			query.setParameter("designation", band.getDesignation());
			query.executeUpdate();
			transaction.commit();

		} catch (ConstraintViolationException e) {
			throw new GSmartDatabaseException(Constants.CONSTRAINT_VIOLATION);
		} catch (Exception e) {
			throw new GSmartDatabaseException(e.getMessage());
		} finally {
			session.close();
		}
		logger.debug("End :: BandDaoImpl.editBand()");
	}
	/**
	 * removes the band entity from the database.
	 * @param band instanceOf {@link Band}
	 * @return Nothing
	 */
	@Override
	public void deleteBand(Band band) throws GSmartDatabaseException {
		try {
			getConnection();
			session.delete(band);
			transaction.commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	/**
	 * create instance for session and
	 * begins transaction
	 */
	public void getConnection() {
		session = sessionFactory.openSession();
		transaction = session.beginTransaction();
	}

}
