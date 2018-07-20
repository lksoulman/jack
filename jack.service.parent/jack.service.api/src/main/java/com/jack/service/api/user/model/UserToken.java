package com.jack.service.api.user.model;

import lombok.Data;

/**
 * 
 * @ClassName: UserToken
 * @Description:
 * @author lksoulman
 * @date 2018-06-07 14:12:10
 */

@Data
public class UserToken {

	private String id;
	private int expireTime;
}
