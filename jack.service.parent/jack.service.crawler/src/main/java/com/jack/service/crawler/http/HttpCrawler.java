package com.jack.service.crawler.http;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jack.service.common.crawler.AbstractCrawler;
import com.jack.service.common.crawler.download.factory.DownloaderFactory;
import com.jack.service.common.crawler.model.GrabRule;
import com.jack.service.common.crawler.model.PageInfo;
import com.jack.service.common.crawler.parse.factory.ParserFactory;
import com.jack.service.common.crawler.store.Storage;
import com.jack.service.common.json.JsonUtils;
import com.jack.service.crawler.dao.CrawlerDAO;
import com.jack.service.crawler.model.CrawlerSiteInfo;

/**
 * 
 * @ClassName: HttpCrawler
 * @Description:
 * @author lksoulman
 * @date 2018-06-28 15:57:01
 */
@Component
public class HttpCrawler extends AbstractCrawler {

	@Autowired
	private CrawlerDAO crawlerDAO;

	/**
	 * 
	 * @Description:
	 * @param paramMap
	 * @return void
	 * @author lksoulman
	 * @date 2018-06-28 16:57:03
	 */
	public void crawler(Map<String, Object> paramMap) {
		int siteId = MapUtils.getIntValue(paramMap, "siteId", -1);
		if (siteId != -1) {
			CrawlerSiteInfo crawlerSiteInfo = crawlerDAO.getCrawlerSiteInfoById(siteId);
			if (crawlerSiteInfo == null)
				return;

			PageInfo pageInfo = getPageInfo(crawlerSiteInfo);
			GrabRule grabRule = getGrabRule(crawlerSiteInfo);
			List<String> urls = getUrls(crawlerSiteInfo.getUrl());
			grabWebsiteResource(pageInfo, urls, grabRule);
		}
	}

	/**
	 * 
	 * @Description:
	 * @param crawlerSiteInfo
	 * @return PageInfo
	 * @author lksoulman
	 * @date 2018-06-28 18:15:20
	 */
	private PageInfo getPageInfo(CrawlerSiteInfo crawlerSiteInfo) {
		PageInfo pageInfo = new PageInfo();

		return pageInfo;
	}

	/**
	 * 
	 * @Description:
	 * @param crawlerSiteInfo
	 * @return GrabRule
	 * @author lksoulman
	 * @date 2018-06-28 18:15:26
	 */
	private GrabRule getGrabRule(CrawlerSiteInfo crawlerSiteInfo) {
		GrabRule grabRule;

		if (StringUtils.isNotEmpty(crawlerSiteInfo.getGrabRule())) {
			grabRule = JsonUtils.parseObject(crawlerSiteInfo.getGrabRule(), GrabRule.class);
		} else {
			grabRule = new GrabRule();
		}

		return grabRule;
	}

	/**
	 * 
	 * @Description:
	 * @param url
	 * @return List<String>
	 * @author lksoulman
	 * @date 2018-06-28 18:15:35
	 */
	private List<String> getUrls(String url) {
		String[] urls = StringUtils.split(url, "##");

		return Arrays.asList(urls);
	}

	@Override
	protected Storage getStorage() {
		return new HttpStorage();
	}

	@Override
	protected ParserFactory getParseFactory() {
		return new HttpParserFactory();
	}

	@Override
	protected DownloaderFactory getDownloaderFactory() {
		return new HttpDownloaderFactory();
	}
}
