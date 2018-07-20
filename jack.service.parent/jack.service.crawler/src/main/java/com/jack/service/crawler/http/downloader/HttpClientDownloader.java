package com.jack.service.crawler.http.downloader;

import com.jack.service.common.crawler.download.HtmlStaticDownloader;
import com.jack.service.common.crawler.model.PageInfo;

/**
 * 
 * @ClassName: HttpClientDownloader
 * @Description:
 * @author lksoulman
 * @date 2018-06-28 18:23:29
 */
public class HttpClientDownloader extends HtmlStaticDownloader {

	@Override
	public String download(PageInfo pageInfo) {
		String resource;

		if (pageInfo.getRequestType() == 0) {
			resource = doGetDownload(pageInfo);
		} else {
			resource = doPostDownload(pageInfo);
		}

		return resource;
	}

	private String doGetDownload(PageInfo pageInfo) {
		
		
		
		
		return null;
	}

	private String doPostDownload(PageInfo pageInfo) {

		return null;
	}
}
