package com.spring.cloud.eureka.client.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.collect.ImmutableMap;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.spring.cloud.eureka.entity.Product;

/**
 * @author saikatkar1
 *
 */

@RestController
@RequestMapping("/buy")
public class BuyProductController {

	
	final Map<String,Product> productMap = ImmutableMap.of("mobile",new Product("mobile", "mobile", "electronics", "100"),
															"tab",new Product("tab", "tab", "electronics", "200"),
															"laptop",new Product("laptop","laptop","electronics", "300"),
															"desktop" ,new Product("desktop","desktop","electronics","400")
															);
	@Autowired
	private EurekaClient eurekaClient;

	
	@RequestMapping(method = RequestMethod.GET, value = "/{productId}")
    Product buyProduct(@PathVariable("productId") String productId) {
		
		Product product = productMap.get(productId);
	    return product;
		
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/instance")
	String getInstanceId() {
		
		InstanceInfo instance = eurekaClient. getNextServerFromEureka("inventory", false);
		System.out.println("instance :*** "+ instance.getHomePageUrl());
		return instance.getId();
	}
}
