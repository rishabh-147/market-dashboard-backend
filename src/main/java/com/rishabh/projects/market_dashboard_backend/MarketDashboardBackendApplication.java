package com.rishabh.projects.market_dashboard_backend;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MarketDashboardBackendApplication {
	
	private static final Logger logger = LoggerFactory.getLogger(MarketDashboardBackendApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(MarketDashboardBackendApplication.class, args);
		logger.info("MarketDashboardBackendApplication has started @ localhost:8080");
	}

}
