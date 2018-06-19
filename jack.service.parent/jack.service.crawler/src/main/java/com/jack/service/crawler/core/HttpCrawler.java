package com.jack.service.crawler.core;

import org.springframework.stereotype.Component;

import com.jack.service.crawler.core.download.Download;
import com.jack.service.crawler.core.download.impl.HtmlunitDownloadImpl;
import com.jack.service.crawler.core.download.impl.JsoupDownloadImpl;
import com.jack.service.crawler.core.download.model.PageInfo;
import com.jack.service.crawler.core.proxy.Proxy;
import com.jack.service.crawler.core.proxy.impl.ProxyImpl;

/**
 * 
 * @ClassName: Download
 * @Description:
 * @author lksoulman
 * @date 2018-06-15 10:10:11
 */
@Component("httpCrawler")
public class HttpCrawler {

	// 静态网页下载 （不用加载js页面）
	private static final int PAGE_TYPE_STATIC = 0;
	// 动态网页下载（要加载js页面）
	private static final int PAGE_TYPE_DYNAMIC = 1;
	// 动态 ip 代理
	private final Proxy proxy = new ProxyImpl();

	/**
	 * 
	 * @Description:
	 * @param map
	 * @return String
	 * @author lksoulman
	 * @date 2018-06-15 10:17:38
	 */
	public String getHtmlFromUrl(PageInfo downloadInfo) throws Exception {

		Download download = null;

		switch (downloadInfo.getPageType()) {
		case PAGE_TYPE_STATIC:
			download = new JsoupDownloadImpl();
		case PAGE_TYPE_DYNAMIC:
			download = new HtmlunitDownloadImpl();
		default:
			break;
		}

		return download != null ? download.getHtmlFromUrl(downloadInfo, proxy) : null;
	}

	/**
	 * 
	 * @Description:
	 * @param map
	 * @return String
	 * @author lksoulman
	 * @date 2018-06-15 10:17:46
	 */
	public String getJsonFromUrl(PageInfo downloadInfo) {
		return null;
	}
}
