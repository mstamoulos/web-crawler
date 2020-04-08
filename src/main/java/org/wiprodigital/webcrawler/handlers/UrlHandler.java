package org.wiprodigital.webcrawler.handlers;

public interface UrlHandler {

	public void setHandler(UrlHandler handler);

	public String process(String url);

}
