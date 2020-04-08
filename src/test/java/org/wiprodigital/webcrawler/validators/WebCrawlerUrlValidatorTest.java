package org.wiprodigital.webcrawler.validators;

import org.junit.Test;
import org.wiprodigital.webcrawler.validators.WebCrawlerUrlValidator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class WebCrawlerUrlValidatorTest {

	@Test
	public void testUrlReturnsTrue() {
		final WebCrawlerUrlValidator webCrawlerUrlValidator = new WebCrawlerUrlValidator();
		assertTrue(webCrawlerUrlValidator.isValid("https://www.google.com"));
	}

	@Test
	public void testUrlReturnsFalse() {
		final WebCrawlerUrlValidator webCrawlerUrlValidator = new WebCrawlerUrlValidator();
		assertFalse(webCrawlerUrlValidator.isValid("test"));
	}
}