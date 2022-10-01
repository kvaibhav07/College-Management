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

import com.collegemgmt.model.Band;
import com.collegemgmt.services.BandServices;
import com.collegemgmt.util.CalendarCalculator;
import com.collegemgmt.util.Constants;
import com.collegemgmt.util.collegemgmtBaseException;
import com.collegemgmt.util.IAMResponse;

/**
* The BandController class implements an application that
* displays list of band entities, add new band entity,
* edit available band entity and delete available band entity.
* these functionalities are provided in {@link BandServices}
*
* @author :Kuvar Vaibhav Singh
* @version 1.0
* @since 2016-02-23  
*/

@Controller
@RequestMapping(Constants.BAND)
public class BandController {

	@Autowired
	BandServices bandServices;

	final Logger logger = Logger.getLogger(BandController.class);

	/**
	 * to view {@link Band} details.
	 * @param no parameters
	 * @return returns list of band entities present in the Band table 
	 * @see List
	 * @throws collegemgmtBaseException
	 */
	@RequestMapping( method = RequestMethod.GET)
	public ResponseEntity<List<Band>> getBand() throws collegemgmtBaseException {
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
	/**
	 * provides the access to persist a new band entity 
	 * Sets the {@code timeStamp} using {@link CalendarCalculator}
	 * @param band is instance of {@link Band}
	 * @return persistence status (success/error) in JSON format
	 * @see IAMResponse
	 */
	@RequestMapping( method = RequestMethod.POST)
	public ResponseEntity<IAMResponse> addBand(@RequestBody Band band) throws collegemgmtBaseException {
		logger.debug("Start :: BandController.addBand()");
		IAMResponse myResponse;
		band.setTimeStamp(CalendarCalculator.getTimeStamp());
		bandServices.addBand(band);
		myResponse = new IAMResponse("success");
		logger.debug("End :: BandController.addBand()");
		return new ResponseEntity<IAMResponse> (myResponse, HttpStatus.OK);
	}
	/**
	 * provide the access to update band entity 
	 * @param band instance of {@link Band}
	 * @return persistence status (success/error) in JSON format
	 * @see IAMResponse
	 */
	@RequestMapping(method = RequestMethod.PUT)
	public  ResponseEntity<IAMResponse> editBand(@RequestBody Band band) throws collegemgmtBaseException {
		logger.debug("Start :: BandController.editBand()");
		IAMResponse myResponse;
		bandServices.editBand(band);
		myResponse = new IAMResponse("success");
		logger.debug("End :: BandController.editBand()");
		return new ResponseEntity<IAMResponse> (myResponse, HttpStatus.OK);
	}
	/**
	 * provide the access to delete band entity 
	 * @param band instance of {@link Band}
	 * @return deletion status (success/error) in JSON format
	 * @see IAMResponse
	 */
	@RequestMapping(method = RequestMethod.DELETE)
	public  ResponseEntity<IAMResponse> deleteBand(@RequestBody Band band) throws collegemgmtBaseException {
		logger.debug("Start :: BandController.deleteBand()");
		IAMResponse myResponse;
		bandServices.deleteBand(band);
		myResponse = new IAMResponse("success");
		logger.debug("End :: BandController.deleteBand()");
		return new ResponseEntity<IAMResponse> (myResponse, HttpStatus.OK);
	}

}
