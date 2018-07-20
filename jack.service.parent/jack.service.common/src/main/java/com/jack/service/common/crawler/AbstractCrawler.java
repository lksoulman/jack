package com.jack.service.common.crawler;

import java.util.List;
import com.jack.service.common.crawler.download.Downloader;
import com.jack.service.common.crawler.download.factory.DownloaderFactory;
import com.jack.service.common.crawler.model.GrabRule;
import com.jack.service.common.crawler.model.GrabType;
import com.jack.service.common.crawler.model.LinkInfo;
import com.jack.service.common.crawler.model.PageInfo;
import com.jack.service.common.crawler.parse.Parser;
import com.jack.service.common.crawler.parse.factory.ParserFactory;
import com.jack.service.common.crawler.store.Storage;

/**
 * 
 * @ClassName: AbstractCrawler
 * @Description:
 * @author lksoulman
 * @date 2018-06-28 15:32:30
 */
public abstract class AbstractCrawler {

  Storage storage;

  ParserFactory parserFactory;

  DownloaderFactory downloaderFactory;

  public AbstractCrawler() {
    storage = getStorage();
    parserFactory = getParseFactory();
    downloaderFactory = getDownloaderFactory();
  }

  public void grabWebsiteResource(PageInfo pageInfo, List<String> urls, GrabRule grabRule) {
    urls.forEach(url -> {
      pageInfo.setUrl(url);
      String resource = downloadResource(pageInfo);
      if (resource != null) {
        parseResource(pageInfo, resource, grabRule);
      } else {
        // log
      }
    });
  }

  protected abstract Storage getStorage();

  protected abstract ParserFactory getParseFactory();

  protected abstract DownloaderFactory getDownloaderFactory();

  protected void parseResource(PageInfo pageInfo, String resource, GrabRule grabRule) {
    Object extract = parseExtract(resource, grabRule);
    if (extract != null) {
      if (grabRule.getGrabType() == GrabType.GRAB_LINK) {
        if (extract instanceof List<?>) {
          PageInfo linkPageInfo = (PageInfo) pageInfo.clone();
          @SuppressWarnings("unchecked")
          List<? extends LinkInfo> linkInfos = (List<? extends LinkInfo>) extract;
          linkInfos.forEach(linkInfo -> {
            linkPageInfo.setUrl(linkInfo.getUrl());
            String linkResource = downloadResource(linkPageInfo);
            checkStoreResource(linkResource, pageInfo);
          });
        } else {
          // log
        }
      }
    } else {
      checkStoreResource((String) extract, pageInfo);
    }
  }

  protected String downloadResource(PageInfo pageInfo) {
    Downloader downloader = downloaderFactory.getDownloader(pageInfo.getDownloaderType());
    return downloader.download(pageInfo);
  }

  protected Object parseExtract(String content, GrabRule grabRule) {
    Parser parser = parserFactory.getParser(grabRule.getGrabType());
    return parser.parse(content, grabRule);
  }

  protected void checkStoreResource(String content, PageInfo pageInfo) {
    storage.checkStore(content, pageInfo);
  }
}
