package com.rishabh.projects.market_dashboard_backend.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.rishabh.projects.market_dashboard_backend.model.alphaVantage.clientResponse.AlphaVantageResponse;
import com.rishabh.projects.market_dashboard_backend.model.alphaVantage.localResponse.StockDetailsDTO;
import com.rishabh.projects.market_dashboard_backend.model.finnHub.clientResponse.FinnhubResponseDTO;
import com.rishabh.projects.market_dashboard_backend.model.finnHub.localResponse.SearchResponseDTO;
import com.rishabh.projects.market_dashboard_backend.objectMapper.FinnhubLocalObjectMapper;
import com.rishabh.projects.market_dashboard_backend.objectMapper.VantageLocalObjectMapper;
import com.rishabh.projects.market_dashboard_backend.webClients.AlphaVantageClient;
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

	private final Logger logger = LoggerFactory.getLogger(StockService.class);

	private final FinnhubClient finnhubClient;
	private final AlphaVantageClient alphaVantageClient;
	private final VantageLocalObjectMapper vantageLocalObjectMapper;
	private final FinnhubLocalObjectMapper finnhubLocalObjectMapper;

	public StockService(FinnhubClient finnhubClient, AlphaVantageClient alphaVantageClient,
			VantageLocalObjectMapper vantageLocalObjectMapper, FinnhubLocalObjectMapper finnhubLocalObjectMapper) {
		this.finnhubClient = finnhubClient;
		this.alphaVantageClient = alphaVantageClient;
		this.vantageLocalObjectMapper = vantageLocalObjectMapper;
		this.finnhubLocalObjectMapper = finnhubLocalObjectMapper;
	}

	public SearchResponseDTO getSearchResults(String symbol) {
		logger.info("getSearchResults :: symbol [{}] ", symbol);

		FinnhubResponseDTO response = finnhubClient.getSearchResults(symbol);

		SearchResponseDTO searchResponseDTO = finnhubLocalObjectMapper.mapToSearchResponse(response);

		if (ObjectUtils.isEmpty(searchResponseDTO)) {
			// 🔥 This is where error interpretation should go
			logger.error("Failed to \"getSearchResults\" fetch stock[ {} ]data from Finnhub", symbol);
			throw new RuntimeException("Failed to \"getSearchResults\" fetch stock data from Finnhub");
		}
		logger.info("getSearchResults :: symbol [{}] :: responded ", symbol);

		return searchResponseDTO;
	}

	public StockDetailsDTO getQuote(String symbol, String stockName) {
		logger.info("getQuote :: For symbol : {}", symbol);
		AlphaVantageResponse response = alphaVantageClient.getDailyStock(symbol);

		StockDetailsDTO detailsDTO = vantageLocalObjectMapper.mapToStockDetails(response);
		detailsDTO.setStockName(stockName);

		if (ObjectUtils.isEmpty(detailsDTO)) {
			// 🔥 This is where error interpretation should go
			logger.error("Failed to \"getQuote\" fetch stock[ {} ]data from AlphaVantage", symbol);
			throw new RuntimeException("Failed to \"getQuote\" fetch stock data from AlphaVantage");
		}
		return detailsDTO;
	}
}
