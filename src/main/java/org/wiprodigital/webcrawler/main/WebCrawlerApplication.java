package org.wiprodigital.webcrawler.main;

import org.wiprodigital.webcrawler.crawlers.BreadthFirstCrawler;
import org.wiprodigital.webcrawler.crawlers.Crawler;
import org.wiprodigital.webcrawler.model.WebPage;

public class WebCrawlerApplication {

	private final Crawler crawler = new BreadthFirstCrawler();

	public static void main(final String[] args) {

		WebCrawlerApplication webCrawlerApplication = new WebCrawlerApplication();
		webCrawlerApplication.test();

	}

	public void test() {
		WebPage wb = WebPage.builder().pageUrl("https://wiprodigital.com/").build();
		crawler.crawl(wb);
	}

}
