package com.rishabh.projects.market_dashboard_backend.webClients;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.rishabh.projects.market_dashboard_backend.config.ApplicationConfiguration;
import com.rishabh.projects.market_dashboard_backend.model.alphaVantage.clientResponse.AlphaVantageResponse;

@Component
public class AlphaVantageClient {
	
	private final Logger logger = LoggerFactory.getLogger(AlphaVantageClient.class);
	private RestTemplate restTemplate;
	private ApplicationConfiguration configuration;

	public AlphaVantageClient(@Qualifier("alphaVantageRestTemplate") RestTemplate restTemplate,
			ApplicationConfiguration configuration) {
		this.restTemplate = restTemplate;
		this.configuration = configuration;
	}

	public AlphaVantageResponse getDailyStock(String symbol) {
		String url = configuration.getBaseUrlAlphaVantage() + "?function=TIME_SERIES_DAILY" + "&symbol=" + symbol
				+ "&apikey=" + configuration.getApiKeyAlphaVantage();
		
		logger.info("AlphaVantageWebClient :: URL [{}] ",url);
		
		AlphaVantageResponse response = restTemplate.getForObject(url, AlphaVantageResponse.class);
		
		logger.info("AlphaVantageWebClient :: Fetch successful ");
		
		return response;
	}
}
