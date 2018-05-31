package com.ie.naukri.chatservice.chatEvents.models;

import javax.validation.constraints.NotNull;

public class MessageReceipt {

	private String type;
	@NotNull
	private ReceiptPositions positions;
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public ReceiptPositions getPositions() {
		return positions;
	}
	public void setPositions(ReceiptPositions positions) {
		this.positions = positions;
	}
	
	
}
