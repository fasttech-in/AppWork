package com.rest.api.messenger.exception;

public class DataNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -13222232654L; 
	
	public DataNotFoundException(String message) {
		super(message);
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
}
