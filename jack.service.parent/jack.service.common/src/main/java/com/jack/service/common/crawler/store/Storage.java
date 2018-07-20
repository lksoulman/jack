package com.jack.service.common.crawler.store;

import java.util.Map;

import com.jack.service.common.crawler.model.PageInfo;

/**
 * 
 * @ClassName: Storage 
 * @Description:  
 * @author lksoulman 
 * @date 2018-06-27 09:25:45
 */
public abstract class Storage {

	/**
	 * 
	 * @Description: 
	 * @param map 
	 * @return void
	 * @author lksoulman
	 * @date 2018-06-27 09:27:03
	 */
	public abstract void checkStore(String resource, PageInfo pageInfo);
}
