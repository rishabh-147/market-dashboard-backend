package com.rishabh.projects.market_dashboard_backend.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.rishabh.projects.market_dashboard_backend.model.finnHub.clientResponse.FinnhubResponseDTO;
import com.rishabh.projects.market_dashboard_backend.webClients.AlphaVantageClient;
import com.rishabh.projects.market_dashboard_backend.webClients.FinnhubClient;

import tools.jackson.databind.ObjectMapper;

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

	private final Logger logger = LoggerFactory.getLogger(StockService.class);
	
	private final FinnhubClient finnhubClient;
	private final AlphaVantageClient alphaVantageClient;

	public StockService(FinnhubClient finnhubClient, AlphaVantageClient alphaVantageClient) {
		this.finnhubClient = finnhubClient;
		this.alphaVantageClient = alphaVantageClient;
	}

	public FinnhubResponseDTO getSearchResults(String symbol) {
		logger.info("getSearchResults :: symbol [{}] ",symbol);
		
		FinnhubResponseDTO response = finnhubClient.getSearchResults(symbol);
		
		if (ObjectUtils.isEmpty(response)) {
			// 🔥 This is where error interpretation should go
			logger.error("Failed to \"getSearchResults\" fetch stock[ {} ]data from Finnhub" ,symbol);
			throw new RuntimeException("Failed to \"getSearchResults\" fetch stock data from Finnhub");
		}
		
		logger.info("getSearchResults :: symbol [{}] :: responded ",symbol);
		return response;
	}
	
	public FinnhubResponseDTO getQuote(String symbol) {
		logger.info("getQuote :: For symbol : {}",symbol);
		String jsonResponse = alphaVantageClient.getDailyStock(symbol);
		
		ObjectMapper objectMapper = new ObjectMapper();
		return null;
	}
}
