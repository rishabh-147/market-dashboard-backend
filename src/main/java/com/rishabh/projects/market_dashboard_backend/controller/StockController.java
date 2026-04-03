package com.rishabh.projects.market_dashboard_backend.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rishabh.projects.market_dashboard_backend.service.StockService;

@RestController
@RequestMapping("/v1/stock")
public class StockController {
	
	
	private final StockService stockService;
	
	public StockController(StockService stockService) {
	    this.stockService = stockService;
	}
	
	@GetMapping("/search")
	public ResponseEntity<?> test() {
		return ResponseEntity.ok(stockService.getSearchResults("INF"));
	}

}
