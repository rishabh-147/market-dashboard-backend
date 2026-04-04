package com.rishabh.projects.market_dashboard_backend.model.finnHub.localResponse;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class SearchResponseDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public SearchResponseDTO() {
		this.count = 0;
		this.searchResult = new ArrayList<SearchDataDTO>();
	}
	
	private int count;
	private List<SearchDataDTO> searchResult;
}
