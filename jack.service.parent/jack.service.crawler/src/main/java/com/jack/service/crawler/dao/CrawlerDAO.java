package com.jack.service.crawler.dao;

import com.jack.service.crawler.model.CrawlerSiteInfo;

/**
 * 
 * @ClassName: CrawlerDAO
 * @Description:
 * @author lksoulman
 * @date 2018-06-15 16:37:17
 */
public interface CrawlerDAO {

    /**
     * 
     * @Description:
     * @param id
     * @return PageInfo
     * @author lksoulman
     * @date 2018-06-19 14:20:48
     */
    CrawlerSiteInfo getCrawlerSiteInfoById(int id);
}
