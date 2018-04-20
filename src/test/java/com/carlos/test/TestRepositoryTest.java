package com.carlos.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.carlos.entity.TestEntity;
import com.carlos.repository.TestRepository;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-context.xml")
@Rollback
@Transactional
public class TestRepositoryTest {
	
	@Autowired
	private TestRepository testRepository;
	
	@Test
	public void testeInsercaoOk() {
		TestEntity test = new TestEntity();
		test.setName("TESTE");
		testRepository.save(test);
		System.out.println(test.getId());
		assertFalse(test.getId() == 0L);
	}

}
