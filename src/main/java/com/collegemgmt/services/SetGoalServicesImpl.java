package com.collegemgmt.services;



import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.collegemgmt.dao.SetGoalDao;
import com.collegemgmt.model.SetGoal;
import com.collegemgmt.util.collegemgmtDatabaseException;
import com.collegemgmt.util.collegemgmtServiceException;

@Service
public class SetGoalServicesImpl implements SetGoalServices {
	
	final Logger logger = Logger.getLogger(SetGoalServicesImpl.class);
	
	@Autowired
	private SetGoalDao setgoalDao; 

	@Override
	public List<SetGoal> viewGoal() throws collegemgmtServiceException {
		logger.debug("Running :: SetGoalServicesImpl.viewGoal()");
		try {
			return setgoalDao.viewGoal();
		} catch (collegemgmtDatabaseException exception) {
			throw (collegemgmtServiceException) exception;
		} catch (Exception e) {
			throw new collegemgmtServiceException(e.getMessage());
		}
	}

	@Override
	public void addGoal(SetGoal goal) throws collegemgmtServiceException {
		logger.debug("Start :: SetGoalServicesImpl.addGoal()");
		try {
			setgoalDao.addGoal(goal);
		} catch (collegemgmtDatabaseException exception) {
			throw (collegemgmtServiceException) exception;
		} catch (Exception e) {
			throw new collegemgmtServiceException(e.getMessage());
		}
		logger.debug("End :: SetGoalServicesImpl.addGoal()");
		
	}

	@Override
	public void editGoal(SetGoal goal) throws collegemgmtServiceException {
		logger.debug("Start :: SetGoalServicesImpl.editGoal()");
		try {
			setgoalDao.editGoal(goal);
		} catch (collegemgmtDatabaseException exception) {
			throw (collegemgmtServiceException) exception;
		} catch (Exception e) {
			throw new collegemgmtServiceException(e.getMessage());
		}
		logger.debug("End :: SetGoalServicesImpl.editGoal()");
	}

	@Override
	public void deleteGoal(SetGoal goal) throws collegemgmtServiceException {
		logger.debug("Start :: SetGoalServicesImpl.deleteGoal()");
		try {
			setgoalDao.deleteGoal(goal);
		} catch (collegemgmtDatabaseException exception) {
			throw (collegemgmtServiceException) exception;
		} catch (Exception e) {
			throw new collegemgmtServiceException(e.getMessage());
		}
		logger.debug("End :: SetGoalServicesImpl.deleteGoal()");
		
	}
	
	

}
