package com.rishabh.projects.market_dashboard_backend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StockController {
	
	@GetMapping("/test")
	public String test() {
		return "Backend is working";
	}

}
