package com.jack.service.common.sqlconfig;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.AbstractSingleBeanDefinitionParser;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.jack.service.common.exception.SqlConfigException;

/**
 * 
 * @ClassName: SqlBeanDefinitionParser
 * @Description:
 * @author lksoulman
 * @date 2018-06-08 10:57:06
 */
public class SqlBeanDefinitionParser extends AbstractSingleBeanDefinitionParser {

	@Override
	protected Class<?> getBeanClass(Element element) {
		return SqlConfig.class;
	}

	@Override
	protected void doParse(Element element, BeanDefinitionBuilder builder) {
		// 获取xml配置子元素
		NodeList nodelist = element.getChildNodes();
		Map<String, String> sqlMap = new HashMap<String, String>();
		f1: for (int i = 0; i < nodelist.getLength(); i++) {
			Node node = nodelist.item(i);
			if (node instanceof Element) {
				Element nodeElement = ((Element) node);
				String nodeName = nodeElement.getAttribute("sqlname");
				NodeList sqlList = nodeElement.getChildNodes();
				for (int j = 0; j < sqlList.getLength(); j++) {
					Node sqlNode = nodelist.item(i);
					if (sqlNode instanceof Element) {
						Element sqlElement = ((Element) sqlNode);
						String sql = sqlElement.getTextContent();
						if (sqlMap.containsKey(nodeName)) {
							// log.error(nodeName + ":sql名称已存在", sql);
							throw new SqlConfigException(nodeName + ":sql名称已存在");
						}
						sqlMap.put(nodeName, StringUtils.trim(sql));
						continue f1;
					}
				}
			}
		}
		builder.addPropertyValue("sqlMap", sqlMap);
	}
}
