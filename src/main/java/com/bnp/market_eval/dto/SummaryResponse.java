package com.bnp.market_eval.dto;

/**
 * Represents the JSON response containing the generated summary.
 */
public class SummaryResponse {

    private String summary;

    public SummaryResponse(String summary) {
        this.summary = summary;
    }

    // --- Getters and Setters ---
    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }
}
