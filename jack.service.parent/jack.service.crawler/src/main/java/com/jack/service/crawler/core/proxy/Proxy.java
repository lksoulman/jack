package com.jack.service.crawler.core.proxy;

import org.jsoup.Connection;

/**
 * 
 * @ClassName: CallProxy
 * @Description:
 * @author lksoulman
 * @date 2018-06-15 15:45:47
 */
public interface Proxy {

	/**
	 * 
	 * @Description:
	 * @param connection
	 * @return void
	 * @author lksoulman
	 * @date 2018-06-15 15:46:04
	 */
	void call(Connection connection);
}
