package com.carlos.controller;

import java.time.ZonedDateTime;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/errors")
public class ErrorController {

	
	private static final String UNAUTHORIZED = "Unauthorized"; //TODO resource file
	private static final String FORBIDDEN = "Forbidden";

	@RequestMapping(path = "/unauthorised", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<ErrorResponse> unauthorizedRequest(HttpServletRequest request) {
		//TODO a proper error handling
		ErrorResponse responseObject = new ErrorResponse(UNAUTHORIZED);
		return new ResponseEntity<ErrorResponse>( responseObject, HttpStatus.UNAUTHORIZED);
	}
	
	@RequestMapping(path = "/forbidden", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<ErrorResponse> forbiddenRequest() {
		//TODO a proper error handling
		ErrorResponse responseObject = new ErrorResponse(FORBIDDEN);
		return new ResponseEntity<ErrorResponse>( responseObject, HttpStatus.FORBIDDEN);
	}
	
}

class ErrorResponse{
	public String message;
	public String time =  ZonedDateTime.now().toString();
	public ErrorResponse(String messageIn) {
		message = messageIn;
	}
	//TODO utf-8 response
	//TODO add more information on the this class
}
