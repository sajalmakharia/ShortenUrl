package com.delloite.urlshortening.util;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit4.SpringRunner;

import com.deloitte.urlshortening.util.Validator;

@RunWith(SpringRunner.class)
public class ValidatorTest {
	
	@InjectMocks
	Validator mockValidator;
	
	@Test
	public void testValidateUrlTrue() {
		String url="https://www.google.com";
		assertTrue(mockValidator.validateUrl(url));
		
	}
	
	@Test
	public void testValidateUrlFalse() {
		String url="abcd";
		assertFalse(mockValidator.validateUrl(url));
	}

}
