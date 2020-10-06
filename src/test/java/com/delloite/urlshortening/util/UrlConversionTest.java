package com.delloite.urlshortening.util;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit4.SpringRunner;

import com.deloitte.urlshortening.util.UrlConversion;

@RunWith(SpringRunner.class)
public class UrlConversionTest {

	@InjectMocks
	UrlConversion mockUrlConversion;
	
	@Test
	public void testGenerateUrlFromIdLessthan62() {
		assertEquals("8",mockUrlConversion.generateUrlFromId(60));
	}
	
	@Test
	public void testGenerateUrlFromIdMorethan62() {
		assertEquals("XAG",mockUrlConversion.generateUrlFromId(190000));
	}
	
	@Test
    public void testGetIdFromShortUrl() {
        assertEquals(1, mockUrlConversion.getIdFromShortUrl("b"));
    }

}
