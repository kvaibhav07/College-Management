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

import com.collegemgmt.model.Hierarchy;
import com.collegemgmt.util.CalendarCalculator;
import com.collegemgmt.util.Constants;
import com.collegemgmt.util.collegemgmtDatabaseException;
/**
 * class-name: HierarchyDaoImpl.java
 * Assigning hierarchy for everyone 
 * from the institution to the section
 *   
 * @author 
 * @version 1.0
 * @since 2016-02-23  
 *
 */
/*
 *This is the HierarchyDaoImpl.
 *It is an implementation Class of HierarchyDao.
 */
@Repository
public class HierarchyDaoImpl implements HierarchyDao{
	


		@Autowired
		SessionFactory sessionFactory;

		Session session = null;
		Transaction transaction = null;
		Query query;

		final Logger logger = Logger.getLogger(HierarchyDaoImpl.class);


		/*
		 * This Method implements getHierarchyList()  and 
		 * Perform viewing Operations.
		 */
		@SuppressWarnings("unchecked")
		@Override
		public List<Hierarchy> getHierarchyList() throws collegemgmtDatabaseException {
			logger.debug("Start :: HierarchyDaoImpl.getHierarchyList()");
			List<Hierarchy>hierarchyList;
			try {
				getConnection();
				query = session.createQuery("from Hierarchy");
				hierarchyList = query.list();

			} catch (Throwable e) {
				throw new collegemgmtDatabaseException(e.getMessage());
			} finally {

				session.close();
			}
			logger.debug("End ::HierarchyDaoImpl.getHierarchyList()");
			return hierarchyList;
		}
		
		/**
		 * Adds new hierarchy entity to {@link Hierarchy}
		 * Sets the status of new hierarchy entity {@code isActive} as 'Y'
		 * and save it in the database.
		 * Sets the {@code entryTime} using {@link CalendarCalculator}
		 * commit the changes in the database.
		 * @param hierarchy instance of {@link Hierarchy}
		 * @return Nothing
		 * @throws Exception
		 */
		@Override
		public void addHierarchy(Hierarchy hierarchy) throws collegemgmtDatabaseException {
			logger.debug("Start :: HierarchyDaoImpl.addHierarchy()");
			try {
				getConnection();
				session.save(hierarchy);
				transaction.commit();
			} catch (ConstraintViolationException e) {
				throw new collegemgmtDatabaseException(Constants.CONSTRAINT_VIOLATION);
			} catch (Throwable e) {
				throw new collegemgmtDatabaseException(e.getMessage());
			} finally {
				session.close();
			}
			logger.debug("End :: HierarchyDaoImpl.addHierarchy()");
		}

		/**
		 * Changes the status of {@code oldHierarchy} with {@code isActive} as 'N' and 
		 * it will commit the changes in the database
		 * @param isActive
		 * @throws Exception
		 */
		
		@Override
		public void editHierarchy(Hierarchy hierarchy) throws collegemgmtDatabaseException {

			logger.debug("Start :: HierarchyDaoImpl.editHierarchy()");
			try {
				getConnection();
				query = session.createQuery("UPDATE Hierarchy set  institution=:institution, school=:school, standard=:standard, section=:section WHERE timeStamp = :timeStamp");
				query.setParameter("timeStamp", hierarchy.getTimeStamp());
				query.setParameter("institution", hierarchy.getInstitution());
				query.setParameter("school", hierarchy.getSchool());
			    query.setParameter("standard", hierarchy.getStandard());
				query.setParameter("section", hierarchy.getSection());
				query.executeUpdate();
				transaction.commit();
			} catch (ConstraintViolationException e) {
				throw new collegemgmtDatabaseException(Constants.CONSTRAINT_VIOLATION);
			} catch (Throwable e) {
				throw new collegemgmtDatabaseException(e.getMessage());
			} finally {
				session.close();
			}
			logger.debug("End :: HierarchyDaoImpl.editHierarchy()");
		}
		/** 
		 * change the hierarchy status {@code isAvtive} as 'D' and commit the changes in the database
		 * @param hierarchy instanceOf {@link Hierarchy}
		 * @return Nothing
		 */
		@Override
		public void deleteHierarchy(Hierarchy hierarchy) throws collegemgmtDatabaseException {
			try {
				getConnection();
				session.delete(hierarchy);
				transaction.commit();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				session.close();
			}
		}
		/**
		 * create instance for session
		 * begin transaction
		 * @return Nothing
		 */
		public void getConnection() {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
		}

	}