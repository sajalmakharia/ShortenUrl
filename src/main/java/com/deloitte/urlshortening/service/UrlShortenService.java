package com.deloitte.urlshortening.service;

public interface UrlShortenService {
	
	public String shortenUrl(String url);
	
	public String getOriginalUrl(String shortUrl);

}
