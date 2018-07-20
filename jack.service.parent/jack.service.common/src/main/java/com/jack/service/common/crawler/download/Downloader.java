package com.jack.service.common.crawler.download;

import com.jack.service.common.crawler.model.PageInfo;
import com.jack.service.common.crawler.proxy.Proxy;

/**
 * 
 * @ClassName: Downloader
 * @Description:
 * @author lksoulman
 * @date 2018-06-26 17:10:40
 */
public abstract class Downloader {

	protected Proxy proxy;

	/**
	 * 
	 * @Description: 
	 * @param proxy 
	 * @return void
	 * @author lksoulman
	 * @date 2018-06-26 17:43:35
	 */
	public void setProxy(Proxy proxy) {
		this.proxy = proxy;
	}

	/**
	 * 
	 * @Description:
	 * @param map
	 * @return String
	 * @author lksoulman
	 * @date 2018-06-26 17:11:02
	 */
	public abstract String download(PageInfo pageInfo);
}
