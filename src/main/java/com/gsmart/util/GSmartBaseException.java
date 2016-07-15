package com.gsmart.util;

import javax.ws.rs.ext.Provider;

@Provider
public class GSmartBaseException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	public GSmartBaseException(String msg){
		super(msg);
	}
}
