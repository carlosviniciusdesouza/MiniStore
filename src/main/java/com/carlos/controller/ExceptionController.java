package com.carlos.controller;

import java.time.ZonedDateTime;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {
	
	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<ExceptionResponse> conflict(Exception ex) {
		//TODO a proper exception handling
		ExceptionResponse responseObject = new ExceptionResponse(ex.getMessage());
		System.out.println(ex.getMessage());
		return new ResponseEntity<ExceptionResponse>(responseObject, HttpStatus.CONFLICT);
	}
}

class ExceptionResponse{
	public String message;
	public String time =  ZonedDateTime.now().toString();
	public ExceptionResponse(String messageIn) {
		message = messageIn;
	}
	//TODO utf-8 response
	//TODO add more information on the this class
}