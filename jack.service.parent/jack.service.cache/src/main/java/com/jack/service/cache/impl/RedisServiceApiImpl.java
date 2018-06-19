package com.jack.service.cache.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.jack.service.api.cache.RedisServiceApi;
import com.jack.service.cache.redis.dao.RedisDAO;

/**
 * 
 * @ClassName: RedisCacheServiceApiImpl
 * @Description:
 * @author lksoulman
 * @date 2018-06-07 14:16:26
 */
@Service
public class RedisServiceApiImpl implements RedisServiceApi {

	@Autowired
	@Qualifier("fastJsonDAOImpl")
	RedisDAO<String, Object> fastJsonDAO;

	@Autowired
	@Qualifier("jacksonDAOImpl")
	RedisDAO<String, Object> jacksonDAO;

	@Override
	public void put(String key, Object value) {
		fastJsonDAO.put(key, value);
	}

	@Override
	public void put(String key, Object value, int timeout) {
		fastJsonDAO.put(key, value, timeout);
	}

	@Override
	public Object get(String key) {
		return fastJsonDAO.get(key);
	}
}
