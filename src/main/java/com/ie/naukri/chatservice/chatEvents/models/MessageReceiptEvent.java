package com.ie.naukri.chatservice.chatEvents.models;

import javax.validation.constraints.NotNull;

public class MessageReceiptEvent {

	@NotNull
	private WebhookEvent event;
	private UserIdentity actor;
	@NotNull
	private Conversation conversation;
	@NotNull
	private MessageReceipt receipt;
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
	public Conversation getConversation() {
		return conversation;
	}
	public void setConversation(Conversation conversation) {
		this.conversation = conversation;
	}
	public MessageReceipt getReceipt() {
		return receipt;
	}
	public void setReceipt(MessageReceipt receipt) {
		this.receipt = receipt;
	}
	public WebhookConfig getConfig() {
		return config;
	}
	public void setConfig(WebhookConfig config) {
		this.config = config;
	}
	
	
}
