
package com.rci.cat.api.routes;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class CatServiceHealthRoute extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		from("direct:health")
			.transform()
			.constant("OK")
			.setHeader(Exchange.CONTENT_TYPE, constant("text/plain"))
			.setHeader(Exchange.HTTP_RESPONSE_CODE, constant("200"));
	}

}
