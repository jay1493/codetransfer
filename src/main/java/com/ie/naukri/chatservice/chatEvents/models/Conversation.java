package com.ie.naukri.chatservice.chatEvents.models;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.Expose;

public class Conversation {

	@JsonProperty("id")
	@Expose
	@NotNull
	private String conversationId;
	@JsonProperty("url")
	@Expose
	private String conversationUrl;
	
	public String getConversationId() {
		return conversationId;
	}
	public void setConversationId(String conversationId) {
		this.conversationId = conversationId;
	}
	public String getConversationUrl() {
		return conversationUrl;
	}
	public void setConversationUrl(String conversationUrl) {
		this.conversationUrl = conversationUrl;
	}
	
	
}
