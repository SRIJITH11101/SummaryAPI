package com.bnp.market_eval.service;

import com.bnp.market_eval.dto.Feedback;
import com.bnp.market_eval.dto.MarketEvalResponse;
import com.google.genai.Client;
import com.google.genai.types.GenerateContentResponse;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class GeminiService {

    private final Client googleClient;

    public GeminiService(Client googleClient) {
        this.googleClient = googleClient;
    }

    public MarketEvalResponse generateMarketEvaluation(Feedback feedback) {
        String prompt = buildPrompt(feedback);

        GenerateContentResponse response =
                googleClient.models.generateContent("gemini-2.5-flash", prompt, null);

        MarketEvalResponse result = new MarketEvalResponse();
        result.setSummary(response.text());
        return result;
    }

    private String buildPrompt(Feedback feedback) {
        String feedbackPoints = Stream.of(
                feedback.getPriceEarningsRatio(),
                feedback.getEarningsPerShare(),
                feedback.getDividendYield(),
                feedback.getMarketCap(),
                feedback.getDebtToEquityRatio(),
                feedback.getReturnOnEquity(),
                feedback.getReturnOnAssets(),
                feedback.getCurrentRatio(),
                feedback.getQuickRatio(),
                feedback.getBookValuePerShare()
        ).map(point -> "- " + point)
         .collect(Collectors.joining("\n"));

        return "You are a financial analyst writing a stock report. "
             + "Based on the following ten data points, synthesize them into a single, "
             + "cohesive, and professional summary. "
             + "Group related positive and negative points and create a smooth narrative flow. "
             + "Present the final output as fine-tuned, relevant bullet points "
             + "and highlight the most important aspects clearly.\n\n"
             + "Data Points:\n" + feedbackPoints;
    }
}
