package com.rci.cat.service.delegate;

import java.io.IOException;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rci.cat.model.OfferDto;

public class OfferServiceDelegate {
	
		
	public OfferDto saveOffer(OfferDto offerDto) throws JsonProcessingException
					, JsonParseException, JsonMappingException, IOException {
		
		String url = "http://localhost:13001/offer-service/1.0/offers";
		
		ObjectMapper mapper = new ObjectMapper();		
		String requestJson = null;
		requestJson = mapper.writeValueAsString(offerDto);
				
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		HttpEntity<String> entity = new HttpEntity<String>(requestJson, headers);
		RestTemplate restTemplate = new RestTemplate();
		String response = restTemplate.postForObject(url, entity, String.class);	
		
		offerDto = mapper.readValue(response, OfferDto.class);
				
		return offerDto;
	}
	

}
