/**
 * Copyright (C) InfoEdge (India) Limited - All Rights Reserved.
 * Unauthorized copying of this file, via any medium is strictly prohibited.
 * Proprietary and confidential.
 * 
 * Written by Amit Kumar<kumar.amit@naukri.com>.
 */
package com.ie.naukri.chatservice.chatEvents.services;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.eq;

import java.lang.reflect.Field;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.HttpMethod;

import com.ie.naukri.rest.client.delegates.RESTServiceDelegate;

/**
 * {@code TestServiceTests} contains plain JUnit tests with mocking framework -
 * Mockito
 *
 * @author Amit Kumar<kumar.amit@naukri.com>
 *
 * @created Dec 20, 2017 1:23:24 PM
 */
@RunWith(MockitoJUnitRunner.class)
public class WebhookProcessServiceTests {
	/**
	 * Create instances of target class using new operator and annotate it with
	 * {@code InjectMocks} annotation to automatically inject all the
	 * dependencies declared with {@code Mock} annotations in this class
	 */
	@InjectMocks
	private WebhookProcessService testService = new WebhookProcessService();

	/**
	 * Define fields(except for primitives, wrapper classes and String) with
	 * same name as that in target class {@code TestService} and annotate each
	 * of these with {@code Mock} annotation.
	 */
	@Mock
	private RESTServiceDelegate restServiceDelegate;

	/**
	 * Test method for
	 * {@link com.ie.naukri.chatservice.chatEvents.services.WebhookProcessService#fetchTestMessage()}.
	 * 
	 * @throws SecurityException
	 * @throws NoSuchFieldException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 */
	@Test
	public void testFetchTestMessage()
			throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		
	}

}