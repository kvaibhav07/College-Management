package com.gsmart.services;



import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gsmart.dao.SetGoalDao;
import com.gsmart.model.SetGoal;
import com.gsmart.util.GSmartDatabaseException;
import com.gsmart.util.GSmartServiceException;

@Service
public class SetGoalServicesImpl implements SetGoalServices {
	
	final Logger logger = Logger.getLogger(SetGoalServicesImpl.class);
	
	@Autowired
	private SetGoalDao setgoalDao; 

	@Override
	public List<SetGoal> viewGoal() throws GSmartServiceException {
		logger.debug("Running :: SetGoalServicesImpl.viewGoal()");
		try {
			return setgoalDao.viewGoal();
		} catch (GSmartDatabaseException exception) {
			throw (GSmartServiceException) exception;
		} catch (Exception e) {
			throw new GSmartServiceException(e.getMessage());
		}
	}

	@Override
	public void addGoal(SetGoal goal) throws GSmartServiceException {
		logger.debug("Start :: SetGoalServicesImpl.addGoal()");
		try {
			setgoalDao.addGoal(goal);
		} catch (GSmartDatabaseException exception) {
			throw (GSmartServiceException) exception;
		} catch (Exception e) {
			throw new GSmartServiceException(e.getMessage());
		}
		logger.debug("End :: SetGoalServicesImpl.addGoal()");
		
	}

	@Override
	public void editGoal(SetGoal goal) throws GSmartServiceException {
		logger.debug("Start :: SetGoalServicesImpl.editGoal()");
		try {
			setgoalDao.editGoal(goal);
		} catch (GSmartDatabaseException exception) {
			throw (GSmartServiceException) exception;
		} catch (Exception e) {
			throw new GSmartServiceException(e.getMessage());
		}
		logger.debug("End :: SetGoalServicesImpl.editGoal()");
	}

	@Override
	public void deleteGoal(SetGoal goal) throws GSmartServiceException {
		logger.debug("Start :: SetGoalServicesImpl.deleteGoal()");
		try {
			setgoalDao.deleteGoal(goal);
		} catch (GSmartDatabaseException exception) {
			throw (GSmartServiceException) exception;
		} catch (Exception e) {
			throw new GSmartServiceException(e.getMessage());
		}
		logger.debug("End :: SetGoalServicesImpl.deleteGoal()");
		
	}
	
	

}
