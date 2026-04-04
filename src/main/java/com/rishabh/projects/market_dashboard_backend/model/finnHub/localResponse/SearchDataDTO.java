package com.rishabh.projects.market_dashboard_backend.model.finnHub.localResponse;

import lombok.Data;

@Data
public class SearchDataDTO {
	private String stockName;
	private String symbol;
	private String exchangeName;
}
