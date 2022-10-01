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

import com.collegemgmt.model.SetGoal;
import com.collegemgmt.util.Constants;
import com.collegemgmt.util.collegemgmtDatabaseException;

@Repository
public class SetGoalDaoImpl implements SetGoalDao {

	@Autowired
	SessionFactory sessionFactory;
	
	Session session = null;
	Transaction transaction = null;
	Query query;
	
	final Logger logger = Logger.getLogger(SetGoalDaoImpl.class);
	
	public void getConnection() {
		session = sessionFactory.openSession();
		transaction = session.beginTransaction();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<SetGoal> viewGoal() throws collegemgmtDatabaseException {
		logger.debug("Start :: SetGoalDaoImpl.viewGoal()");
		List<SetGoal> viewList;
		try{
			getConnection();
			query = session.createQuery("from SetGoal");
			viewList = query.list();
		}catch(Exception e){
			throw new collegemgmtDatabaseException(e.getMessage());
		}finally{
			session.close();
		}
		logger.debug("End :: SetGoalDaoImpl.viewGoal()");
		return viewList;
	}

	@Override
	public void addGoal(SetGoal goal) throws collegemgmtDatabaseException {
		logger.debug("Start :: SetGoalDaoImpl.addGoal()");
		try {
			getConnection();
			session.save(goal);
			transaction.commit();
		} catch (ConstraintViolationException e) {
			throw new collegemgmtDatabaseException(Constants.CONSTRAINT_VIOLATION);
		} catch (Exception e) {
			throw new collegemgmtDatabaseException(e.getMessage());
		} finally {
			session.close();
		}
		logger.debug("End :: SetGoalDaoImpl.addGoal()");
		
	}

	@Override
	public void editGoal(SetGoal goal) throws collegemgmtDatabaseException {
		logger.debug("Start :: SetGoalDaoImpl.editGoal()");
		try{
			getConnection();
			query = session.createQuery("UPDATE SetGoal set  role =:role, personal=:personal, selfImprovement=:selfImprovement, productivity=:productivity, quality=:quality WHERE timeStamp = :timeStamp");
			query.setParameter("role", goal.getRole());
			query.setParameter("personal", goal.getPersonal());
			query.setParameter("selfImprovement", goal.getSelfImprovement());
			query.setParameter("productivity", goal.getProductivity());
			query.setParameter("quality", goal.getQuality());
			query.setParameter("timeStamp", goal.getTimeStamp());
			query.executeUpdate(); 
			transaction.commit();
		}catch(ConstraintViolationException e){
			throw new collegemgmtDatabaseException(Constants.CONSTRAINT_VIOLATION);
		}catch(Exception e){
			throw new collegemgmtDatabaseException(e.getMessage());
		}finally{
			session.close();
		}
		logger.debug("End :: SetGoalDaoImpl.editGoal()");
		
	}

	@Override
	public void deleteGoal(SetGoal goal) throws collegemgmtDatabaseException {
		try {
			getConnection();
			session.delete(goal);
			transaction.commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		
	}

}
