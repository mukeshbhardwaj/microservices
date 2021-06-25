package com.common.retail.shoppingservice.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping(value = "/api")
public class ShoppingController {
	@Autowired
	RestTemplate restTemplate;

	@Autowired
	private LoadBalancerClient loadBalancerClient;

	@Autowired
	ServiceInstance serviceinstance;

	@GetMapping("/welcome")
	public String getWelcomeforProduct() {
		return "Welcome to Shoping Page";
	}

//	@HystrixCommand(fallbackMethod = "shopingfallbackMethod")
//	@GetMapping("/shoping")
//	public String getWelcomeFromShoping() {
//		System.out.println("calling shoping srvice");
//		
//		String url = "http://PRODUCT-SERVICE/api/product/fromshop";
//
//		serviceinstance = loadBalancerClient.choose("PRODUCT-SERVICE");
//		System.out.println("which port is connecting to" + "   " + serviceinstance.getUri());
//
//		return restTemplate.getForObject(url, String.class);
//	}
	
	@HystrixCommand(fallbackMethod = "shopingfallbackMethod")
	@GetMapping("/shoping")
	public String getWelcomeFromShoping() {
		System.out.println("calling shoping srvice");
		String response = restTemplate
				.exchange("http://localhost:8091/api/product"
				, HttpMethod.GET
				, null
				, new ParameterizedTypeReference<String>() {
			}).getBody();

		System.out.println("Response Received as " + response + " -  " + new Date());

		return "NORMAL FLOW !!! " + response + " -  " + new Date();
	
	}

	public String shopingfallbackMethod() {
		return "Fall back method call! Please try after some time! welcome to Shoping fall back method";
	}
	
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
