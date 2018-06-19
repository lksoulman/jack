package com.jack.service.cache;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jack.service.api.cache.RedisServiceApi;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:META-INF/spring/application-context.xml")
public class CacheServiceTest extends AbstractJUnit4SpringContextTests {

	@Autowired
	private RedisServiceApi redisServiceApi;

	@Test
	public void testRedisServiceApi() {
		redisServiceApi.put("test", "testRedisServiceApi");
		String string = (String) redisServiceApi.get("test");
		System.out.println(string);
	}
}
