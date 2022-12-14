package com.collegemgmt.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.collegemgmt.model.Holiday;
import com.collegemgmt.services.HolidayServices;
import com.collegemgmt.util.CalendarCalculator;
import com.collegemgmt.util.Constants;
import com.collegemgmt.util.collegemgmtBaseException;
import com.collegemgmt.util.IAMResponse;

@Controller
@RequestMapping(Constants.HOLIDAY)
public class HolidayController {

	@Autowired
	HolidayServices holidayServices;

	public static final Logger logger = Logger.getLogger(HolidayController.class);

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Holiday>> getHoliday() throws collegemgmtBaseException {
		logger.debug("Start :: HolidayController.getHoliday()");
		List<Holiday> holidayList = null;
		try {			
			holidayList = holidayServices.getHolidayList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.debug("End :: HolidayController.getHoliday()");
		return new ResponseEntity<List<Holiday>>(holidayList, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<IAMResponse> addHoliday(@RequestBody Holiday holiday) throws collegemgmtBaseException {
		logger.debug("Start :: HolidayController.addHoliday()");
		IAMResponse myResponse;
		holiday.setTimeStamp(CalendarCalculator.getTimeStamp());
		holidayServices.addHoliday(holiday);
		myResponse = new IAMResponse("success");
		logger.debug("End :: HolidayController.addHoliday()");
		return new ResponseEntity<IAMResponse> (myResponse, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public  ResponseEntity<IAMResponse> editHoliday(@RequestBody Holiday holiday) throws collegemgmtBaseException {
		logger.debug("Start :: HolidayController.editHoliday()");
		IAMResponse myResponse;
		holidayServices.editHoliday(holiday);
		myResponse = new IAMResponse("success");
		logger.debug("End :: HolidayController.editHoliday()");
		return new ResponseEntity<IAMResponse> (myResponse, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.DELETE)
	public  ResponseEntity<IAMResponse> deleteHoliday(@RequestBody Holiday holiday) throws collegemgmtBaseException {
		logger.debug("Start :: HolidayController.deleteHoliday()");
		IAMResponse myResponse;
		holidayServices.deleteHoliday(holiday);
		myResponse = new IAMResponse("success");
		logger.debug("End :: HolidayController.deleteHoliday()");
		return new ResponseEntity<IAMResponse> (myResponse, HttpStatus.OK);
	}


}
