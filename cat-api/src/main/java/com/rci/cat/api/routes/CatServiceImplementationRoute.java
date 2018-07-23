
package com.rci.cat.api.routes;

import javassist.NotFoundException;
import javax.validation.ValidationException;

import org.apache.camel.CamelAuthorizationException;
import org.apache.camel.Exchange;
import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class CatServiceImplementationRoute extends RouteBuilder {

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
		from("direct:getArpAndTierTypes")
				.routeId("direct:getArpAndTierTypes")
				.log(LoggingLevel.INFO, "{{cat-app.implementationRoute.log.message.key.1}}")
				.to("bean:catService?method=getArpAndTierTypes(${headers})")
				.choice()
				.when(simple("${body.size} == 0"))
					.log(LoggingLevel.ERROR, "{{cat-app.implementationRoute.log.message.key.2}}")
					.throwException(new NotFoundException("No records found"))
				.otherwise()
				.log(LoggingLevel.INFO, "{{cat-app.implementationRoute.log.message.key.3}}");
	}
}