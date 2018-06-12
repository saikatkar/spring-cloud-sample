package com.spring.cloud.eureka.client.config;

import org.springframework.context.annotation.Bean;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.IPing;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.PingUrl;
import com.netflix.loadbalancer.RoundRobinRule;

/**
 * Holds the config related to ribbon load balancer.
 * @author saikatkar1
 *
 */
public class RecommendationsRibbonConfig {
	
	
	  @Bean
	  public IPing ribbonPing(IClientConfig config) {
	    return new PingUrl();
	  }
	  
	  @Bean
	  public IRule ribbonRule(IClientConfig config) {
	    return new RoundRobinRule();
	  }

}
