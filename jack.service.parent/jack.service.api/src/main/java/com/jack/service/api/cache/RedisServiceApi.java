package com.jack.service.api.cache;

/**
 * 
 * @ClassName: CacheServiceApi
 * @Description:
 * @author lksoulman
 * @date 2018-06-07 13:59:28
 */
public interface RedisServiceApi {

	/**
	 * 
	 * @Description:
	 * @param key
	 * @param value
	 * @return void
	 * @author lksoulman
	 * @date 2018-06-07 14:03:10
	 */
	void put(String key, Object value);

	/**
	 * 
	 * @Description:
	 * @param key
	 * @param value
	 * @param timeout
	 * @return void
	 * @author lksoulman
	 * @date 2018-06-07 14:03:39
	 */
	void put(String key, Object value, int timeout);

	/**
	 * 
	 * @Description:
	 * @param key
	 * @return Object
	 * @author lksoulman
	 * @date 2018-06-07 14:06:23
	 */
	Object get(String key);
}
