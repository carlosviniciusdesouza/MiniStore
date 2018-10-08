package com.carlos.service;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.carlos.entity.User;
import com.carlos.entity.Authorization;
import com.carlos.repository.AuthorizationRepository;
import com.carlos.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	
	private static final String ROLE_USER = "ROLE_USER";
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private AuthorizationRepository authorizationRepository;
	
	@Override
	public User register(String login, String password) throws IllegalArgumentException{
		if(userRepository.findByUsername(login) != null){
			throw new IllegalArgumentException("O Usuário já existe");
		};
		
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(12);
		
		Authorization authorizationUser = authorizationRepository.findFirstByAuthority(ROLE_USER);

		List<Authorization> list = new ArrayList<Authorization>();
		list.add(authorizationUser);
		
		User usuario = new User();
		usuario.setUsername(login);
		usuario.setPassword(passwordEncoder.encode(password));
		usuario.setAuthorizations(list);
		userRepository.save(usuario);
		return usuario;
	}

}
