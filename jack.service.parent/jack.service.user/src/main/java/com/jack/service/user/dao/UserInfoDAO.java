package com.jack.service.user.dao;

import com.jack.service.api.user.model.UserInfo;

/**
 * 
 * @ClassName: UserInfoDAO
 * @Description:
 * @author lksoulman
 * @date 2018-06-07 14:28:29
 */
public interface UserInfoDAO {

	/**
	 * 
	 * @Description:
	 * @param userInfo
	 * @return void
	 * @author lksoulman
	 * @date 2018-06-08 15:25:13
	 */
	public boolean register(UserInfo userInfo) throws Exception;

	/**
	 * 
	 * @Description:
	 * @param name
	 * @param password
	 * @return UserInfo
	 * @author lksoulman
	 * @date 2018-06-07 14:29:00
	 */
	UserInfo getUserInfoByName(String name);

	/**
	 * 
	 * @Description:
	 * @param name
	 * @return UserInfo
	 * @author lksoulman
	 * @date 2018-06-08 13:34:34
	 */
	UserInfo getUserInfoByMail(String mail);

	/**
	 * 
	 * @Description:
	 * @param name
	 * @return UserInfo
	 * @author lksoulman
	 * @date 2018-06-08 13:33:00
	 */
	UserInfo getUserInfoByPhone(String phone);
}
