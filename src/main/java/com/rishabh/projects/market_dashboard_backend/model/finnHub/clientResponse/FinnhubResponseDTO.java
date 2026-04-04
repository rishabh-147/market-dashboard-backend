package com.rishabh.projects.market_dashboard_backend.model.finnHub.clientResponse;

import java.util.List;

import lombok.Data;

@Data
public class FinnhubResponseDTO {	

	private int count;
	private List<ResultItem> result;
	

}
