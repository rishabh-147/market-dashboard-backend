package com.rishabh.projects.market_dashboard_backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rishabh.projects.market_dashboard_backend.service.StockService;

@RestController
@RequestMapping("/v1/stock")
public class StockController {
	
	@Autowired
	private StockService stockService;
	@GetMapping("/search")
	public ResponseEntity<?> test(@RequestBody String symbol) {
		return stockService.probableSearch("INF");
	}

}
