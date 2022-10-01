package com.collegemgmt.dao;

import java.util.List;

import com.collegemgmt.model.SetGoal;
import com.collegemgmt.util.collegemgmtDatabaseException;

public interface SetGoalDao {
	
	public List<SetGoal> viewGoal() throws collegemgmtDatabaseException;
	
	public void addGoal(SetGoal goal) throws collegemgmtDatabaseException;
	
	public void editGoal(SetGoal goal) throws collegemgmtDatabaseException;
	
	public void deleteGoal(SetGoal goal) throws collegemgmtDatabaseException;

}
