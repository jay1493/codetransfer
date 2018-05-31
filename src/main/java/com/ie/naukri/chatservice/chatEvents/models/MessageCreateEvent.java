package com.ie.naukri.chatservice.chatEvents.models;

import javax.validation.constraints.NotNull;

public class MessageCreateEvent {

	@NotNull
	private WebhookEvent event;
	private UserIdentity actor;
	@NotNull
	private Message message;
	private WebhookConfig config;
	public WebhookEvent getEvent() {
		return event;
	}
	public void setEvent(WebhookEvent event) {
		this.event = event;
	}
	public UserIdentity getActor() {
		return actor;
	}
	public void setActor(UserIdentity actor) {
		this.actor = actor;
	}
	public Message getMessage() {
		return message;
	}
	public void setMessage(Message message) {
		this.message = message;
	}
	public WebhookConfig getConfig() {
		return config;
	}
	public void setConfig(WebhookConfig config) {
		this.config = config;
	}
	
	
}
