package com.jack.service.common.crawler.model;

/**
 * 
 * @ClassName: ParseInfo
 * @Description:
 * @author lksoulman
 * @date 2018-06-27 10:00:39
 */
public class GrabRule implements Cloneable {

	private GrabType grabType;

	private String xpath;

	public GrabType getGrabType() {
		return grabType;
	}

	public void setGrabType(GrabType grabType) {
		this.grabType = grabType;
	}

	public String getXpath() {
		return xpath;
	}

	public void setXpath(String xpath) {
		this.xpath = xpath;
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
