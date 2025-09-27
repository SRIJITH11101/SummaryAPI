package com.bnp.market_eval.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Main application configuration class.
 * This class provides bean definitions for the Spring application context.
 */
@Configuration
public class AppConfig {

    /**
     * Defines a RestTemplate bean to be used for making HTTP requests.
     * Spring will manage this bean and inject it wherever it's needed,
     * such as in the SummaryController.
     *
     * @return A new instance of RestTemplate.
     */
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}

