package com.financial.control.exceptions;

import java.time.ZoneId;
import java.time.ZonedDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AppExceptionHandler {
	
	@ExceptionHandler(value = {AppExceptionError.class})
	public ResponseEntity<Object> handleUserException(AppExceptionError error){
		
		AppException userException = new AppException(
											error.getMessage(),
											error,
											HttpStatus.BAD_REQUEST,
											ZonedDateTime.now(ZoneId.of("UTC"))
									  );
		return new ResponseEntity<>(userException,HttpStatus.BAD_REQUEST);
	}
	
}
