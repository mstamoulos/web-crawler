package org.wiprodigital.webcrawler.handlers;

import org.apache.commons.lang3.StringUtils;

public class SlashHandler implements UrlHandler {

	private UrlHandler handler;

	@Override
	public void setHandler(UrlHandler handler) {
		this.handler = handler;

	}

	@Override
	public String process(String url) {

		if (!StringUtils.isEmpty(url)) {

			final int lastIndex = url.length() - 1;
			char lastChar = url.charAt(lastIndex);
			url = lastChar == '/' ? url.substring(0, lastIndex) : url;
		}
		if (this.handler != null) {
			return this.handler.process(url);
		}
		return url;

	}

}
