package com.platform.util;

import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Proxy.Type;

import org.springframework.context.annotation.Bean;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

public class Restproxy {
	@Bean
	public static RestTemplate restTemplate() {
	    SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();

	    Proxy proxy = new Proxy(Type.HTTP, new InetSocketAddress("proxy.cognizant.com", 6050));
	    requestFactory.setProxy(proxy);

	    return new RestTemplate(requestFactory);
	}
}
