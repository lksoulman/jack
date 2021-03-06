package com.jack.service.cache.redis.dao.impl;

import java.util.Collection;
import java.util.concurrent.TimeUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.jack.service.cache.redis.dao.RedisDAO;

/**
 * 
 * @ClassName: FastJsonValueRedisCacheDAOImpl
 * @Description:
 * @author lksoulman
 * @date 2018-06-07 14:15:19
 */
@Service
public class FastJsonDAOImpl implements RedisDAO<String, Object> {

	@Autowired
	@Qualifier("fastJsonTemplate")
	RedisTemplate<String, Object> redisTemplate;

	public FastJsonDAOImpl() {
		super();
	}

	@Override
	public void put(String key, Object value) {
		redisTemplate.opsForValue().set(key, value);
	}

	@Override
	public void put(String key, Object value, int expireTime) {
		redisTemplate.opsForValue().set(key, value, expireTime, TimeUnit.SECONDS);
	}

	@Override
	public Object get(String key) {
		return redisTemplate.opsForValue().get(key);
	}

	@Override
	public boolean delete(String key) {
		return false;
	}

	@Override
	public void delete(Collection<String> keys) {
		redisTemplate.delete(keys);
	}

	@Override
	public boolean exists(String key) {
		return redisTemplate.hasKey(key);
	}
}
