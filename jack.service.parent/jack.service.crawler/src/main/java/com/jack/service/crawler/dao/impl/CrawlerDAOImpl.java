package com.jack.service.crawler.dao.impl;

import java.util.Map;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import com.jack.service.common.jdbc.BaseJdbcTemplate;
import com.jack.service.common.sqlconfig.SqlConfig;
import com.jack.service.crawler.dao.CrawlerDAO;
import com.jack.service.crawler.model.CrawlerSiteInfo;

/**
 * 
 * @ClassName: CrawlerDAOImpl
 * @Description:
 * @author lksoulman
 * @date 2018-06-15 16:37:52
 */
@Repository
public class CrawlerDAOImpl implements CrawlerDAO {

    @Autowired
    private BaseJdbcTemplate baseJdbcTemplate;

    @Autowired
    @Qualifier("sql_crawler")
    private SqlConfig sqlConfig;

    @Override
    public CrawlerSiteInfo getCrawlerSiteInfoById(int id) {
        String sql = sqlConfig.getSql("getCrawlerSiteInfoById");
        if (StringUtils.isNotEmpty(sql)) {
            Map<String, Object> map = baseJdbcTemplate.queryForMap(sql, id);
            if (map != null) {
                CrawlerSiteInfo crawlerSiteInfo = new CrawlerSiteInfo();
                crawlerSiteInfo.setId(MapUtils.getIntValue(map, "ID"));
                crawlerSiteInfo.setUrl(MapUtils.getString(map, "URL"));
                crawlerSiteInfo.setParams(MapUtils.getString(map, "PARAMS"));
                crawlerSiteInfo.setHeaders(MapUtils.getString(map, "HEADERS"));
                crawlerSiteInfo.setPageName(MapUtils.getString(map, "PAGE_NAME"));
                crawlerSiteInfo.setRequestType(MapUtils.getIntValue(map, "REQUEST_TYPE"));
                crawlerSiteInfo.setProxy(MapUtils.getIntValue(map, "PROXY"));
                crawlerSiteInfo.setCookie(MapUtils.getString(map, "COOKIE"));
                crawlerSiteInfo.setCron(MapUtils.getString(map, "CRON"));
                crawlerSiteInfo.setGrabRule(MapUtils.getString(map, "GRAB_RULE"));
                crawlerSiteInfo.setMediaId(MapUtils.getIntValue(map, "MEDIA_ID"));

                return crawlerSiteInfo;
            }
        }
        return null;
    }
}
