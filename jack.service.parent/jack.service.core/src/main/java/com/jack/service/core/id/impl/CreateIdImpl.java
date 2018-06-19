package com.jack.service.core.id.impl;

import org.springframework.stereotype.Service;
import com.jack.service.common.id.SnowflakeIdFactory;
import com.jack.service.core.id.CreateId;

/**
 * 
 * @ClassName: CreateIdImpl
 * @Description:
 * @author lksoulman
 * @date 2018-06-13 18:23:59
 */
@Service
public class CreateIdImpl implements CreateId {

	private SnowflakeIdFactory factory = new SnowflakeIdFactory(0, 0);

	@Override
	public long newId() {
		return factory.getId();
	}
}
