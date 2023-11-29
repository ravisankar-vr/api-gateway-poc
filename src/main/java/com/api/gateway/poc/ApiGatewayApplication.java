package com.api.gateway.poc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.openfeign.EnableFeignClients;
//import org.springframework.cloud.netflix.eureka.CloudEurekaClient;

@EnableDiscoveryClient
@SpringBootApplication
@EnableZuulProxy
@EnableFeignClients
public class ApiGatewayApplication {

	public static void main(String[] args) {
		//SpringApplication.run(ApiGatewayApplication.class, args);
		new SpringApplicationBuilder(ApiGatewayApplication.class)
				.web(WebApplicationType.REACTIVE)
				.run(args);
	}

}
