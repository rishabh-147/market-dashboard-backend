package com.rishabh.projects.market_dashboard_backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.web.client.RestTemplate;

import com.rishabh.projects.market_dashboard_backend.config.ApplicationConfiguration;
import com.rishabh.projects.market_dashboard_backend.model.dto.StockResponseDTO;
import com.rishabh.projects.market_dashboard_backend.webClients.FinnhubClient;

/**
 * Service layer responsible for business logic related to stocks.
 *
 * <p>
 * This class coordinates between controllers and external API clients. It also
 * serves as the correct place for:
 * </p>
 * <ul>
 * <li>Business validations</li>
 * <li>Error handling and interpretation</li>
 * <li>Fallback strategies (future)</li>
 * </ul>
 */
@Service
public class StockService {

	
	private final FinnhubClient finnhubClient;

	public StockService(FinnhubClient finnhubClient) {
		this.finnhubClient = finnhubClient;
	}

	public StockResponseDTO getSearchResults(String symbol) {

		StockResponseDTO response = finnhubClient.getSearchResults(symbol);

		if (ObjectUtils.isEmpty(response)) {
			// 🔥 This is where error interpretation should go
			throw new RuntimeException("Failed to \"getSearchResults\" fetch stock data from Finnhub");
		}

		return response;
	}
}
