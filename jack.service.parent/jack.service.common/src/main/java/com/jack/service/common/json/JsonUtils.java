package com.jack.service.common.json;

import com.alibaba.fastjson.JSONObject;

/**
 * 
 * @ClassName: JsonUtils
 * @Description:
 * @author lksoulman
 * @date 2018-06-08 15:13:35
 */
public class JsonUtils {

	/**
	 * 
	 * @Description:
	 * @param object
	 * @return String
	 * @author lksoulman
	 * @date 2018-06-08 15:15:50
	 */
	public static String toString(Object object) {
		return JSONObject.toJSONString(object);
	}

	/**
	 * 
	 * @Description:
	 * @param json
	 * @param clazz
	 * @return T
	 * @author lksoulman
	 * @date 2018-06-08 15:31:53
	 */
	public static <T> T parseObject(String json, Class<T> clazz) {
		return JSONObject.parseObject(json, clazz);
	}
}
