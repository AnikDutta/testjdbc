package com.rci.cat.model.test;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rci.cat.model.ApiDataModel;
import com.rci.cat.model.CatJsonModel;
import com.rci.cat.model.OfferDto;


public class TestCatJsonModel {
		
	static void testCase2() {
		ObjectMapper mapper = new ObjectMapper();
//	    mapper.setSerializationInclusion(Include.NON_NULL);
		
		CatJsonModel catModel = new CatJsonModel();
		ApiDataModel apiDataModel = new ApiDataModel();
		
		OfferDto offerDto = new OfferDto();
		
		offerDto.setOfferName("X-Mass Offer");
		offerDto.setOfferCode("OF1234");
		
		apiDataModel.setOfferDto(offerDto);
		catModel.setData(apiDataModel);
	 
	    try {
			String dtoAsString = mapper.writeValueAsString(catModel);
			
			System.out.println("catModel:-\n"+dtoAsString);
			
		} catch (JsonProcessingException e) {			
			e.printStackTrace();
		}	 
	    
	}
	

	public static void main(String[] args) {
		testCase2();	
	}

}
