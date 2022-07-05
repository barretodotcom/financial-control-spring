package com.financial.control.exceptions;

public class AppExceptionError extends RuntimeException{
	
	private static final long serialVersionUID = 1L;

	public AppExceptionError(String message) {
		super(message);
	}

	public AppExceptionError(String message, Throwable throwable) {
		super(message,throwable);
	}
	
}