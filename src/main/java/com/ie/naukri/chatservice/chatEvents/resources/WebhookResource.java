/**
 * Copyright (C) InfoEdge (India) Limited - All Rights Reserved. Unauthorized copying of this file, via any medium is
 * strictly prohibited. Proprietary and confidential.
 * <p>
 * Written by Amit Kumar<kumar.amit@naukri.com>.
 */
package com.ie.naukri.chatservice.chatEvents.resources;

import com.ie.naukri.chatservice.chatEvents.constraints.ValidMessageCreatedPayload;
import com.ie.naukri.chatservice.chatEvents.models.Message;
import com.ie.naukri.chatservice.chatEvents.models.MessageCreateEvent;
import com.ie.naukri.chatservice.chatEvents.models.MessageReceiptEvent;
import com.ie.naukri.chatservice.chatEvents.services.WebhookProcessService;
import org.glassfish.jersey.examples.httppatch.CustomMediaTypes;
import org.glassfish.jersey.examples.httppatch.PATCH;
import org.glassfish.jersey.examples.httppatch.utils.JsonObjectPatcher;
import org.springframework.core.task.TaskExecutor;
import org.springframework.web.bind.annotation.RequestBody;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.net.URI;

/**
 * Webhook Resource
 */
@Path("/test")//TODO
public class WebhookResource {

    @Inject
    private WebhookProcessService webhookProcessService;


    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/messageCreateEvent")
    public Response processCreateEvent(@Valid @RequestBody MessageCreateEvent messageCreateEvent, @Context HttpServletRequest request) {
    	webhookProcessService.processMessageCreateEvent(messageCreateEvent,request);
    	
        return Response.accepted().build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/messageReceiptEvent")
    public Response processReceiptEvent(@Valid @RequestBody MessageReceiptEvent messageReceiptEvent, @Context HttpServletRequest request) {
        webhookProcessService.processMessageReceiptEvent(messageReceiptEvent,request);
     
        return Response.accepted().build();
    }


}
