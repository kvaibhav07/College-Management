package com.gsmart.services;



import java.util.List;

import com.gsmart.model.SetGoal;
import com.gsmart.util.GSmartServiceException;

public interface SetGoalServices {
	
	public List<SetGoal> viewGoal() throws GSmartServiceException;
	
	public void addGoal(SetGoal goal) throws GSmartServiceException;
	
	public void editGoal(SetGoal goal) throws GSmartServiceException;
	
	public void deleteGoal(SetGoal goal) throws GSmartServiceException;

}
