package com.rci.cat.api.test;

import org.apache.camel.Exchange;
import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestParamType;

import com.fasterxml.jackson.core.JsonProcessingException;

import com.rci.cat.model.Cat;

public class MockedCatApiInterfaceRoute extends RouteBuilder {

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
				.get("/Cats")
					.id("GET /Cats")
					.outType(Cat[].class)
					.responseMessage()
						.code(200)
					.endResponseMessage()
					.to("mock:getCats")
				.post("/Cats")
					.id("POST /Cats")
					.type(Cat.class)
					.responseMessage()
						.code(201)
					.endResponseMessage()
					.to("mock:postCat")
				.get("/Cats/{CatId}")
					.id("GET /Cats/{CatId}")
					.outType(Cat.class)
					.param()
						.name("CatId")
						.type(RestParamType.path)
						.dataType("string")
					.endParam()
					.responseMessage()
						.code(200)
					.endResponseMessage()
					.to("mock:getCat")
				.put("/Cats/{CatId}")
					.id("PUT /Cats/{CatId}")
					.type(Cat.class)
					.param()
						.name("CatId")
						.type(RestParamType.path)
						.dataType("string")
					.endParam()
					.responseMessage()
						.code(204)
					.endResponseMessage()
					.to("mock:putCat")
				.delete("/Cats/{CatId}")
					.id("DELETE /Cats/{CatId}")
					.param()
						.name("CatId")
						.type(RestParamType.path)
						.dataType("string")
					.endParam()
					.responseMessage()
						.code(204)
					.endResponseMessage()
					.to("mock:deleteCat")
				.get("/health")
					.id("health")
					.description("Health route endpoint")
					.outType(String.class)
					.responseMessage()
						.code(200)
					.endResponseMessage()
					.to("mock:health");
	}

}