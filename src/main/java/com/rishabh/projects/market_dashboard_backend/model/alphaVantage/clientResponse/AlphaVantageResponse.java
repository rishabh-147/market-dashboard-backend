package com.rishabh.projects.market_dashboard_backend.model.alphaVantage.clientResponse;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class AlphaVantageResponse {
	@JsonProperty("Meta Data")
	private MetaData metaData;

	@JsonProperty("Time Series (Daily)")
	private Map<String, DailyData> timeSeries;

}
