package com.carlos.test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import javax.transaction.Transactional;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.carlos.entity.Username;
import com.carlos.repository.UsernameRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath*:test/spring-context.xml",
		"classpath*:test/spring-security.xml"})
@Rollback
@Transactional
public class ConnectionTest extends AbstractDatabaseTest{
	
	@Autowired
	private UsernameRepository userRepository;
	
	@Test
	public void connectionDatabaseTest() {
		Username test = new Username();
		test.setUsername("TEST");
		test.setPassword("TEST");
		userRepository.save(test);
		Username found = userRepository.findByUsername("TEST");
		assertThat(found.getUsername(), equalTo(test.getUsername()));
	}

}
