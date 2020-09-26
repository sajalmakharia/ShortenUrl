package com.deloitte.urlshortening.util;

import org.springframework.stereotype.Component;


@Component
public class UrlConversion {
	
	private static final String VALUES = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
	private int mapLength = VALUES.length();
	
	public String generateUrlFromId(long id) {
		StringBuilder shortUrl = new StringBuilder();

        if(id == 0) {
            return String.valueOf(VALUES.charAt(0));
        }

        while (id > 0) {
        	shortUrl.append(VALUES.charAt((int) (id%mapLength)));
            id = id / mapLength;
        }

        return shortUrl.reverse().toString();
	}
	
	public long getIdFromShortUrl(String url) {

		int id =0;
		for ( int i = 0; i < url.length(); i++ ) {
            id = id * mapLength + VALUES.indexOf(url.charAt(i));
		}
		return id;
	}
	
	

}
