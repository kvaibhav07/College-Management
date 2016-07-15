package com.gsmart.dao;

import java.util.List;

import com.gsmart.model.SetGoal;
import com.gsmart.util.GSmartDatabaseException;

public interface SetGoalDao {
	
	public List<SetGoal> viewGoal() throws GSmartDatabaseException;
	
	public void addGoal(SetGoal goal) throws GSmartDatabaseException;
	
	public void editGoal(SetGoal goal) throws GSmartDatabaseException;
	
	public void deleteGoal(SetGoal goal) throws GSmartDatabaseException;

}
