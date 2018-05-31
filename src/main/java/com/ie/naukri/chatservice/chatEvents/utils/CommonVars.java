package com.ie.naukri.chatservice.chatEvents.utils;

public class CommonVars {

	public static final String LAYER_WEBHOOK_EVENT_TYPE = "layer-webhook-event-type";
	public static final String LAYER_WEBHOOK_SIGNATURE = "layer-webhook-signature";
	public static final String LAYER_WEBHOOK_REQUEST_ID = "layer-webhook-request-id";
	public static final String LAYER_WEBHOOK_ID = "layer-webhook-id";
	public static final String LAYER_USER_AGENT = "user-agent";
	public static final String LAYER_USER_AGENT_VALUE = "layer-webhooks/3.0";
	public static final String LAYER_CONTENT_TYPE = "content-type";
	//TODO Ask for topic names
	public static final String KAFKA_MSG_SEND_TOPIC = "msg_sent_node";
	public static final String KAFKA_MSG_RECEIPT_TOPIC = "msg_received_node";
	
	private static final ThreadLocal<String> LAYER_EVENT_TYPE = new ThreadLocal<>();
	private static final ThreadLocal<String> LAYER_REQUEST_ID = new ThreadLocal<>();
	
	public static void setLayerEventType(String event) {
		 LAYER_EVENT_TYPE.set(event);
	}
	public static void setLayerRequestId(String webhookRequestId) {
		 LAYER_REQUEST_ID.set(webhookRequestId);
	}
	
	public static String getLayerEventType() {
		return LAYER_EVENT_TYPE.get();
	}
	public static String getLayerRequestId() {
		return LAYER_REQUEST_ID.get();
	}
	
	public static void set(String event, String webhookRequestId) {
		LAYER_EVENT_TYPE.set(event);
		LAYER_REQUEST_ID.set(webhookRequestId);
	}

	public static void clear() {
		LAYER_EVENT_TYPE.remove();
		LAYER_REQUEST_ID.remove();
		
	}
}
