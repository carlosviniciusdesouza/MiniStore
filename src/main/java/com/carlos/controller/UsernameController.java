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
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.carlos.entity.Username;
import com.carlos.security.JwtUtils;
import com.carlos.security.Login;
import com.carlos.service.UsernameService;
import com.fasterxml.jackson.core.JsonProcessingException;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class UsernameController {

	@Autowired
	@Qualifier("authenticationManager")
	private AuthenticationManager auth;

	@Autowired
	private UsernameService userService;
	
	public void setAuth(AuthenticationManager auth) {
		this.auth = auth;
	}
	
	@RequestMapping(path = "/login", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public Username login(@RequestBody Login login, HttpServletResponse response) throws JsonProcessingException {
		Authentication credentials = new UsernamePasswordAuthenticationToken(login.getUsername(), login.getPassword());
		Username user = (Username) auth.authenticate(credentials).getPrincipal();
		user.setPassword(null);
		response.setHeader("Token", JwtUtils.generateToken(user));
		return user;
	}
	
	@RequestMapping(path = "/register", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public Username register(@RequestBody Login login, HttpServletResponse response) throws IllegalArgumentException {
		Username user = userService.register(login.getUsername(), login.getPassword());
		return user;
	}
	
	@RequestMapping(value = "/**",  method = RequestMethod.OPTIONS)
    public ResponseEntity<Object> handle() {
        return new ResponseEntity<Object>(HttpStatus.OK);
    }
	
}
