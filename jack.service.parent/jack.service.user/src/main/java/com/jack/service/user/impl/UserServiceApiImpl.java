package com.jack.service.user.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jack.service.api.core.CoreServiceApi;
import com.jack.service.api.info.Const;
import com.jack.service.api.info.MsgInfo;
import com.jack.service.api.user.UserServiceApi;
import com.jack.service.api.user.model.UserInfo;
import com.jack.service.common.id.SnowflakeIdFactory;
import com.jack.service.user.dao.UserInfoDAO;

/**
 * 
 * @ClassName: UserServiceApiImpl
 * @Description:
 * @author lksoulman
 * @date 2018-06-07 14:30:02
 */

@Service
public class UserServiceApiImpl implements UserServiceApi {

	@Autowired
	private CoreServiceApi coreServiceApi;

	@Autowired
	private UserInfoDAO userInfoDAO;

	// @Autowired
	// private UserTokenDAO userTokenDAO;

	@Override
	public MsgInfo register(UserInfo userInfo) {
		MsgInfo msgInfo = new MsgInfo();
		try {
			userInfo.setId(coreServiceApi.getCreateId());
			if (userInfoDAO.register(userInfo)) {
				msgInfo.setCode(Const.CODE_SUCCESS);
			} else {
				msgInfo.setCode(Const.CODE_REGISTER_FAIL);
			}
		} catch (Exception exception) {
			msgInfo.setCode(Const.CODE_REGISTER_FAIL);
			msgInfo.setMessage(exception.getMessage());
		}
		return msgInfo;
	}

	@Override
	public MsgInfo login(String name, String password) {
		MsgInfo msgInfo = new MsgInfo();
		UserInfo userInfo = userInfoDAO.getUserInfoByName(name);
		if (userInfo != null) {
			if (password.equals(userInfo.getPassword())) {
				msgInfo.setCode(Const.CODE_SUCCESS);
				msgInfo.setMessage("");
				msgInfo.setData(userInfo);
			} else {
				msgInfo.setCode(Const.CODE_LOGIN_PASSWORD);
				msgInfo.setMessage("");
			}
		} else {
			msgInfo.setCode(Const.CODE_LOGIN_NOTEXISTS);
			msgInfo.setMessage("");
		}

		return msgInfo;
	}

	@Override
	public MsgInfo getUserInfo(String session) {
		MsgInfo msgInfo = new MsgInfo();

		return msgInfo;
	}

	@Override
	public MsgInfo getAuthorizationList(String session) {
		MsgInfo msgInfo = new MsgInfo();

		return msgInfo;
	}

	@Override
	public String testApi(String test) {

		return test;
	}
}
