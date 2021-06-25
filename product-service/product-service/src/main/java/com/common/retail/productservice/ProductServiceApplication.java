package com.common.retail.productservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

//@EnableHystrixDashboard
//@EnableCircuitBreaker
@SpringBootApplication
//@EnableDiscoveryClient
//@EnableHystrix
@ComponentScan({"com.common.retail.productservice","controller"})
public class ProductServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductServiceApplication.class, args);
	}
//	@Configuration
//	class ConfigRestTemplate{
//		@LoadBalanced
//		@Bean
//		public RestTemplate restTemplate() {
//			return new RestTemplate();
//		}
//	}
}
