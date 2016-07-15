/*
* class name: HierarchyDaoImpl.java

 *
 * Copyright (c) 2008-2009 Gowdanar Technologies Pvt. Ltd. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Gowdanar
 * Technologies Pvt. Ltd.("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Gowdanar Technologie.
 *
 * GOWDANAR TECHNOLOGIES MAKES NO REPRESENTATIONS OR WARRANTIES ABOUT THE SUITABILITY OF
 * THE SOFTWARE, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED
 * TO THE IMPLIED WARRANTIES OF MERCHANTABILITY, FITNESS FOR A
 * PARTICULAR PURPOSE, OR NON-INFRINGEMENT. GOWDANAR TECHNOLOGIES SHALL NOT BE LIABLE FOR
 * ANY DAMAGES SUFFERED BY LICENSEE AS A RESULT OF USING, MODIFYING OR
 * DISTRIBUTING
 */

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
import com.gsmart.model.Hierarchy;
import com.gsmart.util.CalendarCalculator;
import com.gsmart.util.Constants;
import com.gsmart.util.GSmartDatabaseException;
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
		public List<Hierarchy> getHierarchyList() throws GSmartDatabaseException {
			logger.debug("Start :: HierarchyDaoImpl.getHierarchyList()");
			List<Hierarchy>hierarchyList;
			try {
				getConnection();
				query = session.createQuery("from Hierarchy");
				hierarchyList = query.list();

			} catch (Throwable e) {
				throw new GSmartDatabaseException(e.getMessage());
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
		public void addHierarchy(Hierarchy hierarchy) throws GSmartDatabaseException {
			logger.debug("Start :: HierarchyDaoImpl.addHierarchy()");
			try {
				getConnection();
				session.save(hierarchy);
				transaction.commit();
			} catch (ConstraintViolationException e) {
				throw new GSmartDatabaseException(Constants.CONSTRAINT_VIOLATION);
			} catch (Throwable e) {
				throw new GSmartDatabaseException(e.getMessage());
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
		public void editHierarchy(Hierarchy hierarchy) throws GSmartDatabaseException {

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
				throw new GSmartDatabaseException(Constants.CONSTRAINT_VIOLATION);
			} catch (Throwable e) {
				throw new GSmartDatabaseException(e.getMessage());
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
		public void deleteHierarchy(Hierarchy hierarchy) throws GSmartDatabaseException {
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