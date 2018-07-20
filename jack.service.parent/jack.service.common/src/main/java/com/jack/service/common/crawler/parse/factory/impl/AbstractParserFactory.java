package com.jack.service.common.crawler.parse.factory.impl;

import com.jack.service.common.crawler.model.GrabType;
import com.jack.service.common.crawler.parse.Parser;
import com.jack.service.common.crawler.parse.factory.ParserFactory;

/**
 * 
 * @ClassName: AbstractParserFactory
 * @Description:
 * @author lksoulman
 * @date 2018-06-27 08:59:15
 */
public abstract class AbstractParserFactory implements ParserFactory {

	@Override
	public synchronized Parser getParser(GrabType grabType) {
		Parser parser = null;
		switch (grabType) {
		case GRAB_HTML:
			parser = getHtmlParser();
			break;
		case GRAB_LINK:
			parser = getLinkParser();
			break;
		case GRAB_JSON:
			parser = getJsonParser();
			break;
		case GRAB_TABLE:
			parser = getTableParser();
			break;
		default:
			break;
		}

		return parser;
	}

	protected abstract Parser getHtmlParser();

	protected abstract Parser getLinkParser();

	protected abstract Parser getJsonParser();

	protected abstract Parser getTableParser();
}
