package com.jack.service.cache.redis.dao;

import java.util.Collection;

/**
 * 
 * @ClassName: RedisCacheDAO
 * @Description:
 * @author lksoulman
 * @date 2018-06-07 14:13:54
 */
public interface RedisDAO<K, V> {

	/**
	 * 
	 * @Description:
	 * @param key
	 * @param value
	 * @return void
	 * @author lksoulman
	 * @date 2018-06-07 14:13:59
	 */
	void put(K key, V value);

	/**
	 * 
	 * @Description:
	 * @param key
	 * @param value
	 * @param expireTime
	 * @return void
	 * @author lksoulman
	 * @date 2018-06-07 14:14:05
	 */
	void put(K key, V value, int expireTime);

	/**
	 * 
	 * @Description:
	 * @param key
	 * @return Object
	 * @author lksoulman
	 * @date 2018-06-07 14:14:12
	 */
	Object get(K key);

	/**
	 * 
	 * @Description:
	 * @param key
	 * @return boolean
	 * @author lksoulman
	 * @date 2018-06-07 14:14:27
	 */
	boolean delete(K key);

	/**
	 * 
	 * @Description:
	 * @param keys
	 * @return void
	 * @author lksoulman
	 * @date 2018-06-07 14:14:37
	 */
	void delete(Collection<K> keys);

	/**
	 * 
	 * @Description:
	 * @param key
	 * @return boolean
	 * @author lksoulman
	 * @date 2018-06-07 14:14:48
	 */
	boolean exists(K key);
}
