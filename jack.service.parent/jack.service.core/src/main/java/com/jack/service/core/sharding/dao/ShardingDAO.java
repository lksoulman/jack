package com.jack.service.core.sharding.dao;

import java.util.List;
import java.util.Map;

/**
 * 
 * @ClassName: ShardingDAO
 * @Description:
 * @author lksoulman
 * @date 2018-06-25 17:13:38
 */
public interface ShardingDAO {

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
