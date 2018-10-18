package com.carlos.service;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.carlos.entity.Username;
import com.carlos.entity.Authorization;
import com.carlos.repository.AuthorizationRepository;
import com.carlos.repository.UsernameRepository;

@Service
public class UsernameServiceImpl implements UsernameService{
	
	private static final String ROLE_USER = "ROLE_USER";
	
	@Autowired
	private UsernameRepository userRepository;
	
	@Autowired
	private AuthorizationRepository authorizationRepository;
	
	@Override
	public Username register(String login, String password) throws IllegalArgumentException{
		if(userRepository.findByUsername(login) != null){
			throw new IllegalArgumentException("The Username already exists");
		};
		
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(12);
		
		Authorization authorizationUser = authorizationRepository.findFirstByAuthority(ROLE_USER);

		List<Authorization> list = new ArrayList<Authorization>();
		list.add(authorizationUser);
		
		Username usuario = new Username();
		usuario.setUsername(login);
		usuario.setPassword(passwordEncoder.encode(password));
		usuario.setAuthorizations(list);
		userRepository.save(usuario);
		return usuario;
	}

}
