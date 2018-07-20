package com.jack.service.common.crawler.model;

import java.util.Map;

/**
 * 
 * @ClassName: Page
 * @Description:
 * @author lksoulman
 * @date 2018-06-27 09:37:38
 */
public class PageInfo implements Cloneable {

	private int siteId;

	private String url;

	private int timeout;

	private boolean proxy;

	private int requestType;

	private DownloadType downloaderType;

	private Map<String, String> params;

	private Map<String, String> headers;

	private String charset;

	public int getSiteId() {
		return siteId;
	}

	public void setSiteId(int siteId) {
		this.siteId = siteId;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getTimeout() {
		return timeout;
	}

	public void setTimeout(int timeout) {
		this.timeout = timeout;
	}

	public boolean isProxy() {
		return proxy;
	}

	public void setProxy(boolean proxy) {
		this.proxy = proxy;
	}

	public int getRequestType() {
		return requestType;
	}

	public void setRequestType(int requestType) {
		this.requestType = requestType;
	}

	public DownloadType getDownloaderType() {
		return downloaderType;
	}

	public void setDownloaderType(DownloadType downloaderType) {
		this.downloaderType = downloaderType;
	}

	public Map<String, String> getParams() {
		return params;
	}

	public void setParams(Map<String, String> params) {
		this.params = params;
	}

	public Map<String, String> getHeaders() {
		return headers;
	}

	public void setHeaders(Map<String, String> headers) {
		this.headers = headers;
	}

	public String getCharset() {
		return charset;
	}

	public void setCharset(String charset) {
		this.charset = charset;
	}

	@Override
	public Object clone() {
		PageInfo pageInfo = null;
		try {
			pageInfo = (PageInfo) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return pageInfo;
	}
}
