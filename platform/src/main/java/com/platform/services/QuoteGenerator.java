package com.platform.services;

import org.json.simple.JSONObject;
import org.springframework.web.client.RestTemplate;

import com.platform.util.Restproxy;


public class QuoteGenerator {

	
	public static String getQuote() {
	final String uri = "https://programming-quotes-api.herokuapp.com/quotes/random";
   
	RestTemplate restTemplate=Restproxy.restTemplate();
    JSONObject res = restTemplate.getForObject(uri, JSONObject.class);
    String result=(String)res.get("en"); 
    
    
    
    //String date=sub[0];
	return result;
}
}
