package org.wiprodigital.webcrawler.services;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.wiprodigital.webcrawler.handlers.HashHandler;
import org.wiprodigital.webcrawler.handlers.SlashHandler;
import org.wiprodigital.webcrawler.handlers.UrlHandler;
import org.wiprodigital.webcrawler.model.WebPage;
import org.wiprodigital.webcrawler.validators.InternalLinkValidator;

public class DocumentLinkExtractor {
	UrlHandler urlHandler;
	InternalLinkValidator internalLinkValidator;
	WebPage page;

	public DocumentLinkExtractor(WebPage page) {

		this.page = page;
		urlHandler = new HashHandler();
		urlHandler.setHandler(new SlashHandler());
		internalLinkValidator = new InternalLinkValidator(page.getUrl());

		Document document;
		try {
			document = Jsoup.connect(page.getPageUrl()).get();
			page.setInternalLinks(this.getInternalLinks(document));
			page.setExternalLinks(this.getExternalLinks(document));
			page.setStaticContent(this.getStaticContent(document));
		} catch (IOException e) {
			page.setErrorString(e.getMessage());
		}

	}

	public List<String> getInternalLinks(Document document) {

		return document.select("a[href]").stream().map(e -> e.attr("abs:href")).filter(internalLinkValidator::isValid)
				.map(urlHandler::process).distinct().collect(Collectors.toList());

	}

	private List<String> getExternalLinks(final Document document) {
		return document.select("a[href]").stream().map(e -> e.attr("abs:href"))
				.filter(internalLinkValidator::isNotValid).map(urlHandler::process).distinct()
				.collect(Collectors.toList());
	}

	private List<String> getStaticContent(final Document document) {
		return document.select("[src]").stream().map(e -> e.attr("abs:src")).distinct().collect(Collectors.toList());
	}

}
