package com.rishabh.projects.market_dashboard_backend.model.finnHub.localResponse;

import java.io.Serializable;

import lombok.Data;

@Data
public class SearchResponseDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String stockName;
	private String symbol;
	private String exchange;
	
}
