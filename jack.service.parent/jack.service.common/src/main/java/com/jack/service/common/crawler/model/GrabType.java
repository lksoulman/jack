package com.jack.service.common.crawler.model;

/**
 * 
 * @ClassName: GrabType
 * @Description:
 * @author lksoulman
 * @date 2018-06-27 16:18:10
 */
public enum GrabType {
	GRAB_NONE, // 不需要再抓取了
	GRAB_LINK, // 抓取 link
	GRAB_HTML, // 抓取 html
	GRAB_JSON, // 抓取 json
	GRAB_TABLE // 抓取 table
}
