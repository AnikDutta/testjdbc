
package com.rci.cat.api.routes;

import org.apache.camel.Exchange;
import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestParamType;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.rci.cat.model.Cat;


@Component
public class CatServiceInterfaceRoute extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		onException(JsonProcessingException.class)
				.log(LoggingLevel.ERROR, "${exception.stacktrace}")
				.setBody(constant(null))
				.setHeader(Exchange.HTTP_RESPONSE_CODE, constant(400))
				.handled(true);
		
		rest()
				.description("Cat-service REST service")
				.consumes("application/json")
				.produces("application/json")
				.get("/ArpAndTierTypes")
					.id("GET /ArpAndTierTypes")
					.outType(String.class)
					.responseMessage()
						.code(200)
					.endResponseMessage()
					.to("direct:getArpAndTierTypes")
				.get("/health")
					.id("health")
					.description("Health route endpoint")
					.outType(String.class)
					.responseMessage()
						.code(200)
					.endResponseMessage()
					.to("direct:health");
	}

}
