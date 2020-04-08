package org.wiprodigital.webcrawler.validators;

import java.net.MalformedURLException;
import java.net.URL;

public class InternalLinkValidator {
	URL pageUrl;

	public InternalLinkValidator(URL url) {
		this.pageUrl = url;
	}

	public boolean isNotValid(String link) {
		return !this.isValid(link);
	}

	public boolean isValid(String link) {
		try {
			URL linkUrl = new URL(link);
			return linkUrl.getHost().equalsIgnoreCase(this.pageUrl.getHost());
		} catch (MalformedURLException e) {
			return false;
		}

	}

}
