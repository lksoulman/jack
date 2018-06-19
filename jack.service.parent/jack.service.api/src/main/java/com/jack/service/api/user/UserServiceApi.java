package com.jack.service.api.user;

import com.jack.service.api.info.MsgInfo;
import com.jack.service.api.user.model.UserInfo;

/**
 * 
 * @ClassName: UserServiceApi
 * @Description:
 * @author lksoulman
 * @date 2018-06-07 14:11:49
 */
public interface UserServiceApi {

	/**
	 * 
	 * @Description:
	 * @return boolean
	 * @author lksoulman
	 * @date 2018-06-08 09:50:39
	 */
	MsgInfo register(UserInfo userInfo);

	/**
	 * 
	 * @Description:
	 * @param name
	 * @param password
	 * @return void
	 * @author lksoulman
	 * @date 2018-06-08 09:53:22
	 */
	MsgInfo login(String name, String password);

	/**
	 * 
	 * @Description:
	 * @param session
	 * @return String
	 * @author lksoulman
	 * @date 2018-06-08 09:57:35
	 */
	MsgInfo getUserInfo(String session);

	/**
	 * 
	 * @Description:
	 * @param session
	 * @return
	 * @return String
	 * @author lksoulman
	 * @date 2018-06-08 09:59:06
	 */
	MsgInfo getAuthorizationList(String session);

	/**
	 * 
	 * @Description:
	 * @param test
	 * @return String
	 * @author lksoulman
	 * @date 2018-06-08 09:52:02
	 */
	String testApi(String test);
}
