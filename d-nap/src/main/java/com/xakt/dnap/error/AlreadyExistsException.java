package com.xakt.dnap.error;

public class AlreadyExistsException extends Exception{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AlreadyExistsException() {
		super();
	}
	
	public AlreadyExistsException(String message) {
		super(message);
	}
	
	public AlreadyExistsException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public AlreadyExistsException(Throwable cause) {
		super(cause);
	}
	
	public AlreadyExistsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
