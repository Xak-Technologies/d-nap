package com.xakt.dnap.error;

public class BlankFieldException extends Exception{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BlankFieldException() {
		super();
	}
	
	public BlankFieldException(String message) {
		super(message);
	}
	
	public BlankFieldException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public BlankFieldException(Throwable cause) {
		super(cause);
	}
	
	public BlankFieldException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
