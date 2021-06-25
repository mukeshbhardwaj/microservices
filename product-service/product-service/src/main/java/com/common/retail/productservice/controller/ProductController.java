package com.common.retail.productservice.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping(value = "/api")
public class ProductController {

	@Autowired
	RestTemplate restTemplate;

//	@Autowired
//	private LoadBalancerClient loadBalancerClient;

	@Autowired
	ServiceInstance serviceinstance;

	@GetMapping("/welcome")
	public String getWelcomeforProduct() {
		return "Welcome to Product Page";
	}

//	@HystrixCommand(fallbackMethod = "productFallbackMethod")
//	@GetMapping("/product")
//	public String getWelcomeFromShoping() {
//
////		String url = "http://SHOPPING-SERVICE/shopping";
//		String url = "http://SHOPPING-SERVICE/api/shoping";
//
//		serviceinstance = loadBalancerClient.choose("SHOPPING-SERVICE");
//		System.out.println("which port is connecting to" + "   " + serviceinstance.getUri());
//		return restTemplate.getForObject(url, String.class);
//	}
	
//	@HystrixCommand(fallbackMethod = "productFallbackMethod")
	@GetMapping("/product")
	public String getWelcomeFromShoping() {

		System.out.println("Response Received as " + new Date());

		return "NORMAL FLOW  product service is called!!! -  " + new Date();

	}

//	public String productFallbackMethod() {
//		return "Fall back method call! Please try after some time! welcome to Product fall back method";
//	}
	
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
