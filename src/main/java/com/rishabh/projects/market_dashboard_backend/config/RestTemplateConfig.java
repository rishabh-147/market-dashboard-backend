package com.rishabh.projects.market_dashboard_backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {

	@Bean(name = "finnhubRestTemplate")
	public RestTemplate finnhubRestTemplate() {
		return new RestTemplate();
	}
	
	@Bean(name = "alphaVantageRestTemplate")
	public RestTemplate alphaVantageRestTemplate() {
		return new RestTemplate();
	}
}
