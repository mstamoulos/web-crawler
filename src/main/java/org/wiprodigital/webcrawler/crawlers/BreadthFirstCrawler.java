package org.wiprodigital.webcrawler.crawlers;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.function.Consumer;

import org.wiprodigital.webcrawler.consumer.ResultPrinter;
import org.wiprodigital.webcrawler.model.WebPage;
import org.wiprodigital.webcrawler.services.DocumentLinkExtractor;

public class BreadthFirstCrawler implements Crawler {
	private final Consumer<WebPage> resultConsumer = new ResultPrinter();
	@Override
	public void crawl(final WebPage webPage) {
		final LinkedList<WebPage> fetchQueue = new LinkedList<>();
		fetchQueue.add(webPage);
		recruisiveRetrieve(fetchQueue);
	}

	private void recruisiveRetrieve(LinkedList<WebPage> fetchQueue) {
		final Set<String> completed = new HashSet<>();
		while (!fetchQueue.isEmpty()) {
			WebPage webPage = fetchQueue.poll();
			new DocumentLinkExtractor(webPage);
			if (!completed.contains(webPage.getUrl().toString())) {

				resultConsumer.accept(webPage);
				completed.add(webPage.getUrl().toString());
				if (webPage.getInternalLinks() != null) {
					for (final String newUrl : webPage.getInternalLinks()) {

						if (!completed.contains(newUrl)) {
							fetchQueue.add(WebPage.builder().pageUrl(newUrl).build());
						}

					}
				}

			}
		}
	}

}
