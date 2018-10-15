package com.carlos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.carlos.entity.Username;
import com.carlos.repository.UsernameRepository;

@Service("securityService")
public class SecurityServiceImpl implements UserDetailsService {
	
	@Autowired
	private UsernameRepository userRepository;

	public void setUserRepository(UsernameRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Username user = userRepository.findByUsername(username);
		if(user == null) {
			throw new UsernameNotFoundException(username);
		}
		return user;
	}

}
