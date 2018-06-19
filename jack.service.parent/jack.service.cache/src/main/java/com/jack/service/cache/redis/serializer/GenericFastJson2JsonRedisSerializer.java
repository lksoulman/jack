package com.jack.service.cache.redis.serializer;

import java.nio.charset.Charset;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

/**
 * 
 * @ClassName: FastJson2JsonRedisSerializer
 * @Description:
 * @author lksoulman
 * @date 2018-06-14 09:20:18
 */
public class GenericFastJson2JsonRedisSerializer implements RedisSerializer<Object> {

	/**
	 * 字符集
	 */
	public static final Charset DEFAULT_CHARSET = Charset.forName("UTF-8");

	@Override
	public byte[] serialize(Object object) throws SerializationException {
		if (object == null) {
			return new byte[0];
		}
		try {
			return JSON.toJSONString(object, SerializerFeature.WriteClassName).getBytes(DEFAULT_CHARSET);
		} catch (Exception ex) {
			throw new SerializationException("Could not serialize: " + ex.getMessage(), ex);
		}
	}

	@Override
	public Object deserialize(byte[] bytes) throws SerializationException {
		if (bytes == null || bytes.length <= 0) {
			return null;
		}
		try {
			return (Object) JSON.parseObject(new String(bytes, DEFAULT_CHARSET), Object.class);
		} catch (Exception ex) {
			throw new SerializationException("Could not deserialize: " + ex.getMessage(), ex);
		}
	}
}
