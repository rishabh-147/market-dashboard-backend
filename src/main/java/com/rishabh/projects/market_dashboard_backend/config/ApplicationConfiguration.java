package com.rishabh.projects.market_dashboard_backend.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration

public class ApplicationConfiguration {
//	Token
	@Value("${token_finnhub}")
	private String apiKeyFinnhub;
	@Value("${token_alpha_vantage}")
	private String apiKeyAlphaVantage;

// Base URLs
	@Value("${base_url_finnhub}")
	private String baseUrlFinnhub;
	@Value("${base_url_alpha_vantage}")
	private String baseUrlAlphaVantage;
//End points
//	private  String ENDPOINT_FINNHUB_SEARCH_SYMBOL = "search?q=";

//Constants
//	private  String CONSTANT_FINNHUB_NSE_EXCHANGE = "&exchange=NS";

	public String getApiKeyFinnhub() {
		return apiKeyFinnhub;
	}

	public String getApiKeyAlphaVantage() {
		return apiKeyAlphaVantage;
	}

	public String getBaseUrlFinnhub() {
		return baseUrlFinnhub;
	}

	public String getBaseUrlAlphaVantage() {
		return baseUrlAlphaVantage;
	}
}
