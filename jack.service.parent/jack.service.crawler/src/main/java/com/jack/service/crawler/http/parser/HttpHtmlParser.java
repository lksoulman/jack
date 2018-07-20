package com.jack.service.crawler.http.parser;

import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.jack.service.common.crawler.model.GrabRule;
import com.jack.service.common.crawler.parse.AbstractHtmlParser;

/**
 * 
 * @ClassName: HttpHtmlParser 
 * @Description:  
 * @author lksoulman 
 * @date 2018-06-28 16:43:30
 */
public class HttpHtmlParser extends AbstractHtmlParser {

	@Override
	public Object parse(String content, GrabRule grabRule) {
		
		if (StringUtils.isEmpty(grabRule.getXpath())) {
			Map<String, ?> map = getXpath(content, grabRule.getXpath());
			if (map == null)
				return null;
			
			
			
		} else {
			
		}

		return null;
	}

	private Map<String, Object> getXpath(String content, String xpath) {
		
		return null;
	}
	
	
}
