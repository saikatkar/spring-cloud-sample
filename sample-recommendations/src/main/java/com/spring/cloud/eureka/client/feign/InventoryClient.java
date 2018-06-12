package com.spring.cloud.eureka.client.feign;


import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.cloud.eureka.entity.Product;

@FeignClient("inventory")
public interface InventoryClient {
	
	@LoadBalanced
	@RequestMapping(method = RequestMethod.GET, value = "/buy/{productId}")
    Product buyProduct(@PathVariable("productId") String productId);
	
	@LoadBalanced
	@RequestMapping(method = RequestMethod.GET, value = "/buy/instance")
    String getInstanceId();
	
}
