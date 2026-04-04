package com.rishabh.projects.market_dashboard_backend.objectMapper;

import org.springframework.stereotype.Component;

import com.rishabh.projects.market_dashboard_backend.model.finnHub.clientResponse.FinnhubResponseDTO;
import com.rishabh.projects.market_dashboard_backend.model.finnHub.localResponse.SearchDataDTO;
import com.rishabh.projects.market_dashboard_backend.model.finnHub.localResponse.SearchResponseDTO;

@Component
public class FinnhubLocalObjectMapper {

	public SearchResponseDTO mapToSearchResponse(FinnhubResponseDTO finnhubResponseDTO) {

		SearchResponseDTO searchResponseDTO = new SearchResponseDTO();
		
		searchResponseDTO.setCount(finnhubResponseDTO.getCount());
		finnhubResponseDTO.getResult()
		.forEach(r -> {
			SearchDataDTO data = new SearchDataDTO();
			String exchangeSymbol = r.getSymbol().substring(r.getSymbol().indexOf(".")+1);
			
			
			data.setExchangeName(exchangeSymbol.equals("NS")?"NSE":null);
			data.setStockName(r.getDescription());
			data.setSymbol(r.getSymbol().substring(0, r.getSymbol().indexOf(".")));
			searchResponseDTO.getSearchResult().add(data);
		});

		return searchResponseDTO;

	}
}
