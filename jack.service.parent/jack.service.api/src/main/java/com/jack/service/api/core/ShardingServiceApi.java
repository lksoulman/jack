package com.jack.service.api.core;

import java.util.List;
import java.util.Map;

/**
 * 
 * @ClassName: ShardingServiceApi
 * @Description:
 * @author lksoulman
 * @date 2018-06-25 17:01:31
 */
public interface ShardingServiceApi {

	/**
	 * 
	 * @Description:
	 * @param sql
	 * @param paramMap
	 * @throws Exception
	 * @return List<Map<String,Object>>
	 * @author lksoulman
	 * @date 2018-06-25 17:12:28
	 */
	List<Map<String, Object>> queryList(String sql, Map<String, ?> paramMap) throws Exception;

}
