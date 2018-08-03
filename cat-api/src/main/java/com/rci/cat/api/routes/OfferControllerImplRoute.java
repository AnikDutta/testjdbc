
package com.rci.cat.api.routes;

import javassist.NotFoundException;
import javax.validation.ValidationException;

import org.apache.camel.CamelAuthorizationException;
import org.apache.camel.Exchange;
import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class OfferControllerImplRoute extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		onException(ValidationException.class)
				.log(LoggingLevel.ERROR, "${exception.stacktrace}")
				.setBody(constant(null))
				.setHeader(Exchange.HTTP_RESPONSE_CODE, constant(400))
				.handled(true);
		
		onException(NotFoundException.class)
				.log(LoggingLevel.ERROR, "${exception.stacktrace}")
				.setBody(constant(null))
				.setHeader(Exchange.HTTP_RESPONSE_CODE, constant(404))
				.handled(true);
		
		onException(CamelAuthorizationException.class)
				.log(LoggingLevel.ERROR, "${exception.stacktrace}")
				.setBody(constant(null))
				.setHeader(Exchange.HTTP_RESPONSE_CODE, constant(403))
				.handled(true);
		
		onException(Exception.class)
				.log(LoggingLevel.ERROR, "${exception.stacktrace}")
				.setBody(constant(null))
				.setHeader(Exchange.HTTP_RESPONSE_CODE, constant(500))
				.handled(true);
		
		from("direct:getOffers").routeId("direct:getOffers")
		//.policy("accessPolicy")
		.log(LoggingLevel.INFO, "direct:getOffers Initiated")
		.to("bean:offerService?method=getOffers(${headers})").choice().when(simple("${body.size} == 0"))
		.log(LoggingLevel.ERROR, "Error in direct:getOffers")
		.throwException(new NotFoundException("No records found")).otherwise()
		.log(LoggingLevel.INFO, "direct:getOffers");
		
		from("direct:postOffer").routeId("direct:postOffer")
		//.policy("accessPolicy")
		.log(LoggingLevel.INFO, "direct:postOffer Initiated")
		.to("bean:userService?method=postUser(${body}, ${headers})")
		.choice().when(simple("${body} != null"))
		.setHeader("Location", simple("${header.CamelHttpUri}/${body}")).setBody(constant(null))
		.setHeader(Exchange.HTTP_RESPONSE_CODE, constant(201))
		.log(LoggingLevel.INFO, "direct:postOffer Completed");
		
		
	}
}