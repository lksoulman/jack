package com.jack.service.common.sqlconfig;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.jack.service.common.exception.SqlConfigException;

/**
 * 
 * @ClassName: SqlConfig
 * @Description:
 * @author lksoulman
 * @date 2018-06-08 10:32:30
 */
public class SqlConfig {

	/**
	 * sql map
	 */
	private Map<String, String> sqlMap = new HashMap<>();

	/**
	 * 
	 * @Description:
	 * @return Map<String,String>
	 * @author lksoulman
	 * @date 2018-06-08 10:48:47
	 */
	public Map<String, String> getSqlMap() {
		return sqlMap;
	}

	/**
	 * 
	 * @Description:
	 * @param sqlMap
	 * @return void
	 * @author lksoulman
	 * @date 2018-06-08 10:48:56
	 */
	public void setSqlMap(Map<String, String> sqlMap) {
		this.sqlMap = sqlMap;
	}

	/**
	 * 
	 * @Description:
	 * @param keys
	 * @return void
	 * @author lksoulman
	 * @date 2018-06-08 10:49:02
	 */
	public void setMapNullValue(String... keys) {
		for (String key : keys) {
			if (sqlMap.containsKey(key)) {
				sqlMap.put(key, "");
			}
		}
	}

	/**
	 * 
	 * @Description: 
	 * @param sqlName
	 * @return
	 * @throws SqlConfigException 
	 * @author lksoulman
	 * @date 2018-06-08 10:55:10
	 */
	public String getSql(String sqlName) throws SqlConfigException {
		if (!sqlMap.containsKey(sqlName)) {
			throw new SqlConfigException(sqlName + "sql语句不存在");
		}
		return StringUtils.trim(sqlMap.get(sqlName));
	}
}
