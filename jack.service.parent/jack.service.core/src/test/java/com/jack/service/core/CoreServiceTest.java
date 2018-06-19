package com.jack.service.core;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jack.service.api.core.CoreServiceApi;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:application-context.xml")
public class CoreServiceTest extends AbstractJUnit4SpringContextTests {

	@Autowired
	private CoreServiceApi coreServiceApi;

	@Test
	public void testCoreService() {
		System.out.println(coreServiceApi.testApi("coreServiceApi"));
	}
}
