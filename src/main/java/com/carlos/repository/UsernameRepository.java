package com.carlos.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.carlos.entity.Username;

@Repository
public interface UsernameRepository extends CrudRepository<Username, Long>{
	
	public Username findByUsername(String username);

}
