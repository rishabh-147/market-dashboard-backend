package com.rishabh.projects.market_dashboard_backend.model.finnHub.clientResponse;

import lombok.Data;

@Data
public class ResultItem {
	private String description;
	private String displaySymbol;
	private String symbol;
	private String type;
}
