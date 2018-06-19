package com.jack.service.common.sqlconfig;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

/**
 * 
 * @ClassName: SqlNamespaceHandler 
 * @Description:  
 * @author lksoulman 
 * @date 2018-06-08 11:29:25
 */
public class SqlNamespaceHandler extends NamespaceHandlerSupport {

	@Override
	public void init() {
		registerBeanDefinitionParser("sqlconfig", new SqlBeanDefinitionParser());
	}
}
