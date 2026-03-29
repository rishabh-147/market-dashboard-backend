package com.rishabh.projects.market_dashboard_backend.model.dto;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class StockResponseDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	

	private int count;
	private List<ResultItem> result;
	
	@Data
	public static class ResultItem {
		private String description;
		private String displaySymbol;
		private String symbol;
		private String type;
	}

}
