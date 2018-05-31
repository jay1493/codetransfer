/**
 * Copyright (C) InfoEdge (India) Limited - All Rights Reserved.
 * Unauthorized copying of this file, via any medium is strictly prohibited.
 * Proprietary and confidential.
 * 
 * Written by Amit Kumar<kumar.amit@naukri.com>.
 */
package com.ie.naukri.chatservice.chatEvents.services;

import java.util.Random;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.ie.naukri.chatservice.chatEvents.kafka_producers.MessageEventsProducer;
import com.ie.naukri.chatservice.chatEvents.models.MessageCreateEvent;
import com.ie.naukri.chatservice.chatEvents.models.MessageReceiptEvent;
import com.ie.naukri.chatservice.chatEvents.utils.CommonVars;
import com.ie.naukri.rest.client.delegates.RESTServiceDelegate;

/**
 * WebhookProcessService
 *
 */
@Service
public class WebhookProcessService {

	@Inject
	private RESTServiceDelegate restServiceDelegate;
	@Inject
	private MessageEventsProducer messageEventsProducer;
	
	private Logger logger = LoggerFactory.getLogger(WebhookProcessService.class);
	
	@Async
	public void processMessageCreateEvent(MessageCreateEvent messageCreateEvent, HttpServletRequest request) {
		//TODO Throw exceptions and handle kafka operations
		messageEventsProducer.pushMessageToKafka(CommonVars.KAFKA_MSG_SEND_TOPIC, messageCreateEvent);
	}
	
	@Async
	public void processMessageReceiptEvent(MessageReceiptEvent messageReceiptEvent, HttpServletRequest request) {
		//TODO Throw exceptions and handle kafka operations
		messageEventsProducer.pushMessageToKafka(CommonVars.KAFKA_MSG_RECEIPT_TOPIC, messageReceiptEvent);
	}
	
}
