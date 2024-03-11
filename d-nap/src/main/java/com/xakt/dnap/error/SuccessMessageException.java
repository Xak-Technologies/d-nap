package com.xakt.dnap.error;

public class SuccessMessageException extends Exception{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SuccessMessageException() {
		super();
	}
	
	public SuccessMessageException(String message) {
		super(message);
	}
	
	public SuccessMessageException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public SuccessMessageException(Throwable cause) {
		super(cause);
	}
	
	public SuccessMessageException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
