package com.jack.service.crawler.core.download.model;

import java.nio.charset.Charset;
import java.util.Map;

import lombok.Data;

/**
 * 
 * @ClassName: Downloadrule
 * @Description:
 * @author lksoulman
 * @date 2018-06-15 13:56:40
 */
@Data
public class PageInfo {

	// 下载信息id
	private int id;
	// 媒体id
	private int mediaId;
	// 页面类型
	private int pageType;

	private int timeout;

	private boolean proxy;
	
	private int requestType;

	private String url;

	private Map<String, String> params;

	private Map<String, String> headers;
	
	private String charset;

	private ParseRule parseRule;
}
