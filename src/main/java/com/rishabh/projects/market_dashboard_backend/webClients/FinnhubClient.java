package com.rishabh.projects.market_dashboard_backend.webClients;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.rishabh.projects.market_dashboard_backend.config.ApplicationConfiguration;
import com.rishabh.projects.market_dashboard_backend.model.finnHub.clientResponse.FinnhubResponseDTO;


/**
 * Client class responsible for interacting with the Finnhub API.
 *
 * <p>
 * This class acts as the communication layer between the service layer and the
 * external Finnhub API. It is responsible only for:
 * </p>
 * <ul>
 * <li>Building request URLs</li>
 * <li>Making HTTP calls</li>
 * <li>Mapping responses to DTOs</li>
 * </ul>
 *
 * <p>
 * <b>Design Notes:</b>
 * </p>
 * <ul>
 * <li>Authentication is currently handled via query parameter (token)</li>
 * <li>Future enhancement: Move token handling to a RestTemplate
 * interceptor</li>
 * <li>This class does NOT handle business logic or error interpretation</li>
 * </ul>
 */
@Component
public class FinnhubClient {
	
	private static final Logger logger = LoggerFactory.getLogger(FinnhubClient.class);

	private final RestTemplate restTemplate;

	private final ApplicationConfiguration config;

	public FinnhubClient(@Qualifier("finnhubRestTemplate") RestTemplate restTemplate, ApplicationConfiguration config) {
		this.restTemplate = restTemplate;
		this.config = config;
	}

	public FinnhubResponseDTO getSearchResults(String symbol) {

		String url = UriComponentsBuilder.fromUriString(config.getBaseUrlFinnhub() + "search").queryParam("q", symbol)
				.queryParam("exchange", "NS").queryParam("token", config.getApiKeyFinnhub()).toUriString();
		
		logger.info("FinnhubClient :: URL [{}] ",url);
		
		FinnhubResponseDTO response = restTemplate.getForObject(url, FinnhubResponseDTO.class);
		
		logger.info("FinnhubClient :: Fetch successful ::  ");
		
		return response;
	}
}