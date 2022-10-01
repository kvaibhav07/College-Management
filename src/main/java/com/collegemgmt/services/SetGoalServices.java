package com.collegemgmt.services;



import java.util.List;

import com.collegemgmt.model.SetGoal;
import com.collegemgmt.util.collegemgmtServiceException;

public interface SetGoalServices {
	
	public List<SetGoal> viewGoal() throws collegemgmtServiceException;
	
	public void addGoal(SetGoal goal) throws collegemgmtServiceException;
	
	public void editGoal(SetGoal goal) throws collegemgmtServiceException;
	
	public void deleteGoal(SetGoal goal) throws collegemgmtServiceException;

}
