# web-crawler

## Description

Simple Java Web Crawler. You can provide an entry point at WebCrawlerApplication.java of a domain and the application will start crawling into the domain displaying  Internal Links, Enternal links and resources for each of the page.

## Compile the app 
mvn clean complile


## Build the app 
mvn clean install


## To run the app 

mvn exec:java -Dexec.mainClass=org.wiprodigital.webcrawler.main.WebCrawlerApplication


## Future enhancements & features
* Expand Coverage of unit tests
* Create a spring boot version of the app
* Create either multi threaded or microserviced 
* Create a UI to show the results from the API