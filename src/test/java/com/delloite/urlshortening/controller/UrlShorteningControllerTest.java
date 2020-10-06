package com.delloite.urlshortening.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import javax.persistence.EntityNotFoundException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.deloitte.urlshortening.controller.UrlShortenController;
import com.deloitte.urlshortening.dto.UrlRequest;
import com.deloitte.urlshortening.service.UrlShortenService;

@RunWith(SpringRunner.class)
@ContextConfiguration
public class UrlShorteningControllerTest {

	@Mock
	UrlShortenService mockUrlShortenService;
	
	@InjectMocks
	UrlShortenController mockUrlShortenController;
	
	/**
	 * Positive test for create url Api
	 */
	@Test
	public void testCreateShortUrlSuccess() {
		UrlRequest url = new UrlRequest();
		url.setUrl("https://this-is-abig-url.com");
		String resultUrl = "b";
		when(mockUrlShortenService.shortenUrl(any())).thenReturn(resultUrl);
		assertEquals(HttpStatus.CREATED, mockUrlShortenController.createShortUrl(url).getStatusCode());
	}
	
	/**
	 * Negative test for create url Api
	 */
	@Test
	public void testCreateShortUrlFailure() {
		UrlRequest url = new UrlRequest();
		url.setUrl(null);
		String resultUrl = null;
		when(mockUrlShortenService.shortenUrl(any())).thenReturn(resultUrl);
		assertEquals(HttpStatus.BAD_REQUEST, mockUrlShortenController.createShortUrl(url).getStatusCode());
	}
	
	/**
	 * Positive test for get original url
	 * from shortened url Api
	 */
	@Test
	public void testGetUrlAndRedirectSuccess() {
		String resultUrl = "test";
		when(mockUrlShortenService.getOriginalUrl(any())).thenReturn(resultUrl);
		assertEquals(HttpStatus.FOUND,mockUrlShortenController.getUrlAndRedirect(resultUrl).getStatusCode());
	}
	
	/**
	 * Negative test for get original url
	 * from shortened url Api
	 */
	@Test
	public void testGetUrlAndRedirectFailure() {
		when(mockUrlShortenService.getOriginalUrl(any())).thenThrow(new EntityNotFoundException());
		assertEquals(HttpStatus.BAD_REQUEST,mockUrlShortenController.getUrlAndRedirect("a").getStatusCode());
	}
}
