package com.jack.service.crawler.http.downloader;

import java.io.IOException;
import java.util.Map;

import org.apache.commons.collections4.MapUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.Connection.Method;
import org.jsoup.Connection.Response;

import com.jack.service.common.crawler.download.HtmlStaticDownloader;
import com.jack.service.common.crawler.model.PageInfo;

/**
 * 
 * @ClassName: JsoupDownloader 
 * @Description:  
 * @author lksoulman 
 * @date 2018-06-28 18:26:07
 */
public class JsoupDownloader extends HtmlStaticDownloader {

	@Override
	public String download(PageInfo pageInfo) {
		Connection connection = getConnection(pageInfo);
		if (pageInfo.getRequestType() == 0) {
			connection.method(Method.GET);
		} else {
			connection.method(Method.POST);
		}

		Map<String, String> headers = pageInfo.getHeaders();
		if (!MapUtils.isEmpty(pageInfo.getHeaders())) {
			connection.headers(headers);
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
			// proxy.call(connection);
		}

		Response response;
		try {
			response = connection.execute();
			String charset = pageInfo.getCharset();
			if (!StringUtils.isEmpty(response.charset())) {
				charset = response.charset();
			}

			return IOUtils.toString(response.bodyAsBytes(), charset);

		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}

	/**
	 * 
	 * @Description: 
	 * @param pageInfo
	 * @return Connection
	 * @author lksoulman
	 * @date 2018-06-28 18:25:57
	 */
	private Connection getConnection(PageInfo pageInfo) {
		Connection connection = Jsoup.connect(pageInfo.getUrl()).header("Accept-Encoding", "")
				.header("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:48.0) Gecko/20100101 Firefox/48.0")
				.ignoreContentType(true).timeout(pageInfo.getTimeout()).referrer(pageInfo.getUrl()).maxBodySize(0);
		return connection;
	}
}
