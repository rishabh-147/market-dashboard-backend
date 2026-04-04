package com.rishabh.projects.market_dashboard_backend.model.alphaVantage.localResponse;

import lombok.Data;

@Data
public class StockPriceDetails{
	private String date;
	private String open;
	private String high;
	private String low;
	private String close;
	private String volume;
}
