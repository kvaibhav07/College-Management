package com.collegemgmt.util;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CollegeMGMTExceptionHandler{
	
	final Logger logger = Logger.getLogger(collegemgmtExceptionHandler.class);
	
	@ExceptionHandler(value=collegemgmtServiceException.class)
	public ResponseEntity<IAMResponse> handlecollegemgmtServiceException(HttpServletRequest request, Exception ex){
		logger.info("collegemgmtServiceException Occured:: URL="+request.getRequestURL());
		IAMResponse resp = new IAMResponse();
		if(Constants.CONSTRAINT_VIOLATION.equals(ex.getMessage())){
		resp.setMessage(ex.getMessage());
		}
		return new ResponseEntity<IAMResponse>(resp, HttpStatus.CONFLICT);
	}
}
