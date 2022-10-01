package com.collegemgmt.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.collegemgmt.model.Fee;
import com.collegemgmt.util.Constants;
import com.collegemgmt.util.collegemgmtDatabaseException;

@Repository
public class FeeDaoImpl implements FeeDao{
	
	@Autowired
	SessionFactory sessionFactory;
	
	Session session = null;
	Transaction transaction = null;
	Query query;

	final Logger logger = Logger.getLogger(FeeDaoImpl.class);

	@SuppressWarnings("unchecked")
	@Override
	public List<Fee> getFeeList() throws collegemgmtDatabaseException {
		logger.debug("Start :: FeeDaoImpl.getFeeList()");
		List<Fee> feeList;
		try {
			getConnection();
			query = session.createQuery("from Fee ");
			feeList = query.list();

		} catch (Exception e) {
			throw new collegemgmtDatabaseException(e.getMessage());
		} finally {

			session.close();
		}
		logger.debug("End :: FeeDaoImpl.getFeeList()");
		return feeList;
	}

	@Override
	public void addFee(Fee fee) throws collegemgmtDatabaseException {
		logger.debug("Start :: FeeDaoImpl.addFee()");
		try {
			getConnection();
			session.save(fee);
			transaction.commit();
		} catch (ConstraintViolationException e) {
			throw new collegemgmtDatabaseException(Constants.CONSTRAINT_VIOLATION);
		} catch (Exception e) {
			throw new collegemgmtDatabaseException(e.getMessage());
		} finally {
			session.close();
		}
		logger.debug("End :: FeeDaoImpl.addFee()");
	}

	@Override
	public void editFee(Fee fee) throws collegemgmtDatabaseException {

		logger.debug("Start :: FeeDaoImpl.editFee()");
		try {
			getConnection();
			query = session.createQuery("UPDATE Fee set standard=:standard, sportsFee=:sportsFee, tuitionFee=:tuitionFee, transportationFee=:transportationFee ,miscellaneousFee=:miscellaneousFee, totalFee=:totalFee WHERE timeStamp=:timeStamp");
			query.setParameter("timeStamp", fee.getTimeStamp());
			query.setParameter("standard", fee.getStandard());
			query.setParameter("sportsFee", fee.getSportsFee());
			query.setParameter("tuitionFee", fee.getTuitionFee());
			query.setParameter("transportationFee", fee.getTransportationFee());
			query.setParameter("miscellaneousFee", fee.getMiscellaneousFee());
			query.setParameter("totalFee", fee.getTotalFee());
			query.executeUpdate();
			transaction.commit();

		} catch (ConstraintViolationException e) {
			throw new collegemgmtDatabaseException(Constants.CONSTRAINT_VIOLATION);
		} catch (Exception e) {
			throw new collegemgmtDatabaseException(e.getMessage());
		} finally {
			session.close();
		}
		logger.debug("End :: FeeDaoImpl.editFee()");
	}

	@Override
	public void deleteFee(Fee fee) throws collegemgmtDatabaseException {
		try {
			getConnection();
			session.delete(fee);
			transaction.commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	public void getConnection() {
		session = sessionFactory.openSession();
		transaction = session.beginTransaction();
	}
  
	@Override
	public Fee getFeeStructure(String standard) {
		getConnection();
		try{
			query = session.createQuery("from Fee where standard='" + standard + "'  and isActive='Y' " );
			Fee fee=(Fee) query.list().get(0);
			return fee;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
		finally{
			session.close();
		}
	}
}