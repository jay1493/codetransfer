/**
 * Copyright (C) InfoEdge (India) Limited - All Rights Reserved. Unauthorized copying of this file, via any medium is
 * strictly prohibited. Proprietary and confidential.
 * 
 * Written by Arpit Shah<arpit.shah@naukri.com>
 */
package com.ie.naukri.chatservice.chatEvents.filters;

import com.ie.naukri.chatservice.chatEvents.utils.CommonVars;
import com.ie.naukri.common.providers.AppClientDetails;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.util.StringUtils;

import javax.validation.ValidationException;
import javax.ws.rs.HttpMethod;
import javax.ws.rs.container.*;
import javax.ws.rs.ext.Provider;
import java.io.IOException;

/**
 * @author Arpit Shah<arpit.shah@naukri.com>
 *
 * Created at 2:52:01 PM
 */
@Provider
@PreMatching
public class RequestResponseLoggingFilter implements ContainerRequestFilter, ContainerResponseFilter {

	private final static Logger LOG = LoggerFactory.getLogger(RequestResponseLoggingFilter.class);

	/**
	 * @param requestContext
	 * @throws IOException
	 */
	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {
		final String layerEvent = requestContext.getHeaders().getFirst(CommonVars.LAYER_WEBHOOK_EVENT_TYPE);
		final String layerSign = requestContext.getHeaders().getFirst(CommonVars.LAYER_WEBHOOK_SIGNATURE);
		final String layerRequestId = requestContext.getHeaders().getFirst(CommonVars.LAYER_WEBHOOK_REQUEST_ID);
		final String layerUserAgent = requestContext.getHeaders().getFirst(CommonVars.LAYER_USER_AGENT);
		final String layerConentType = requestContext.getHeaders().getFirst(CommonVars.LAYER_CONTENT_TYPE);
		if (!HttpMethod.OPTIONS.equals(requestContext.getMethod()) && (StringUtils.isEmpty(layerEvent) && StringUtils.isEmpty(layerSign) && StringUtils.isEmpty(layerRequestId)
				&& !CommonVars.LAYER_USER_AGENT_VALUE.equalsIgnoreCase(layerUserAgent))) {
			throw new ValidationException("Invalid layer webhook request");
		}

		// Adding RequestId to Logger MDC to include in all log statements
		
		MDC.put("layerEvent", layerEvent);
		MDC.put("layerRequestId", layerRequestId);		
		// Add client information to AppClientDetails to remove need of passing these around in methods
		CommonVars.set(layerEvent,layerRequestId);
	}

	/**
	 * @param requestContext
	 * @param responseContext
	 * @throws IOException
	 */
	@Override
	public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext)
			throws IOException {

		// Clear MDC to remove unused data
		MDC.clear();
		
		//TODO: Need to setup alert on Aura, if service takes longer then 800ms
		
		// Clear AppClientDetails to remove unused data
		CommonVars.clear();
	}
}