package com.jack.service.user.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import com.jack.service.api.cache.RedisServiceApi;
import com.jack.service.user.dao.UserTokenDAO;

/**
 * 
 * @ClassName: UserTokenDAOImpl
 * @Description: (这里用一句话描述这个类的作用)
 * @author lksoulman
 * @date 2018年5月12日 下午8:18:46
 */
public class UserTokenDAOImpl implements UserTokenDAO {

	@Autowired
	private RedisServiceApi cacheServiceApi;

}
