package com.financial.control.exceptions;

import java.time.ZonedDateTime;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class AppException {

	public String message;
	public Throwable throwable;
	public HttpStatus statusCode;
	public ZonedDateTime zonedDateTime;
	
}
