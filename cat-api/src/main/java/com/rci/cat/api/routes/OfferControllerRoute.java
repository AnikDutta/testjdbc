
package com.rci.cat.api.routes;

import org.apache.camel.Exchange;
import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.rci.cat.model.CatJsonModel;


@Component
public class OfferControllerRoute extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		onException(JsonProcessingException.class)
				.log(LoggingLevel.ERROR, "${exception.stacktrace}")
				.setBody(constant(null))
				.setHeader(Exchange.HTTP_RESPONSE_CODE, constant(400))
				.handled(true);
		
		rest()
				.description("OfferControllerRoute REST service")
				.consumes("application/json")
				.produces("application/json")
				
				.get("/offers")
					.id("GET /offers")
					.outType(String.class)
					.responseMessage()
						.code(200)
					.endResponseMessage()
					.to("direct:getOffers")
					
				.post("/offers").id("POST /offers").type(CatJsonModel.class).responseMessage().code(201)
					.endResponseMessage().to("direct:postUser");
	}

}
