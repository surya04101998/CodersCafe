package com.platform.services;

import org.json.simple.JSONObject;
import org.springframework.web.client.RestTemplate;

import com.platform.util.Restproxy;



public class TimeGenerator {
	
	public static String getTime() {
	RestTemplate restTemplate=Restproxy.restTemplate();
	final String TIME="http://worldtimeapi.org/api/ip";
	
	JSONObject tiem=restTemplate.getForObject(TIME,JSONObject.class);
	String euroTime=(String)tiem.get("datetime");
    String[] dateTime=euroTime.split("T");
	
	return dateTime[1].substring(0, 7);
	
	}
}
