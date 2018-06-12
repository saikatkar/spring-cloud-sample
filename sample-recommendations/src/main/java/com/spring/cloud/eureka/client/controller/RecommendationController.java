package com.spring.cloud.eureka.client.controller;

import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.spring.cloud.eureka.client.feign.InventoryClient;
import com.spring.cloud.eureka.entity.Product;



/**
 * @author saikatkar1
 *
 */

@RestController
@RequestMapping("/recommend")
public class RecommendationController {

	@Autowired
	private InventoryClient inventory;
	
	final Map<String,? extends Set<String>> recommendationsMap = ImmutableMap.of("electronics",Sets.newHashSet("mobile","tab","laptop","desktop"),
																	  "grocery",Sets.newHashSet("rice","wheat","spices","phenyl"),
																	  "garments",Sets.newHashSet("shirt","pant","suit","punjabi"));
	
	@HystrixCommand(fallbackMethod = "recommendFallback",commandProperties={
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000"),
            @HystrixProperty(name = "execution.isolation.strategy", value = "SEMAPHORE")
        })
	@RequestMapping(method = RequestMethod.GET, value = "/{productId}")
    Map<String,Set<String>> recommend(@PathVariable("productId") String productId) {
		
		 Map<String,Set<String>> resultmap = Maps.newHashMap();
		 Product product = inventory.buyProduct(productId);
		
		 Set<String> set = Sets.newHashSet(recommendationsMap.get(product.getProductType()));
		 set.remove(productId);
		 resultmap.put("recommendations", set);
		 String instanceId = inventory.getInstanceId();
		 resultmap.put("instanceId", Sets.newHashSet(instanceId));
		 return resultmap;
		
	}
	
	 Map<String,Set<String>> recommendFallback(String productId){
		 
		 Map<String,Set<String>> map = Maps.newHashMap();
		 map.put("instanceId", Sets.newHashSet("fallback"));
		 map.put("recommendations", Sets.newHashSet(""));
		 return map;
		 
	 }
}
