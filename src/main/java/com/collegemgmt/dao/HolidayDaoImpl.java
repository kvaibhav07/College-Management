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
import com.collegemgmt.model.Holiday;
import com.collegemgmt.util.Constants;
import com.collegemgmt.util.collegemgmtDatabaseException;

@Repository
public class HolidayDaoImpl implements HolidayDao {

	
	@Autowired
	SessionFactory sessionFactory;
	
	Session session = null;
	Transaction transaction = null;
	Query query;

	final Logger logger = Logger.getLogger(HolidayDaoImpl.class);
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Holiday> getHolidayList() throws collegemgmtDatabaseException {
		logger.debug("Start :: HolidayDaoImpl.getHolidayList()");
		List<Holiday> holidayList;
		try{
			getConnection();
			query = session.createQuery("from Holiday ");
			holidayList = query.list();
		}
	 catch (Throwable e) {
		throw new collegemgmtDatabaseException(e.getMessage());
	}
	finally {

		session.close();
	}
	logger.debug("End :: HolidayDaoImpl.getHolidayList()");
	return holidayList;
	}

	@Override
	public void addHoliday(Holiday holiday) throws collegemgmtDatabaseException {
		logger.debug("Start :: HolidayDaoImpl.addHoliday()");
		try {
			getConnection();
			session.save(holiday);
			transaction.commit();
		} catch (ConstraintViolationException e) {
			throw new collegemgmtDatabaseException(Constants.CONSTRAINT_VIOLATION);
		} catch (Throwable e) {
			throw new collegemgmtDatabaseException(e.getMessage());
		} finally {
			session.close();
		}
		logger.debug("End :: HolidayDaoImpl.addHoliday()");
	}

	private void getConnection() {
		session = sessionFactory.openSession();
		transaction = session.beginTransaction();
		
	}

	@Override
	public void editHoliday(Holiday holiday) throws collegemgmtDatabaseException {
		logger.debug("Start :: HolidayDaoImpl.editHoliday()");
		try {
			getConnection();
			query=session.createQuery("UPDATE Holiday set  holidayDate =:holidayDate, description=:description WHERE timeStamp = :timeStamp");
			query.setParameter("timeStamp", holiday.getTimeStamp());
			query.setParameter("holidayDate", holiday.getHolidayDate());
			query.setParameter("description", holiday.getDescription());	
			logger.info(holiday.getTimeStamp());
			query.executeUpdate();
			
			transaction.commit();
		} catch (ConstraintViolationException e) {
			throw new collegemgmtDatabaseException(Constants.CONSTRAINT_VIOLATION);
		} catch (Throwable e) {
			throw new collegemgmtDatabaseException(e.getMessage());
		} finally {
			session.close();
		}
		logger.debug("End :: HolidayDaoImpl.editHoliday()");
		
	}

	@Override
	public void deleteHoliday(Holiday holiday) throws collegemgmtDatabaseException {
		try {
			getConnection();
			session.delete(holiday);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

}
