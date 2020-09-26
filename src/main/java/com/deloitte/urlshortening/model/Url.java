package com.deloitte.urlshortening.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Url {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long key;
	private String longUrl;

	public long getKey() {
		return key;
	}
	public void setKey(long key) {
		this.key = key;
	}
	public String getLongUrl() {
		return longUrl;
	}
	public void setLongUrl(String longUrl) {
		this.longUrl = longUrl;
	}

}
