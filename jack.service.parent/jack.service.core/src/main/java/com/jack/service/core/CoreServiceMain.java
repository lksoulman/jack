package com.jack.service.core;

import org.apache.commons.lang3.StringUtils;
import com.alibaba.dubbo.common.utils.NetUtils;

/**
 * 
 * @ClassName: CoreServiceMain
 * @Description:
 * @author lksoulman
 * @date 2018-06-07 16:40:39
 */
public class CoreServiceMain {

	public static void main(String[] args) {
		String host = NetUtils.getLocalAddress().getHostAddress();
		if (StringUtils.isNoneEmpty(host)) {
			System.setProperty("java.rmi.server.hostname", host);
		}
		com.alibaba.dubbo.container.Main.main(args);
	}
}
