package com.jack.service.web.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jack.service.api.info.Const;
import com.jack.service.api.info.MsgInfo;
import com.jack.service.api.user.UserServiceApi;
import com.jack.service.api.user.model.UserInfo;
import com.jack.service.common.json.JsonUtils;

@Controller
@RequestMapping(value = "/user")
public class UserController {

	@Autowired
	private UserServiceApi userServiceApi;

	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	public String login() {
		return "getLogin";
	}

	@ResponseBody
	@RequestMapping(value = "/register.do", method = RequestMethod.POST)
	public String register(@RequestBody String jsonUserInfo) {
		MsgInfo msgInfo;  
 
		UserInfo userInfo = JsonUtils.parseObject(jsonUserInfo, UserInfo.class);
		if (userInfo != null) {
			msgInfo = userServiceApi.register(userInfo);
		} else {
			msgInfo = new MsgInfo();
			msgInfo.setCode(Const.CODE_REGISTER_FORMAT_ERROR);
		}

		return JsonUtils.toString(msgInfo);
	}
}
