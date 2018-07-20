package com.rci.cat.api.test;

import javax.validation.ValidationException;

import org.apache.camel.CamelAuthorizationException;
import org.apache.camel.Exchange;
import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;

import javassist.NotFoundException;

public class MockedCatApiImplementationRoute extends RouteBuilder{

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
		
		from("direct:getCats")
				.routeId("direct:getCats")
				.policy("accessPolicy")
				.log(LoggingLevel.INFO, "{{Cat-service.implementationRoute.log.message.key.1}}")
				.to("bean:CatService?method=getCats(${headers})")
				.choice()
				.when(simple("${body.size} == 0"))
					.log(LoggingLevel.ERROR, "{{Cat-service.implementationRoute.log.message.key.2}}")
					.throwException(new NotFoundException("No records found"))
				.otherwise()
				.log(LoggingLevel.INFO, "{{Cat-service.implementationRoute.log.message.key.3}}");
		
		from("direct:postCat")
				.routeId("direct:postCat")
				.policy("accessPolicy")
				.log(LoggingLevel.INFO, "{{Cat-service.implementationRoute.log.message.key.4}}")
				.to("bean:CatService?method=postCat(${body}, ${headers})")
				.choice()
				.when(simple("${body} != null"))
					.setHeader("Location", simple("${header.CamelHttpUri}/${body}"))
					.setBody(constant(null))
					.setHeader(Exchange.HTTP_RESPONSE_CODE, constant(201))
					.log(LoggingLevel.INFO, "{{Cat-service.implementationRoute.log.message.key.5}}");
		
		from("direct:getCat")
				.routeId("direct:getCat")
				.policy("accessPolicy")
				.log(LoggingLevel.INFO, "{{Cat-service.implementationRoute.log.message.key.6}}")
				.to("bean:CatService?method=getCat(${header.CatId}, ${headers})")
				.choice()
				.when(simple("${body} == null"))
					.log(LoggingLevel.ERROR, "{{Cat-service.implementationRoute.log.message.key.7}}")
					.throwException(new NotFoundException("No record found"))
				.otherwise()
					.log(LoggingLevel.INFO, "{{Cat-service.implementationRoute.log.message.key.3}}");
		
		from("direct:putCat")
				.routeId("direct:putCat")
				.policy("accessPolicy")
				.log(LoggingLevel.INFO, "{{Cat-service.implementationRoute.log.message.key.8}}")
				.to("bean:CatService?method=putCat(${header.CatId}, ${body}, ${headers})")
				.choice()
				.when(simple("${body} == 0"))
					.log(LoggingLevel.ERROR, "{{Cat-service.implementationRoute.log.message.key.9}}")
					.throwException(new NotFoundException("No record found"))
				.otherwise()
					.setBody(constant(null))
					.setHeader(Exchange.HTTP_RESPONSE_CODE, constant(204))
					.log(LoggingLevel.INFO, "{{Cat-service.implementationRoute.log.message.key.10}}");
		
		from("direct:deleteCat")
				.routeId("direct:deleteCat")
				.policy("accessPolicy")
				.log(LoggingLevel.INFO, "{{Cat-service.implementationRoute.log.message.key.11}}")
				.to("bean:CatService?method=deleteCat(${header.CatId}, ${headers})")
				.choice()
				.when(simple("${body} == 0"))
					.log(LoggingLevel.ERROR, "{{Cat-service.implementationRoute.log.message.key.12}}")
					.throwException(new NotFoundException("No record found"))
				.otherwise()
					.setBody(constant(null))
					.setHeader(Exchange.HTTP_RESPONSE_CODE, constant(204))
					.log(LoggingLevel.INFO, "{{Cat-service.implementationRoute.log.message.key.13}}"); 
	}

}