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

import com.gsmart.model.Band;
import com.gsmart.services.BandServices;
import com.gsmart.util.CalendarCalculator;
import com.gsmart.util.Constants;
import com.gsmart.util.GSmartBaseException;
import com.gsmart.util.IAMResponse;

@Controller
@RequestMapping(Constants.BAND)
public class BandController {

	@Autowired
	BandServices bandServices;

	final Logger logger = Logger.getLogger(BandController.class);

	@RequestMapping( method = RequestMethod.GET)
	public ResponseEntity<List<Band>> getBand() throws GSmartBaseException {
		logger.debug("Start :: BandController.getBand()");
		List<Band> bandList = null;
		try {			
			bandList = bandServices.getBandList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.debug("End :: BandController.getBand()");
		return new ResponseEntity<List<Band>>(bandList, HttpStatus.OK);
	}

	@RequestMapping( method = RequestMethod.POST)
	public ResponseEntity<IAMResponse> addBand(@RequestBody Band band) throws GSmartBaseException {
		logger.debug("Start :: BandController.addBand()");
		IAMResponse myResponse;
		band.setTimeStamp(CalendarCalculator.getTimeStamp());
		bandServices.addBand(band);
		myResponse = new IAMResponse("success");
		logger.debug("End :: BandController.addBand()");
		return new ResponseEntity<IAMResponse> (myResponse, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.PUT)
	public  ResponseEntity<IAMResponse> editBand(@RequestBody Band band) throws GSmartBaseException {
		logger.debug("Start :: BandController.editBand()");
		IAMResponse myResponse;
		bandServices.editBand(band);
		myResponse = new IAMResponse("success");
		logger.debug("End :: BandController.editBand()");
		return new ResponseEntity<IAMResponse> (myResponse, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.DELETE)
	public  ResponseEntity<IAMResponse> deleteBand(@RequestBody Band band) throws GSmartBaseException {
		logger.debug("Start :: BandController.deleteBand()");
		IAMResponse myResponse;
		bandServices.deleteBand(band);
		myResponse = new IAMResponse("success");
		logger.debug("End :: BandController.deleteBand()");
		return new ResponseEntity<IAMResponse> (myResponse, HttpStatus.OK);
	}

}
