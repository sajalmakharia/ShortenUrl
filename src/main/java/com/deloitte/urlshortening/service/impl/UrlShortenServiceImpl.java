package com.deloitte.urlshortening.service.impl;

import java.util.logging.Logger;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deloitte.urlshortening.model.Url;
import com.deloitte.urlshortening.repository.UrlRepository;
import com.deloitte.urlshortening.service.UrlShortenService;
import com.deloitte.urlshortening.util.UrlConversion;
import com.deloitte.urlshortening.util.Validator;

@Service
public class UrlShortenServiceImpl implements UrlShortenService{
	
	private static final Logger log = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	
	@Autowired
	Validator validate;
	
	@Autowired
	UrlRepository urlRepo;
	
	@Autowired
	UrlConversion urlConversion;
	
	@Override
	public String shortenUrl(String requestUrl) {
		log.info("Inside the short url function with url");
		String finalUrl = null;
		if(validate.validateUrl(requestUrl)) {
			Url url = new Url();
			url.setLongUrl(requestUrl);
			Url savedUrl = urlRepo.save(url);
			finalUrl = urlConversion.generateUrlFromId(savedUrl.getKey());
		}
		return finalUrl;
	}

	@Override
	public String getOriginalUrl(String shortUrl) {
		long id = urlConversion.getIdFromShortUrl(shortUrl);
		Url urlValue = urlRepo.findById(id).orElseThrow(() -> new EntityNotFoundException("There is no entity with " + shortUrl));
		return urlValue.getLongUrl();
	}

}
