package org.wiprodigital.webcrawler.crawlers;

import org.wiprodigital.webcrawler.model.WebPage;

public interface Crawler {
	void crawl(final WebPage webPage);

}
