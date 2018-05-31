package com.ie.naukri.chatservice.chatEvents.models;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Content {
	
	private String id;
	
	private String download_url;
	
	private String expiration;
	
	private String refresh_url;
	
	private long size;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	

	public String getDownload_url() {
		return download_url;
	}

	public void setDownload_url(String download_url) {
		this.download_url = download_url;
	}

	public String getExpiration() {
		return expiration;
	}

	public void setExpiration(String expiration) {
		this.expiration = expiration;
	}

	public String getRefresh_url() {
		return refresh_url;
	}

	public void setRefresh_url(String refresh_url) {
		this.refresh_url = refresh_url;
	}

	public long getSize() {
		return size;
	}

	public void setSize(long size) {
		this.size = size;
	}

}
