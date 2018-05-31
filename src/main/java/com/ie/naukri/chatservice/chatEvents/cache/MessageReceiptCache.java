package com.ie.naukri.chatservice.chatEvents.cache;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.aerospike.client.AerospikeException;
import com.ie.naukri.cache.operations.AppAwareCacheOperations;
import com.ie.naukri.chatservice.chatEvents.models.MessageReceiptEvent;

@Component
public class MessageReceiptCache {

	@Inject
	private AppAwareCacheOperations<MessageReceiptEvent> operations;
	
	@Value("${aerospikeTTL}")
	private int expiryTime;

	private static final String CACHE_NAME = "chatevents_cache";
	
	Logger logger = LoggerFactory.getLogger(MessageReceiptCache.class);
	
	public void setMessageReceipt(MessageReceiptEvent messageReceiptEvent) {
		
		String composeKey = messageReceiptEvent.getConversation().getConversationId();
		try {
			operations.set(CACHE_NAME, composeKey, messageReceiptEvent);
		}catch(AerospikeException exception) {
			logger.error("Aerospike is unable to save-value  -> " + CACHE_NAME + " : "+ composeKey + " , " + exception.getMessage());
		}
	}
	
	public boolean getMessageReceipt(String convId, long msgPos) {
	try {
		MessageReceiptEvent cacheEvent = operations.get(CACHE_NAME, convId); 
		if(cacheEvent!=null) {
			long readEventMsgPosMaxValue = cacheEvent.getReceipt().getPositions().getTo();
			if(msgPos > readEventMsgPosMaxValue) {
				//Read Receipts exist for older messages hence send mail
				return true;
			}else {
				//Read rececipts exists for the message position, hence dont send mail.
				return false;
			}
		}
		return true;
	 }catch(AerospikeException exception) {
		 logger.error("Aerospike is unable to get-value  -> " + CACHE_NAME + " : "+ convId + ", for message position : "+String.valueOf(msgPos)+ " ," + exception.getMessage());
	 }
	//Exception Occured, hence send mail.
		return true;
	}
}
