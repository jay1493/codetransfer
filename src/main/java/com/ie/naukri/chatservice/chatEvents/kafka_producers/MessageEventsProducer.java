package com.ie.naukri.chatservice.chatEvents.kafka_producers;

import static org.hamcrest.CoreMatchers.instanceOf;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.ie.naukri.chatservice.chatEvents.models.MessageCreateEvent;
import com.ie.naukri.chatservice.chatEvents.models.MessageReceiptEvent;
import com.ie.naukri.chatservice.chatEvents.utils.CommonVars;
import com.ie.naukri.messaging.models.AppClientDetails;
import com.ie.naukri.messaging.models.StreamMessage;
import com.ie.naukri.messaging.services.MessagingTemplate;
import com.ie.naukri.messaging.services.MessagingTemplateService;

@Service
public class MessageEventsProducer {
	
	@Inject
	private MessagingTemplateService messagingTemplateService;
	
	private Logger logger = LoggerFactory.getLogger(MessageEventsProducer.class);
	
	public <T> void pushMessageToKafka(String topic, T payload) {
		 final HashMap<String, Object> headers = new HashMap<String, Object>();
		 headers.put(AppClientDetails.APP_ID_HEADER_NAME, 1);
		 headers. put(AppClientDetails.REQUEST_ID_HEADER_NAME, "2");
		 headers.put(AppClientDetails.SYSTEM_ID_HEADER_NAME, "3");
	           /* {
	                put(AppClientDetails.APP_ID_HEADER_NAME, 1);
	                put(AppClientDetails.REQUEST_ID_HEADER_NAME, "2");
	                put(AppClientDetails.SYSTEM_ID_HEADER_NAME, "3");
	            }
	        };*/
		if(CommonVars.KAFKA_MSG_SEND_TOPIC.equalsIgnoreCase(topic) && (payload instanceof MessageCreateEvent)) {
			final StreamMessage streamMessage = new StreamMessage();
			streamMessage.setHeaders(headers);
			streamMessage.setPayload(payload);
			final MessagingTemplate messagingTemplate = messagingTemplateService.getTemplate("chat_producer");
			messagingTemplate.send(topic, streamMessage);
		}else if(CommonVars.KAFKA_MSG_RECEIPT_TOPIC.equalsIgnoreCase(topic) && (payload instanceof MessageReceiptEvent)) {
			final StreamMessage streamMessage = new StreamMessage();
			streamMessage.setHeaders(headers);
			streamMessage.setPayload(payload);
			final MessagingTemplate messagingTemplate = messagingTemplateService.getTemplate("chat_producer");
			messagingTemplate.send(topic, streamMessage);
		}else {
			//TODO Throw Invalid Topic Exception
		}
	}
}
