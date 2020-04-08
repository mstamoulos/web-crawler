package org.wiprodigital.webcrawler.handlers;

import org.apache.commons.lang3.StringUtils;

public class HashHandler implements UrlHandler {

	private UrlHandler handler;

	@Override
	public void setHandler(UrlHandler handler) {
		this.handler = handler;

	}

	@Override
	public String process(String url) {
		if (!StringUtils.isEmpty(url)) {
			int index = url.indexOf('#');
			url = index == -1 ? url : url.substring(0, index);
		}
		if (this.handler != null) {
			return this.handler.process(url);
		}
		return url;

	}

}
