package com.bnp.market_eval.controller;

import com.bnp.market_eval.dto.Feedback;
import com.bnp.market_eval.dto.MarketEvalResponse;
import com.bnp.market_eval.service.GeminiService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/summary")
public class GeminiController {

    private final GeminiService geminiService;

    public GeminiController(GeminiService geminiService) {
        this.geminiService = geminiService;
    }


    // New feedback-based summary
    @PostMapping("/feedback")
    public MarketEvalResponse generateFromFeedback(@RequestBody Feedback feedback) {
        return geminiService.generateMarketEvaluation(feedback);
    }
}
