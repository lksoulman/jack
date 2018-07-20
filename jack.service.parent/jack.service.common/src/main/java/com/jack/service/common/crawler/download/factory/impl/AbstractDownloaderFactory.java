package com.jack.service.common.crawler.download.factory.impl;

import com.jack.service.common.crawler.download.Downloader;
import com.jack.service.common.crawler.download.HtmlDownloader;
import com.jack.service.common.crawler.download.JsonDownloader;
import com.jack.service.common.crawler.download.factory.DownloaderFactory;
import com.jack.service.common.crawler.model.DownloadType;
import com.jack.service.common.crawler.proxy.Proxy;

/**
 * 
 * @ClassName: DownloaderFactoryImpl
 * @Description:
 * @author lksoulman
 * @date 2018-06-26 17:30:10
 */
public abstract class AbstractDownloaderFactory implements DownloaderFactory {

	private Proxy proxy;

	@Override
	public synchronized Downloader getDownloader(DownloadType downloadType) {
		Downloader downloader = null;

		switch (downloadType) {
		case HTML_DYNAMIC:
			downloader = getHtmlDynamicDownloader();
			break;
		case HTML_STATIC:
			downloader = getHtmlStaticDownloader();
			break;
		case JSON:
			downloader = getJsonDonwloader();
		}

		if (downloader != null) {
			downloader.setProxy(proxy);
		}

		return downloader;
	}

	protected abstract JsonDownloader getJsonDonwloader();

	protected abstract HtmlDownloader getHtmlStaticDownloader();

	protected abstract HtmlDownloader getHtmlDynamicDownloader();
}
