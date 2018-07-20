package com.jack.service.common.crawler.parse;


import com.jack.service.common.crawler.model.GrabRule;

/**
 * 
 * @ClassName: Parser
 * @Description:
 * @author lksoulman
 * @date 2018-06-27 08:53:55
 */
public interface Parser {

	/**
	 * 
	 * @Description:
	 * @param map
	 * @return
	 * @return Object
	 * @author lksoulman
	 * @date 2018-06-27 08:53:59
	 */
	public abstract Object parse(String content, GrabRule grabRule);
}
