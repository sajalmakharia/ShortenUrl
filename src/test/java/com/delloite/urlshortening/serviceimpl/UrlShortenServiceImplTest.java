package com.delloite.urlshortening.serviceimpl;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import com.deloitte.urlshortening.model.Url;
import com.deloitte.urlshortening.repository.UrlRepository;
import com.deloitte.urlshortening.service.impl.UrlShortenServiceImpl;
import com.deloitte.urlshortening.util.UrlConversion;
import com.deloitte.urlshortening.util.Validator;

@RunWith(SpringRunner.class)
public class UrlShortenServiceImplTest {
	
	@Mock
	Validator mockValidator;
	
	@Mock
	UrlRepository mockUrlRepository;
	
	@Mock
	UrlConversion mockUrlConversion;
	
	@InjectMocks
	UrlShortenServiceImpl mockUrlShortenServiceImpl;
	
	@Test
	public void testShortenUrlValue() {
		String requestUrl="https://www.google.com";
		Url url = new Url();
		url.setKey(1);
		url.setLongUrl(requestUrl);
		when(mockValidator.validateUrl(any())).thenReturn(true);
		when(mockUrlRepository.save(any(Url.class))).thenReturn(url);
		when(mockUrlConversion.generateUrlFromId(url.getKey())).thenReturn("a");
		
		assertEquals("a",mockUrlShortenServiceImpl.shortenUrl(requestUrl));
	}
	
	@Test
	public void testShortenUrlNull() {
		when(mockValidator.validateUrl(any())).thenReturn(false);
		assertEquals(null,mockUrlShortenServiceImpl.shortenUrl("abc"));
	}
	
	@Test
	public void testGetOriginalUrlSuccess() {
		when(mockUrlConversion.getIdFromShortUrl("a")).thenReturn(0L);
		String longUrl="http://www.google.com";
		Url url = new Url();
		url.setLongUrl(longUrl);
		url.setKey(0);
		when(mockUrlRepository.findById(0L)).thenReturn(Optional.of(url));
		assertEquals(longUrl,mockUrlShortenServiceImpl.getOriginalUrl("a"));
	}
	
	@Test(expected=EntityNotFoundException.class)
	public void testGetOriginalUrlException() {
		
	}

}
