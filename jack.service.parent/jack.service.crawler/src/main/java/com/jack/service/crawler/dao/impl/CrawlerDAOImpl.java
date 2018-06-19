package com.jack.service.crawler.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.jack.service.common.jdbc.BaseJdbcTemplate;
import com.jack.service.common.sqlconfig.SqlConfig;
import com.jack.service.crawler.core.download.model.PageInfo;
import com.jack.service.crawler.dao.CrawlerDAO;

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
	
	/**
	 * 
	 * @Description: 
	 * @param id
	 * @return 
	 * @return PageInfo
	 * @author lksoulman
	 * @date 2018-06-19 14:20:48
	 */
	@Override
	public PageInfo getPageInfoById(int id) {
		
		return null;
	}
}
