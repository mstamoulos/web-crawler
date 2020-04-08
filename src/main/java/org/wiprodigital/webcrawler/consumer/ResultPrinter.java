
package org.wiprodigital.webcrawler.consumer;

import java.util.List;
import java.util.function.Consumer;

import org.wiprodigital.webcrawler.model.WebPage;

public class ResultPrinter implements Consumer<WebPage> {

	@Override
	public void accept(WebPage webPage) {
		System.out.println("-----------------------------------------------");
		System.out.println("Page URL: " + webPage.getUrl());

		if (webPage.getErrorString() == null) {
			System.out.println("Internal Links");
			printList(webPage.getInternalLinks());
			System.out.println("External Links");
			printList(webPage.getExternalLinks());
			System.out.println("Static Content");
			printList(webPage.getStaticContent());
		} else {
			System.out.println("Error" + webPage.getErrorString());
		}

	}

	private void printList(List<String> links) {
		for (String link : links) {
			System.out.println("--" + link);

		}

	}

}
