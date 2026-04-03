package com.rishabh.projects.market_dashboard_backend.webClients;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.rishabh.projects.market_dashboard_backend.config.ApplicationConfiguration;

@Component
public class AlphaVantageWebClient {

	private RestTemplate restTemplate;
	private ApplicationConfiguration configuration;

	public AlphaVantageWebClient(@Qualifier("alphaVantageRestTemplate") RestTemplate restTemplate,
			ApplicationConfiguration configuration) {
		this.restTemplate = restTemplate;
		this.configuration = configuration;
	}

	public String getDailyStock(String symbol) {
		String url = configuration.getBaseUrlAlphaVantage() + "?function=TIME_SERIES_DAILY" + "&symbol=" + symbol
				+ "&apikey=" + configuration.getApiKeyAlphaVantage();

		ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);

		return response.getBody();
	}
}
