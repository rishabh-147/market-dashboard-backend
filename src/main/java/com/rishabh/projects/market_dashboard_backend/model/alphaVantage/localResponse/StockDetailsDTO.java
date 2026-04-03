package com.rishabh.projects.market_dashboard_backend.model.alphaVantage.localResponse;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class StockDetailsDTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String symbol;
	private String lastRefresh;

	private List<StockPriceDetails> priceDetails;
}

@Data
class StockPriceDetails{
	private String date;
	private String open;
	private String high;
	private String low;
	private String close;
	private String volume;
}
