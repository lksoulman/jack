package com.jack.service.crawler.task.impl;

import java.util.Map;

import org.apache.commons.collections4.MapUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.jack.service.api.exception.JobException;
import com.jack.service.crawler.core.HttpCrawler;
import com.jack.service.crawler.core.download.model.PageInfo;
import com.jack.service.crawler.dao.CrawlerDAO;
import com.jack.service.crawler.task.HttpCrawlerSchedular;

/**
 * 
 * @ClassName: HttpCrawlerSchedularImpl 
 * @Description:  
 * @author lksoulman 
 * @date 2018-06-15 16:33:42
 */
public class HttpCrawlerSchedularImpl implements HttpCrawlerSchedular {

	@Autowired
	private  CrawlerDAO crawlerDAO;
	
	@Autowired
	private HttpCrawler httpCrawler;
	
	@Override
	public void execute(Map<String, Object> paramMap) throws JobException {
		int id = MapUtils.getIntValue(paramMap, "id", -1);
		if (id != -1) {
		    PageInfo pageInfo = crawlerDAO.getPageInfoById(id);
			
		}
	}
}
