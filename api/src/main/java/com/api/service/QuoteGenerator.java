package com.api.service;

import org.json.simple.JSONObject;
import org.springframework.web.client.RestTemplate;


public class QuoteGenerator {

	
	public static String getQuote() {
	final String uri = "https://programming-quotes-api.herokuapp.com/quotes/random";
    final String TIME="http://worldtimeapi.org/api/ip";
    RestTemplate restTemplate = new RestTemplate();
    JSONObject res = restTemplate.getForObject(uri, JSONObject.class);
    String result=(String)res.get("en"); 
    
    JSONObject tiem=restTemplate.getForObject(TIME,JSONObject.class);
    String euroTime=(String)tiem.get("datetime");
    
    String[] sub=euroTime.split("T");
    String timeBig=sub[1];
    String[] timeLis=timeBig.split(".");
    String time=timeLis[0];
    //String date=sub[0];
	return time;
}
}
