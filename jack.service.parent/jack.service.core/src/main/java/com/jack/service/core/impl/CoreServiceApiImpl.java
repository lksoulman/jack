package com.jack.service.core.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jack.service.api.core.CoreServiceApi;
import com.jack.service.core.dao.ConfigDAO;
import com.jack.service.core.id.CreateId;

/**
 * 
 * @ClassName: CoreServiceImpl
 * @Description:
 * @author lksoulman
 * @date 2018-06-07 14:19:59
 */
@Service
public class CoreServiceApiImpl implements CoreServiceApi {

	@Autowired
	private ConfigDAO configDAO;

	@Autowired
	private CreateId creacteId;

	@Override
	public long getCreateId() {
		return creacteId.newId();
	}

	@Override
	public String testApi(String test) {

		return test;
	}
}
