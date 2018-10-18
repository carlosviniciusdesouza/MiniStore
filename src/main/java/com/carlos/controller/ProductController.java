package com.carlos.controller;

import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class ProductController {
	
	@RequestMapping(path = "/ping", method = RequestMethod.POST, produces = MediaType.TEXT_PLAIN_VALUE)
	public String ping(){
		return "ping";
	}
	
	@RequestMapping(path = "/pingadmin", method = RequestMethod.POST, produces = MediaType.TEXT_PLAIN_VALUE)
	@PreAuthorize("hasRole('ADMIN') or hasRole('SELLER')")
	public String pingAdmin(){
		return "pingAdmin";
	}

}
