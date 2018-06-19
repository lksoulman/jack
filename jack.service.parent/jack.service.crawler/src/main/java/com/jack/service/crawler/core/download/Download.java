package com.jack.service.crawler.core.download;

import java.io.IOException;

import com.jack.service.crawler.core.download.model.PageInfo;
import com.jack.service.crawler.core.proxy.Proxy;

/**
 * 
 * @ClassName: Download
 * @Description:
 * @author lksoulman
 * @date 2018-06-15 14:46:18
 */
public interface Download {

	/**
	 * 
	 * @Description:
	 * @param downloadInfo
	 * @return String
	 * @author lksoulman
	 * @date 2018-06-15 15:00:14
	 */
	String getHtmlFromUrl(PageInfo pageInfo, Proxy proxy) throws IOException;
}
