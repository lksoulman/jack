package com.jack.service.user;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jack.service.api.user.UserServiceApi;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:META-INF/spring/application-context.xml")
public class UserServiceTest extends AbstractJUnit4SpringContextTests {

	@Autowired
	private UserServiceApi userServiceApi;

	@Test
	public void testUserServiceApi() {
		System.out.println(userServiceApi.testApi("testUserServiceApi"));
	}
}
