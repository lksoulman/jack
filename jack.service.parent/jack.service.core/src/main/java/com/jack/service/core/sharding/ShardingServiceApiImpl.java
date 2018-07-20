package com.jack.service.core.sharding;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jack.service.api.core.ShardingServiceApi;
import com.jack.service.core.sharding.dao.ShardingDAO;

/**
 * 
 * @ClassName: ShardingServiceApiImpl
 * @Description:
 * @author lksoulman
 * @date 2018-06-25 17:01:56
 */
@Service
public class ShardingServiceApiImpl implements ShardingServiceApi {

	@Autowired
	private ShardingDAO shardingDAO;

	@Override
	public List<Map<String, Object>> queryList(String sql, Map<String, ?> paramMap) throws Exception {
		return shardingDAO.queryList(sql, paramMap);
	}
}
