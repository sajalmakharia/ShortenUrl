package com.deloitte.urlshortening.controller;

import java.net.URI;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deloitte.urlshortening.dto.UrlRequest;
import com.deloitte.urlshortening.dto.UrlResponse;
import com.deloitte.urlshortening.service.UrlShortenService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/v1")
public class UrlShortenController {
	
	@Autowired
	UrlShortenService urlShortenService;
	
	@ApiOperation(value = "Shorten url")
	@PostMapping("/shorten-url")
	public ResponseEntity<UrlResponse> createShortUrl(@RequestBody UrlRequest url){
		UrlResponse response = new UrlResponse();
		String resultUrl = urlShortenService.shortenUrl(url.getUrl());
		if(resultUrl != null) {
			response.setResult(resultUrl);
			return new ResponseEntity<>(response, HttpStatus.CREATED);
		}
		response.setResult("Invalid Url");
		return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
	}
	
	@ApiOperation(value="Open the original Url")
	@GetMapping("{url}")
	public ResponseEntity<?> getUrlAndRedirect(@PathVariable String url){
		String value=null;
		try {
		 value = urlShortenService.getOriginalUrl(url);
		 return ResponseEntity.status(HttpStatus.FOUND).location(URI.create(value)).build();
		} catch(EntityNotFoundException e) {
			value = "This is an invalid url";
		}
		return new ResponseEntity<>(value,HttpStatus.BAD_REQUEST);
	}

}
