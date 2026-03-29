package com.rishabh.projects.market_dashboard_backend.service;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.rishabh.projects.market_dashboard_backend.config.ApplicationConfiguration;
import com.rishabh.projects.market_dashboard_backend.model.dto.StockResponseDTO;

@Service
public class StockService {
	public ResponseEntity<?> probableSearch(String symbol) {
		String URI = ApplicationConfiguration.BASE_URL_FINNHUB
				.concat(ApplicationConfiguration.ENDPOINT_FINNHUB_SEARCH_SYMBOL).concat(symbol).concat(ApplicationConfiguration.CONSTANT_FINNHUB_NSE_EXCHANGE)
				.concat(ApplicationConfiguration.TOKEN_FINNHUB);
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<StockResponseDTO> response = restTemplate.getForEntity(URI, StockResponseDTO.class);

		HttpStatusCode statusCode = response.getStatusCode();
		if (statusCode.is2xxSuccessful()) {
			System.out.println("Response Successful :: "+response.toString());
			
		} else {	
			System.out.println("Response Failed!");
		}
		return response;
	}
}
