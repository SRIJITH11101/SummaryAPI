package com.bnp.market_eval.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

// --- DTO for building the request TO the Gemini API ---

public class GeminiApiDtos {
    // --- Request Body Structure ---
    public static class GeminiRequest {
        public List<Content> contents;
        public GeminiRequest(String prompt) {
            this.contents = List.of(new Content(List.of(new Part(prompt))));
        }
    }

    // --- Response Body Structure ---
    // Ignores any unexpected fields from the API response
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class GeminiResponse {
        public List<Candidate> candidates;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Candidate {
        public Content content;
    }
}
