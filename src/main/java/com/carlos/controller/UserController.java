package com.carlos.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.carlos.entity.User;
import com.carlos.security.JwtUtils;
import com.carlos.security.Login;
import com.carlos.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class UserController {

	@Autowired
	@Qualifier("authenticationManager")
	private AuthenticationManager auth;

	@Autowired
	private UserService userService;
	
	public void setAuth(AuthenticationManager auth) {
		this.auth = auth;
	}

	@RequestMapping(path = "/login", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public User login(@RequestBody Login login, HttpServletResponse response) throws JsonProcessingException {
		Authentication credentials = new UsernamePasswordAuthenticationToken(login.getUsername(), login.getPassword());
		User user = (User) auth.authenticate(credentials).getPrincipal();
		user.setPassword(null);
		response.setHeader("Token", JwtUtils.generateToken(user));
		return user;
	}
	
	@RequestMapping(path = "/register", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public User register(@RequestBody Login login, HttpServletResponse response) throws IllegalArgumentException {
		User user = userService.register(login.getUsername(), login.getPassword());
		return user;
	}
	
	@ExceptionHandler(IllegalArgumentException.class)
	public String conflict(Exception ex, HttpServletResponse response) {
		//TODO a proper exception handling
		response.setContentType("application/json");
		response.setStatus(HttpServletResponse.SC_CONFLICT);
		return ex.getMessage();
	}
	
	@RequestMapping(value = "/**",  method = RequestMethod.OPTIONS)
    public ResponseEntity<Object> handle() {
        return new ResponseEntity<Object>(HttpStatus.OK);
    }
	
}
