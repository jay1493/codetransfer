package com.ie.naukri.chatservice.chatEvents.main;

import java.lang.reflect.Method;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;

public class ApplicationThreadExceptionHandler implements AsyncUncaughtExceptionHandler {
	
	private Logger logger = LoggerFactory.getLogger(ApplicationThreadExceptionHandler.class);

	@Override
	public void handleUncaughtException(Throwable arg0, Method arg1, Object... arg2) {
		// TODO Auto-generated method stub
		logger.error(arg1.getName()+" , reported error : "+arg0.getMessage());
	}

}
