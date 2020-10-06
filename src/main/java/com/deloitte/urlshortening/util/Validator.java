package com.deloitte.urlshortening.util;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

import org.springframework.stereotype.Component;

@Component
public class Validator {
	
	/**
	 * Validate is the given long url is valid or not
	 * @param url the original url
	 * @return boolean true or false
	 */
	public boolean validateUrl(String url) {
		try {
			new URL(url).toURI();
			return true;
		}
		catch (URISyntaxException|MalformedURLException exception) {
			return false;
		}
	}

}
