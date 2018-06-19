package com.jack.service.crawler.core.download.impl;

import java.io.IOException;
import java.util.Map;

import org.apache.commons.collections4.MapUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.Connection;
import org.jsoup.Connection.Method;
import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;

import com.jack.service.crawler.core.download.Download;
import com.jack.service.crawler.core.download.model.PageInfo;
import com.jack.service.crawler.core.proxy.Proxy;

/**
 * 
 * @ClassName: JsoupCrawler
 * @Description:
 * @author lksoulman
 * @date 2018-06-15 13:41:13
 */
public class JsoupDownloadImpl implements Download {

	private static final String USER_AGENT = "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:48.0) Gecko/20100101 Firefox/48.0";

	private static int timeout = 50000;

	@Override
	public String getHtmlFromUrl(PageInfo pageInfo, Proxy proxy) throws IOException {
		Connection connection = Jsoup.connect(pageInfo.getUrl()).header("Accept-Encoding", "")
				.header("User-Agent", USER_AGENT).ignoreContentType(true).timeout(50000).referrer(pageInfo.getUrl())
				.maxBodySize(0);

		switch (pageInfo.getRequestType()) {
		case 0:
			connection.method(Method.GET);
			break;
		default:
			connection.method(Method.POST);
			break;
		}

		Map<String, String> headers = pageInfo.getHeaders();
		if (!MapUtils.isEmpty(pageInfo.getHeaders())) {
			connection.headers(pageInfo.getHeaders());
		}
		Map<String, String> params = pageInfo.getParams();
		if (!MapUtils.isEmpty(pageInfo.getParams())) {
			if (params.containsKey("RequestBody")) {
				connection.requestBody(MapUtils.getString(params, "RequestBody"));
			} else {
				connection.data(params);
			}
		}

		if (pageInfo.isProxy()) {
			proxy.call(connection);
		}

		Response response = connection.execute();

		String charset = pageInfo.getCharset();
		if (!StringUtils.isEmpty(response.charset())) {
			charset = response.charset();
		}

		return IOUtils.toString(response.bodyAsBytes(), charset);
	}
}
