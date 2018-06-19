package com.jack.service.api.user.model;

import java.io.Serializable;

import lombok.Data;

/**
 * 
 * @ClassName: UserInfo
 * @Description:
 * @author lksoulman
 * @date 2018-06-07 14:12:02
 */
@Data
public class UserInfo implements Serializable {

	/**
	 * @Fields serialVersionUID :
	 * @author lksoulman
	 */
	private static final long serialVersionUID = 6699590578381604612L;

	// user id
	private long id;
	// user name
	private String name;
	// user password
	private String password;
	// user phone
	private String phone;
	// user mail
	private String mail;
}
