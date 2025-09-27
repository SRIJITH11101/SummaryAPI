package com.bnp.market_eval.dto;

/**
 * Represents the incoming JSON request for generating a summary.
 * It expects a single key "feedback" containing the feedback object.
 */
public class SummaryRequest {

    private Feedback feedback;

    // --- Getters and Setters ---
    public Feedback getFeedback() {
        return feedback;
    }

    public void setFeedback(Feedback feedback) {
        this.feedback = feedback;
    }
}