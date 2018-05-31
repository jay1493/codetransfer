/**
 * Copyright (C) InfoEdge (India) Limited - All Rights Reserved. Unauthorized copying of this file, via any medium is
 * strictly prohibited. Proprietary and confidential.
 * <p>
 * Written by Amit Kumar<kumar.amit@naukri.com>.
 */
package com.ie.naukri.chatservice.chatEvents.resources;

import com.ie.naukri.chatservice.chatEvents.main.ApplicationConfig;
import com.ie.naukri.exceptions.models.ErrorCodes;
import com.ie.naukri.exceptions.models.ErrorResponse;
import com.ie.naukri.exceptions.models.FieldValidationError;
import com.ie.naukri.rest.client.exceptions.RESTServiceIntegrationException;
import com.ie.naukri.test.utils.SystemPropertyActiveProfileResolver;
import com.ie.naukri.test.utils.TestRESTServiceDelegate;
import org.glassfish.jersey.examples.httppatch.CustomMediaTypes;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import javax.inject.Inject;
import java.net.URI;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import static org.junit.Assert.*;

/**
 * TestResourceTests
 *
 * @author Amit Kumar<kumar.amit@naukri.com>
 *
 * @created 04-Nov-2016 3:23:07 PM
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ApplicationConfig.class, webEnvironment = WebEnvironment.RANDOM_PORT)
@ActiveProfiles(profiles = "dev", resolver = SystemPropertyActiveProfileResolver.class)
public class TestResourceTests {

    @Inject
    private TestRestTemplate testRestTemplate;

    @Inject
    private TestRESTServiceDelegate restServiceDelegate;

    private static final String APPID_HEADER_NAME = "AppId";
    private static final String REQUESTID_HEADER_NAME = "HTTP_X_TRANSACTION_ID";
    private static final String SYSTEMID_HEADER_NAME = "SystemId";
    private static final String APP_ID = "123";
    private static final String SYSTEM_ID = "test";

   
}