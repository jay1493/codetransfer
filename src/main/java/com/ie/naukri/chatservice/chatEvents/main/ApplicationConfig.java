package com.ie.naukri.chatservice.chatEvents.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.ie.naukri.messaging.listeners.KeyedMessageStreamListener;

@SpringBootApplication(scanBasePackages="com.ie.naukri.chatservice.chatEvents")
// Disable Spring default datasource configuration to use Naukri one
@EnableAutoConfiguration(exclude = { DataSourceAutoConfiguration.class})
@EnableConfigurationProperties
public class ApplicationConfig {
	
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	public static void main(final String[] args) {
		SpringApplication.run(ApplicationConfig.class, args);
	}
}