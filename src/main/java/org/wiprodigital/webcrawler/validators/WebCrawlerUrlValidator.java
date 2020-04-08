package org.wiprodigital.webcrawler.validators;

import org.apache.commons.validator.routines.UrlValidator;

public class WebCrawlerUrlValidator {
	private final UrlValidator urlValidator = new UrlValidator();

	public boolean isValid(String url) {
		return urlValidator.isValid(url);

	}

}
