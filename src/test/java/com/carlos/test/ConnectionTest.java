package com.carlos.test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import javax.transaction.Transactional;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.carlos.entity.User;
import com.carlos.repository.UserRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath*:spring-context.xml",
		"classpath*:spring-security.xml"})
@Rollback
@Transactional
public class ConnectionTest {
	
	@Autowired
	private UserRepository userRepository;
	
	@Test
	public void connectionDatabaseTest() {
		User test = new User();
		test.setUsername("TEST");
		test.setPassword("TEST");
		userRepository.save(test);
		User found = userRepository.findByUsername("TEST");
		assertThat(found.getUsername(), equalTo(test.getUsername()));
	}

}
