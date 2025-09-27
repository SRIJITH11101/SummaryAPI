// package com.bnp.market_eval.service;

// import com.bnp.market_eval.dto.Feedback;
// import com.google.cloud.vertexai.VertexAI;
// import com.google.cloud.vertexai.api.GenerateContentResponse;
// import com.google.cloud.vertexai.generativeai.GenerativeModel;
// import com.google.cloud.vertexai.generativeai.ResponseHandler;
// import org.springframework.beans.factory.annotation.Value;
// import org.springframework.stereotype.Service;

// import java.io.IOException;
// import java.util.stream.Collectors;
// import java.util.stream.Stream;

// @Service
// public class GeminiSummaryService {

//     private final String projectId;
//     private final String location;
//     private final String modelName = "gemini-1.5-flash-001"; // Or another model like "gemini-1.5-pro-001"

//     public GeminiSummaryService(
//         @Value("${gemini.project.id}") String projectId,
//         @Value("${gemini.location}") String location) {
//         this.projectId = projectId;
//         this.location = location;
//     }

//     public String generateSummary(Feedback feedback) throws IOException {
        
//         try (VertexAI vertexAI = new VertexAI(projectId, location)) {
//             String promptText = buildPrompt(feedback);

//             GenerativeModel model = new GenerativeModel(modelName, vertexAI);
//             GenerateContentResponse response = model.generateContent(promptText);
            
//             return ResponseHandler.getText(response);
//         }
//     }

//     private String buildPrompt(Feedback feedback) {
//         // Collect all feedback comments into a list
//         String feedbackPoints = Stream.of(
//             feedback.getPriceEarningsRatio(),
//             feedback.getEarningsPerShare(),
//             feedback.getDividendYield(),
//             feedback.getMarketCap(),
//             feedback.getDebtToEquityRatio(),
//             feedback.getReturnOnEquity(),
//             feedback.getReturnOnAssets(),
//             feedback.getCurrentRatio(),
//             feedback.getQuickRatio(),
//             feedback.getBookValuePerShare()
//         ).map(point -> "- " + point) // Format as a bulleted list
//          .collect(Collectors.joining("\n"));

//         // Create the final prompt with clear instructions
//         return "You are a financial analyst writing a stock report. "
//              + "Based on the following ten data points, synthesize them into a single, "
//              + "cohesive, and professional summary paragraph. Group related positive and "
//              + "negative points and create a smooth narrative flow.\n\n"
//              + "Data Points:\n" + feedbackPoints;
//     }
// }