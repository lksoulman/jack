package com.jack.service.common.crawler.download.factory;

import com.jack.service.common.crawler.download.Downloader;
import com.jack.service.common.crawler.model.DownloadType;

/**
 * 
 * @ClassName: DownloaderFactory
 * @Description:
 * @author lksoulman
 * @date 2018-06-26 17:28:14
 */
public interface DownloaderFactory {

  Downloader getDownloader(DownloadType downloadType);
}
