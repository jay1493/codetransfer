package com.ie.naukri.chatservice.chatEvents.main;

import java.util.concurrent.Executor;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.scheduling.annotation.AsyncConfigurerSupport;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

@Component
@EnableAsync
public class ApplicationThreadConfig extends AsyncConfigurerSupport {
	
	

	@Override
	public Executor getAsyncExecutor() {
		// TODO Auto-generated method stub
		ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        taskExecutor.setMaxPoolSize(20);
        taskExecutor.setCorePoolSize(5);
        taskExecutor.setQueueCapacity(100);
        taskExecutor.setThreadNamePrefix("main_task_executor_thread");
        taskExecutor.initialize();
        return taskExecutor;
	}

	@Override
	public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
		// TODO Auto-generated method stub
		return new ApplicationThreadExceptionHandler();
	}
	
	

}
