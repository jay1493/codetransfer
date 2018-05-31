/**
 * Copyright (C) InfoEdge (India) Limited - All Rights Reserved. Unauthorized copying of this file, via any medium is
 * strictly prohibited. Proprietary and confidential.
 * 
 * Written by Amit Kumar<kumar.amit@naukri.com>.
 */
package com.ie.naukri.chatservice.chatEvents.mappers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.ie.naukri.common.mappers.ApplicationExceptionMapper;
import com.ie.naukri.exceptions.ApplicationRuntimeException;
import com.ie.naukri.exceptions.IncorrectUserCredentialsException;
import com.ie.naukri.exceptions.InputValidationException;
import com.ie.naukri.exceptions.UnauthorizedAccessException;
import com.ie.naukri.exceptions.models.ErrorResponse;
import org.glassfish.jersey.server.ResourceConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.EmptyResultDataAccessException;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import java.util.Set;

/**
 * {@code ApplicationExceptionsMapper} is responsible for registering exceptions
 * with Jersey framework in order to send error responses to service clients.
 *
 * @author Amit Kumar<kumar.amit@naukri.com>
 *
 * @created 04-Nov-2016 12:13:45 PM
 */
public class ApplicationExceptionsMapper {

	private static final Logger LOG = LoggerFactory.getLogger(ApplicationExceptionsMapper.class);

	/**
	 * private constructor to prevent creation of instances of this class.
	 */
	private ApplicationExceptionsMapper() {
	}

	/**
	 * Registers exception mappers for custom, generic and Jersey provided
	 * exceptions with specified {@link ResourceConfig} instance.
	 * 
	 * @param resourceConfig
	 *            ResourceConfig object whom exception mappers need to be
	 *            registered to.
	 * 
	 */
	public static void registerExceptionMappers(final ResourceConfig resourceConfig) {

		// Register exception mappers for Jersey provided exceptions
		// Message will be taken from exception itself
		resourceConfig
				.register(new ApplicationExceptionMapper<ConstraintViolationException>(Status.BAD_REQUEST, false) {
				});
		// Message will be taken from exception itself
		resourceConfig.register(new ApplicationExceptionMapper<ValidationException>(Status.BAD_REQUEST, false) {
		});
		// Message will be taken from exception itself
		resourceConfig.register(new ApplicationExceptionMapper<NotFoundException>(Status.NOT_FOUND, false) {
		});
		// Message will be taken from exception itself
		resourceConfig.register(new ApplicationExceptionMapper<EmptyResultDataAccessException>(Status.NOT_FOUND) {
		});
		// Message and Status code will be taken from exception itself
		resourceConfig.register(new ApplicationExceptionMapper<WebApplicationException>() {
		});

		// Register custom exceptions
		// Message will be taken from exception itself
		resourceConfig.register(new ApplicationExceptionMapper<InputValidationException>(Status.BAD_REQUEST, false) {
		});
		
		resourceConfig.register(new ApplicationExceptionMapper<JsonProcessingException>(Status.BAD_REQUEST, false) {
		});

		resourceConfig.register(
				new ApplicationExceptionMapper<com.ie.naukri.exceptions.NotFoundException>(Status.NOT_FOUND, false) {
				});

		resourceConfig.register(
				new ApplicationExceptionMapper<IncorrectUserCredentialsException>(Status.UNAUTHORIZED, false) {
				});

		resourceConfig.register(new ApplicationExceptionMapper<UnauthorizedAccessException>(Status.FORBIDDEN, false) {
		});

		// Register generic exception
		resourceConfig.register(new ApplicationExceptionMapper<Exception>(Status.INTERNAL_SERVER_ERROR,
				"Unexpected error while processing your request") {
		});
	}
}