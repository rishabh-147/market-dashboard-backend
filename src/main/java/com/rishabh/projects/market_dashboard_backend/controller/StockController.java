package com.rishabh.projects.market_dashboard_backend.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rishabh.projects.market_dashboard_backend.service.StockService;

@RestController
@RequestMapping("/v1/stock")
public class StockController {

	private final StockService stockService;
	private final Logger logger = LoggerFactory.getLogger(StockController.class);

	public StockController(StockService stockService) {
		this.stockService = stockService;
	}

	@GetMapping("/search/{symbol}")
	public ResponseEntity<?> search(@PathVariable("symbol") String symbol) {
		logger.info(":: /search/{} :: ", symbol);
		return ResponseEntity.ok(stockService.getSearchResults(symbol));
	}

	@GetMapping("/quote/{symbol}")
	public ResponseEntity<?> quote(@PathVariable("symbol") String symbol) {
		logger.info(":: /quote/{} :: ", symbol);
		return ResponseEntity.ok(stockService.getQuote(symbol));
	}

}
