package com.jack.service.core.sharding.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.jack.service.common.jdbc.BaseJdbcTemplate;
import com.jack.service.core.sharding.dao.ShardingDAO;

/**
 * 
 * @ClassName: ShardingDAOImpl
 * @Description:
 * @author lksoulman
 * @date 2018-06-25 17:02:48
 */
@Repository
public class ShardingDAOImpl implements ShardingDAO {

	@Autowired
	private BaseJdbcTemplate shardingTemplate;

	@Override
	public List<Map<String, Object>> queryList(String sql, Map<String, ?> paramMap) throws Exception {
		return shardingTemplate.queryForList(sql, paramMap);
	}
}
