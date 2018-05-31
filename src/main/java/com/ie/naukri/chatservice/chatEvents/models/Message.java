package com.ie.naukri.chatservice.chatEvents.models;

import java.util.List;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Message {
 
	private String msgId;
	private String msgUrl;
	private Conversation conversation;
	private List<MessageParts> parts;
	private String sent_at;
	@NotNull
	private UserIdentity sender;
	@NotNull
	private long position;
	private String updated_at;
	public String getMsgId() {
		return msgId;
	}
	public void setMsgId(String msgId) {
		this.msgId = msgId;
	}
	public String getMsgUrl() {
		return msgUrl;
	}
	public void setMsgUrl(String msgUrl) {
		this.msgUrl = msgUrl;
	}
	public Conversation getConversation() {
		return conversation;
	}
	public void setConversation(Conversation conversation) {
		this.conversation = conversation;
	}
	
	public List<MessageParts> getParts() {
		return parts;
	}
	public void setParts(List<MessageParts> parts) {
		this.parts = parts;
	}
	
	public String getSent_at() {
		return sent_at;
	}
	public void setSent_at(String sent_at) {
		this.sent_at = sent_at;
	}
	public UserIdentity getSender() {
		return sender;
	}
	public void setSender(UserIdentity sender) {
		this.sender = sender;
	}
	public long getPosition() {
		return position;
	}
	public void setPosition(long position) {
		this.position = position;
	}
	public String getUpdated_at() {
		return updated_at;
	}
	public void setUpdated_at(String updated_at) {
		this.updated_at = updated_at;
	}
	
	
}
