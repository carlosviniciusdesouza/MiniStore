package com.carlos.repository;

import org.springframework.data.repository.CrudRepository;

import com.carlos.entity.Authorization;


public interface AuthorizationRepository extends CrudRepository<Authorization, Long>{

	//public Authorization findFirstByName(String roleUser);

	public Authorization findFirstByAuthority(String roleUser);

}
