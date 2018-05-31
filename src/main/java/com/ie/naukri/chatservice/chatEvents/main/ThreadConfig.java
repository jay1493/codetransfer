package com.ie.naukri.chatservice.chatEvents.main;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
public class ThreadConfig {
	
	@Bean
    public TaskExecutor threadPoolExecutor(){
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        taskExecutor.setMaxPoolSize(20);
        taskExecutor.setCorePoolSize(5);
        taskExecutor.setQueueCapacity(100);
        taskExecutor.setThreadNamePrefix("main_task_executor_thread");
        taskExecutor.initialize();
        return taskExecutor;
    }
}
