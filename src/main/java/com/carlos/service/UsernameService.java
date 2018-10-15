package com.carlos.service;

import com.carlos.entity.Username;

public interface UsernameService {

	Username register(String login, String password) throws IllegalArgumentException;
	
}
