package com.deloitte.urlshortening.service;

public interface UrlShortenService {
	
	/**
	 * Function to get the shortened Api
	 * @param url the original url
	 * @return the shortened url
	 */
	public String shortenUrl(String url);
	
	/**
	 *
	 * Function to get the original Api
	 * @param shortUrl the short url
	 * @return the original url
	 */
	public String getOriginalUrl(String shortUrl);

}
