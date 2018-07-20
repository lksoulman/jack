package com.jack.service.crawler.model;

/**
 * 
 * @ClassName: CrawlerSiteInfo
 * @Description:
 * @author lksoulman
 * @date 2018-06-28 17:09:27
 */
public class CrawlerSiteInfo {

	private int id;

	private String url;

	private String params;

	private String headers;

	private String pageName;

	private int requestType;

	private int proxy;

	private String cookie;

	private String cron;

	private int mediaId;

	private String grabRule;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getParams() {
		return params;
	}

	public void setParams(String params) {
		this.params = params;
	}

	public String getHeaders() {
		return headers;
	}

	public void setHeaders(String headers) {
		this.headers = headers;
	}

	public String getPageName() {
		return pageName;
	}

	public void setPageName(String pageName) {
		this.pageName = pageName;
	}

	public int getRequestType() {
		return requestType;
	}

	public void setRequestType(int requestType) {
		this.requestType = requestType;
	}

	public int getProxy() {
		return proxy;
	}

	public void setProxy(int proxy) {
		this.proxy = proxy;
	}

	public String getCookie() {
		return cookie;
	}

	public void setCookie(String cookie) {
		this.cookie = cookie;
	}

	public String getCron() {
		return cron;
	}

	public void setCron(String cron) {
		this.cron = cron;
	}

	public int getMediaId() {
		return mediaId;
	}

	public void setMediaId(int mediaId) {
		this.mediaId = mediaId;
	}

	public String getGrabRule() {
		return grabRule;
	}

	public void setGrabRule(String grabRule) {
		this.grabRule = grabRule;
	}
}
