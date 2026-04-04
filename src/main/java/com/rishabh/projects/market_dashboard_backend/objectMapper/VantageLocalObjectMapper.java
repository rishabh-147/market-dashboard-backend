package com.rishabh.projects.market_dashboard_backend.objectMapper;

import java.util.List;

import org.springframework.stereotype.Component;

import com.rishabh.projects.market_dashboard_backend.model.alphaVantage.clientResponse.AlphaVantageResponse;
import com.rishabh.projects.market_dashboard_backend.model.alphaVantage.clientResponse.DailyData;
import com.rishabh.projects.market_dashboard_backend.model.alphaVantage.localResponse.StockDetailsDTO;
import com.rishabh.projects.market_dashboard_backend.model.alphaVantage.localResponse.StockPriceDetails;

@Component
public class VantageLocalObjectMapper {
	public StockDetailsDTO mapToStockDetails(AlphaVantageResponse response) {

	    StockDetailsDTO dto = new StockDetailsDTO();

	    // Meta Data
	    dto.setSymbol(response.getMetaData().getSymbol());
	    dto.setLastRefresh(response.getMetaData().getLastRefreshed());

	    // Time Series → List
	    List<StockPriceDetails> priceList = response.getTimeSeries()
	            .entrySet()
	            .stream()
	            .map(entry -> {
	                String date = entry.getKey();
	                DailyData data = entry.getValue();

	                StockPriceDetails price = new StockPriceDetails();
	                price.setDate(date);
	                price.setOpen(data.getOpen());
	                price.setHigh(data.getHigh());
	                price.setLow(data.getLow());
	                price.setClose(data.getClose());
	                price.setVolume(data.getVolume());

	                return price;
	            })
	            // Important for frontend (latest first)
	            .sorted((a, b) -> b.getDate().compareTo(a.getDate()))
	            .toList();

	    dto.setPriceDetails(priceList);

	    return dto;
	}
}
