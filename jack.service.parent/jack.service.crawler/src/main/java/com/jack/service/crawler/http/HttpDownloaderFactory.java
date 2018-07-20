package com.jack.service.crawler.http;

import com.jack.service.common.crawler.download.HtmlDownloader;
import com.jack.service.common.crawler.download.JsonDownloader;
import com.jack.service.common.crawler.download.factory.impl.AbstractDownloaderFactory;
import com.jack.service.crawler.http.downloader.JsoupDownloader;
import com.jack.service.crawler.http.downloader.PhantomJSDownloader;

/**
 * 
 * @ClassName: HttpDownloaderFactory
 * @Description:
 * @author lksoulman
 * @date 2018-06-28 15:57:12
 */
public class HttpDownloaderFactory extends AbstractDownloaderFactory {

    @Override
    protected JsonDownloader getJsonDonwloader() {
        return null;
    }

    @Override
    protected HtmlDownloader getHtmlStaticDownloader() {
        return new JsoupDownloader();
    }

    @Override
    protected HtmlDownloader getHtmlDynamicDownloader() {
        return new PhantomJSDownloader();
    }

}
