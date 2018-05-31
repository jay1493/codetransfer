package com.ie.naukri.chatservice.chatEvents.kafka_consumer;

import javax.inject.Inject;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ie.naukri.chatservice.chatEvents.cache.MessageReceiptCache;
import com.ie.naukri.chatservice.chatEvents.models.MessageCreateEvent;
import com.ie.naukri.messaging.listeners.KeyedMessageStreamListener;
import com.ie.naukri.messaging.models.StreamMessage;
import com.ie.naukri.rest.client.delegates.RESTServiceDelegate;

public class CreatedMessageConsumer extends KeyedMessageStreamListener {
	//Will be consumed in 30mins.
	
	@Inject
	private MessageReceiptCache messageReceiptCache;
	
	@Inject
	private RESTServiceDelegate restServiceDelegate;

	@Override
	protected void processKeyedMessage(String key, StreamMessage streamMessage) throws Exception {
		// TODO Auto-generated method stub
		System.out.println(streamMessage.getPayload());
		/*final ObjectMapper mapper = new ObjectMapper();
		MessageCreateEvent messageCreateEvent = mapper.convertValue(streamMessage.getPayload(), MessageCreateEvent.class);
		if(messageCreateEvent!=null) {
		boolean needToSendMail = messageReceiptCache.getMessageReceipt(messageCreateEvent.getMessage().getConversation().getConversationId(), messageCreateEvent.getMessage().getPosition());
		if(needToSendMail) {
			//TODO Hit Notification service.
		}
	 }*/
	}

}
