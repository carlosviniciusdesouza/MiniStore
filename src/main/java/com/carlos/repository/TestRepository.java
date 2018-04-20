package com.carlos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.carlos.entity.TestEntity;

@Repository
public interface TestRepository extends JpaRepository<TestEntity, Long>{
	
	public TestEntity findByName(String name);
 
}
