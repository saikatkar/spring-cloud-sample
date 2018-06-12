package com.spring.cloud.eureka.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

import com.spring.cloud.eureka.client.feign.InventoryClient;

@SpringBootApplication
@EnableEurekaClient
@org.springframework.cloud.netflix.feign.EnableFeignClients(basePackageClasses= {InventoryClient.class})
@EnableHystrix
public class EurekaClientApp {

	public static void main(String[] args) {
		SpringApplication.run(EurekaClientApp.class, args);
		
	}
	
	

}