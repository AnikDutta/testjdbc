
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
				.to("bean:cat-service?method=getArpAndTierTypes(${headers})")
				.choice()
				.when(simple("${body.size} == 0"))
					.log(LoggingLevel.ERROR, "{{cat-app.implementationRoute.log.message.key.2}}")
					.throwException(new NotFoundException("No records found"))
				.otherwise()
				.log(LoggingLevel.INFO, "{{cat-app.implementationRoute.log.message.key.3}}");
		from("direct:getCats")
				.routeId("direct:getCats")
				.log(LoggingLevel.INFO, "{{cat-app.implementationRoute.log.message.key.1}}")
				.to("bean:cat-service?method=getCats(${headers})")
				.choice()
				.when(simple("${body.size} == 0"))
					.log(LoggingLevel.ERROR, "{{cat-app.implementationRoute.log.message.key.2}}")
					.throwException(new NotFoundException("No records found"))
				.otherwise()
				.log(LoggingLevel.INFO, "{{cat-app.implementationRoute.log.message.key.3}}");
		
		from("direct:postCat")
				.routeId("direct:postCat")
				.log(LoggingLevel.INFO, "{{cat-app.implementationRoute.log.message.key.4}}")
				.to("bean:cat-service?method=postCat(${body}, ${headers})")
				.choice()
				.when(simple("${body} != null"))
					.setHeader("Location", simple("${header.CamelHttpUri}/${body}"))
					.setBody(constant(null))
					.setHeader(Exchange.HTTP_RESPONSE_CODE, constant(201))
					.log(LoggingLevel.INFO, "{{cat-app.implementationRoute.log.message.key.5}}");
		
		from("direct:getCat")
				.routeId("direct:getCat")
				.log(LoggingLevel.INFO, "{{cat-app.implementationRoute.log.message.key.6}}")
				.to("bean:cat-service?method=getCat(${header.CatId}, ${headers})")
				.choice()
				.when(simple("${body} == null"))
					.log(LoggingLevel.ERROR, "{{cat-app.implementationRoute.log.message.key.7}}")
					.throwException(new NotFoundException("No record found"))
				.otherwise()
					.log(LoggingLevel.INFO, "{{cat-app.implementationRoute.log.message.key.3}}");
		
		from("direct:putCat")
				.routeId("direct:putCat")
				.log(LoggingLevel.INFO, "{{cat-app.implementationRoute.log.message.key.8}}")
				.to("bean:cat-service?method=putCat(${header.CatId}, ${body}, ${headers})")
				.choice()
				.when(simple("${body} == 0"))
					.log(LoggingLevel.ERROR, "{{cat-app.implementationRoute.log.message.key.9}}")
					.throwException(new NotFoundException("No record found"))
				.otherwise()
					.setBody(constant(null))
					.setHeader(Exchange.HTTP_RESPONSE_CODE, constant(204))
					.log(LoggingLevel.INFO, "{{cat-app.implementationRoute.log.message.key.10}}");
		
		from("direct:deleteCat")
				.routeId("direct:deleteCat")
				.log(LoggingLevel.INFO, "{{cat-app.implementationRoute.log.message.key.11}}")
				.to("bean:cat-service?method=deleteCat(${header.CatId}, ${headers})")
				.choice()
				.when(simple("${body} == 0"))
					.log(LoggingLevel.ERROR, "{{cat-app.implementationRoute.log.message.key.12}}")
					.throwException(new NotFoundException("No record found"))
				.otherwise()
					.setBody(constant(null))
					.setHeader(Exchange.HTTP_RESPONSE_CODE, constant(204))
					.log(LoggingLevel.INFO, "{{cat-app.implementationRoute.log.message.key.13}}");
	}
}