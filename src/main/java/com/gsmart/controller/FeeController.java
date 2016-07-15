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

import com.gsmart.model.Fee;
import com.gsmart.services.FeeServices;
import com.gsmart.util.CalendarCalculator;
import com.gsmart.util.Constants;
import com.gsmart.util.GSmartBaseException;
import com.gsmart.util.IAMResponse;

@Controller
@RequestMapping(Constants.FEE)
public class FeeController 
{
	@Autowired
	FeeServices feeServices;
	final Logger logger = Logger.getLogger(FeeController.class);
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Fee>> getFee() throws GSmartBaseException {
		logger.debug("Start :: FeeController.getFee()");
		List<Fee> feeList = null;
		try {
          feeList = feeServices.getFeeList();
         } 
		catch (Exception e) {
			e.printStackTrace();
		}
		logger.debug("End :: FeeController.getFee()");
		return new ResponseEntity<List<Fee>>(feeList, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<IAMResponse> addFee(@RequestBody Fee fee) throws GSmartBaseException 
	{
	    logger.debug("Start :: FeeController.addFee()");
		IAMResponse myResponse;
		fee.setTimeStamp(CalendarCalculator.getTimeStamp());
		feeServices.addFee(fee);
		myResponse = new IAMResponse("success");
		logger.debug("End :: FeeController.addFee()");
		return new ResponseEntity<IAMResponse> (myResponse, HttpStatus.OK);

	}

	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<IAMResponse> editFee(@RequestBody Fee fee)throws GSmartBaseException
	{
        logger.debug("Start :: BandController.editBand()");
		IAMResponse myResponse;
		feeServices.editFee(fee);
		myResponse = new IAMResponse("success");
		logger.debug("End :: BandController.editBand()");
		return new ResponseEntity<IAMResponse> (myResponse, HttpStatus.OK);

	}

	@RequestMapping(method = RequestMethod.DELETE)
	public ResponseEntity<IAMResponse> deleteFee(@RequestBody Fee fee) throws GSmartBaseException  
	{
		logger.debug("Start :: BandController.deleteBand()");
		IAMResponse myResponse;
		feeServices.deleteFee(fee);
		myResponse = new IAMResponse("success");
		logger.debug("End :: BandController.deleteBand()");
		return new ResponseEntity<IAMResponse> (myResponse, HttpStatus.OK);
	}


}