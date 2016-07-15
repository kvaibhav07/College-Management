package com.gsmart.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.gsmart.model.SetGoal;
import com.gsmart.services.SetGoalServices;
import com.gsmart.util.CalendarCalculator;
import com.gsmart.util.Constants;
import com.gsmart.util.GSmartBaseException;
import com.gsmart.util.IAMResponse;

@Controller
@RequestMapping(Constants.SETGOAL)
public class SetGoalController {
	
	@Autowired
	SetGoalServices setgoalServices;
	
	final Logger logger = Logger.getLogger(SetGoalController.class);
	
	@RequestMapping( method = RequestMethod.GET)
	public ResponseEntity<List<SetGoal>>  viewGoal() throws GSmartBaseException{
		logger.debug("Start :: SetGoalController.viewGoal()");
		List<SetGoal> goalList = null;
		try {			
			
			goalList = setgoalServices.viewGoal();
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.debug("End :: SetGoalController.viewGoal()");
		return  new ResponseEntity<List<SetGoal>>(goalList,HttpStatus.OK);
		
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<IAMResponse> addGoal(@RequestBody SetGoal goal) throws GSmartBaseException
	{
		logger.debug("Start :: SetGoalController.addGoal()");
		IAMResponse myResponse;
		goal.setTimeStamp(CalendarCalculator.getTimeStamp());
		setgoalServices.addGoal(goal);
		myResponse = new IAMResponse("success");
		logger.debug("End :: SetGoalController.addGoal()");
		return new ResponseEntity<IAMResponse>(myResponse, HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.PUT)
	public ResponseEntity<IAMResponse> editGoal(@RequestBody SetGoal goal) throws GSmartBaseException{
		logger.debug("Start :: SetGoalController.editGoal()");
		IAMResponse myResponse;
		setgoalServices.editGoal(goal);
		myResponse = new IAMResponse("success");
		logger.debug("End :: SetGoalController.editGoal()");
		return new ResponseEntity<IAMResponse>(myResponse, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.DELETE)
	public  ResponseEntity<IAMResponse> deleteGoal(@RequestBody SetGoal goal) throws GSmartBaseException {
		logger.debug("Start :: SetGoalController.deleteGoal()");
		IAMResponse myResponse;
		setgoalServices.deleteGoal(goal);
		myResponse = new IAMResponse("success");
		logger.debug("End :: SetGoalController.deleteGoal()");
		return new ResponseEntity<IAMResponse> (myResponse, HttpStatus.OK);
	}

}
