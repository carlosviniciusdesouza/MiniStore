package com.carlos.service;

import com.carlos.entity.User;

public interface UserService {

	User register(String login, String password) throws IllegalArgumentException;
	
}
