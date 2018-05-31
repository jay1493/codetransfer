/**
 * Copyright (C) InfoEdge (India) Limited - All Rights Reserved. Unauthorized copying of this file, via any medium is
 * strictly prohibited. Proprietary and confidential.
 * 
 * Written by Amit Kumar<kumar.amit@naukri.com>.
 */
package com.ie.naukri.chatservice.chatEvents.main;

import org.glassfish.jersey.examples.httppatch.OptionsAcceptPatchHeaderFilter;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.jaxrs.json.JacksonJaxbJsonProvider;
import com.ie.naukri.chatservice.chatEvents.filters.RequestResponseLoggingFilter;
import com.ie.naukri.chatservice.chatEvents.mappers.ApplicationExceptionsMapper;
import com.ie.naukri.chatservice.chatEvents.resources.WebhookResource;

/**
 * JerseyConfig
 *
 * @author Amit Kumar<kumar.amit@naukri.com>.
 *
 * @created 28-Oct-2016 3:07:20 PM
 */
@Component
public class JerseyConfig extends ResourceConfig {

	public JerseyConfig() {
		// Filter responsible for validating AppId and Request Id, and logging
		// requests and responses
		super.register(RequestResponseLoggingFilter.class);

		// Filter to allow patch calls go through
		super.register(OptionsAcceptPatchHeaderFilter.class);

		// Json Provider to avoid registering of default Jersey exception
		// mappers as we need to use our custom mappers
		super.register(JacksonJaxbJsonProvider.class);

		// Exception Mappers to send error response in case of exceptions
		ApplicationExceptionsMapper.registerExceptionMappers(this);

		super.registerClasses(WebhookResource.class);
	}
}
