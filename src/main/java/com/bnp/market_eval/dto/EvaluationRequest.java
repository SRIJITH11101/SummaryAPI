package com.bnp.market_eval.dto;

import com.bnp.market_eval.model.StockParams;

// This class perfectly matches the structure of the incoming JSON request
public class EvaluationRequest {
    private String stockSymbol;
    private StockParams parameters;

    // Add getters and setters for both fields
    public String getStockSymbol() {
        return stockSymbol;
    }

    public void setStockSymbol(String stockSymbol) {
        this.stockSymbol = stockSymbol;
    }

    public StockParams getParameters() {
        return parameters;
    }

    public void setParameters(StockParams parameters) {
        this.parameters = parameters;
    }
}