package org.wiprodigital.webcrawler.model;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import lombok.Builder;
import lombok.Data;
import java.util.logging.Logger;

@Builder
@Data
public class WebPage {

	private String pageUrl;
	private String errorString;
	private List<String> internalLinks;
	private List<String> externalLinks;
	private List<String> staticContent;
	private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

	public URL getUrl() {
		try {
			return new URL(pageUrl);
		} catch (MalformedURLException e) {
			LOGGER.info(e.getMessage());
		}
		return null;
	}

}
