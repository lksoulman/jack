package com.jack.service.common.crawler.parse.factory;

import com.jack.service.common.crawler.model.GrabType;
import com.jack.service.common.crawler.parse.Parser;

/**
 * 
 * @ClassName: ParserFactory 
 * @Description:  
 * @author lksoulman 
 * @date 2018-06-27 08:43:04
 */
public interface ParserFactory {

	/**
	 * 
	 * @Description: 
	 * @param parserType
	 * @return Parser
	 * @author lksoulman
	 * @date 2018-06-27 08:44:47
	 */
	Parser getParser(GrabType grabType);
}
