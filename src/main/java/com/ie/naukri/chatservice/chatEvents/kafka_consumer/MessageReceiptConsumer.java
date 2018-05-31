package com.ie.naukri.chatservice.chatEvents.kafka_consumer;

import javax.inject.Inject;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ie.naukri.chatservice.chatEvents.cache.MessageReceiptCache;
import com.ie.naukri.chatservice.chatEvents.models.MessageReceiptEvent;
import com.ie.naukri.messaging.listeners.KeyedMessageStreamListener;
import com.ie.naukri.messaging.models.StreamMessage;

public class MessageReceiptConsumer extends KeyedMessageStreamListener{
	
	@Inject
	private MessageReceiptCache messageReceiptCache;

	@Override
	protected void processKeyedMessage(String key, StreamMessage streamMessage) throws Exception {
		// TODO Auto-generated method stub
		final ObjectMapper mapper = new ObjectMapper();
		MessageReceiptEvent messageReceiptEvent = mapper.convertValue(streamMessage.getPayload(), MessageReceiptEvent.class);
		//TODO: Ask whether the inject is possible here...
		messageReceiptCache.setMessageReceipt(messageReceiptEvent);
	}

}
