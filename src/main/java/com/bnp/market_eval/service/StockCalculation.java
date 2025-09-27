// package com.bnp.market_eval.service;

// import com.bnp.market_eval.dto.Feedback;
// import com.bnp.market_eval.dto.MarketEvalResponse;
// import com.bnp.market_eval.model.StockParams;
// import org.springframework.stereotype.Service;

// import java.util.List;
// import java.util.Map;
// import java.util.stream.Collectors;

// @Service
// public class StockCalculation {
//     private final Feedback feedback;
//     public StockCalculation() {
//         this.feedback = new Feedback();
//     }


//     /**
//      * Main method to process the stock evaluation request.
//      */
//     public MarketEvalResponse calculate(String stockSymbol, StockParams params) {
        

//         // 1. Run each rule and populate the feedback object
//         feedback.setPriceEarningsRatio(calcPriceEarningsRatio(params.getPriceEarningsRatio()));
//         feedback.setEarningsPerShare(calcEarningsPerShare(params.getEarningsPerShare()));
//         feedback.setDividendYield(calcDividendYield(params.getDividendYield()));
//         feedback.setMarketCap(calcMarketCap(params.getMarketCap()));
//         feedback.setDebtToEquityRatio(calcDebtToEquityRatio(params.getDebtToEquityRatio()));
//         feedback.setReturnOnEquity(calcReturnOnEquity(params.getReturnOnEquity()));
//         feedback.setReturnOnAssets(calcReturnOnAssets(params.getReturnOnAssets()));
//         feedback.setCurrentRatio(calcCurrentRatio(params.getCurrentRatio()));
//         feedback.setQuickRatio(calcQuickRatio(params.getQuickRatio()));
//         feedback.setBookValuePerShare(calcBookValuePerShare(params.getBookValuePerShare()));

//         // 2. Create the summary paragraph
//         String summary = createSummary(feedback);
        
//         // 3. Assemble the final response
//         MarketEvalResponse response = new MarketEvalResponse();
//         response.setStockSymbol(stockSymbol);
//         response.setFeedback(feedback);
//         response.setSummary(summary);

//         return response;
//     }
    
//     private String calcPriceEarningsRatio(double value) {
//         if (value < 15) {
//             return String.format("The P/E ratio of %.2f suggests the stock is cheap relative to earnings.", value);
//         } else if (value <= 30) {
//             return String.format("The P/E ratio of %.2f is fairly typical.", value);
//         } else {
//             return String.format("The P/E ratio of %.2f indicates the stock is relatively expensive compared to its earnings.", value);
//         }
//     }

//     private String calcEarningsPerShare(double value) {
//         if (value < 1) {
//             return String.format("The EPS of %.2f is low; profitability may be a concern.", value);
//         } else if (value < 5) {
//             return String.format("The EPS of %.2f shows modest profitability.", value);
//         } else {
//             return String.format("The EPS of %.2f is a strong indicator of the company's profitability.", value);
//         }
//     }

//     private String calcDividendYield(double value) {
//         if (value < 1) {
//             return String.format("The dividend yield of %.2f%% is lower than the market average.", value);
//         } else if (value <= 3) {
//             return String.format("The dividend yield of %.2f%% is around the market norm.", value);
//         } else {
//             return String.format("The dividend yield of %.2f%% is attractive for income-focused investors.", value);
//         }
//     }

//     private String calcMarketCap(double value) {
//         long trillion = 1_000_000_000_000L;
//         double valueInTrillions = value / trillion;

//         if (value >= 500 * trillion) {
//             return String.format("The market cap of $%.2f trillion makes it one of the world’s giants.", valueInTrillions);
//         } else if (value >= 100 * trillion) {
//             return String.format("The market cap of $%.2f trillion indicates a very large, stable company.", valueInTrillions);
//         } else {
//             return String.format("The market capitalization of $%.2f trillion indicates a sizable player.", valueInTrillions);
//         }
//     }

//     private String calcDebtToEquityRatio(double value) {
//         if (value < 0.5) {
//             return String.format("The debt-to-equity ratio of %.2f suggests very little leverage.", value);
//         } else if (value <= 1.5) {
//             return String.format("The debt-to-equity ratio of %.2f suggests a moderate level of leverage.", value);
//         } else {
//             return String.format("The debt-to-equity ratio of %.2f indicates high leverage; watch for risk.", value);
//         }
//     }

//     private String calcReturnOnEquity(double value) {
//         double pct = value * 100;
//         if (pct < 8) {
//             return String.format("The ROE of %.2f%% is below average.", pct);
//         } else if (pct <= 15) {
//             return String.format("The ROE of %.2f%% is healthy.", pct);
//         } else {
//             return String.format("The ROE of %.2f%% is very strong, showing efficient profit generation.", pct);
//         }
//     }

//     private String calcReturnOnAssets(double value) {
//         double pct = value * 100;
//         if (pct < 5) {
//             return String.format("The ROA of %.2f%% is modest.", pct);
//         } else if (pct <= 10) {
//             return String.format("The ROA of %.2f%% indicates efficient asset utilization.", pct);
//         } else {
//             return String.format("The ROA of %.2f%% is excellent, showing superb asset productivity.", pct);
//         }
//     }

//     private String calcCurrentRatio(double value) {
//         if (value < 1) {
//             return String.format("The current ratio of %.2f signals potential short-term liquidity issues.", value);
//         } else if (value <= 2) {
//             return String.format("The current ratio of %.2f suggests the company has a good short-term liquidity position.", value);
//         } else {
//             return String.format("The current ratio of %.2f indicates a very comfortable liquidity cushion.", value);
//         }
//     }

//     private String calcQuickRatio(double value) {
//         if (value < 1) {
//             return String.format("The quick ratio of %.2f may be insufficient for immediate obligations.", value);
//         } else if (value <= 2) {
//             return String.format("The quick ratio of %.2f indicates a strong ability to meet short-term obligations.", value);
//         } else {
//             return String.format("The quick ratio of %.2f shows an exceptionally strong liquidity position.", value);
//         }
//     }

//     private String calcBookValuePerShare(double value) {
//         return String.format("The book value per share of %.2f is a measure of the company's net asset value on a per-share basis.", value);
//     }
    
//     /**
//      * Creates a summary paragraph from the feedback object.
//      * Note: This assumes you have a Feedback object with appropriate getter methods.
//      */
//     private String createSummary(Feedback feedback) {
//         // This list determines the sequence of sentences in the final paragraph.
//         return List.of(
//                     feedback.getPriceEarningsRatio(),
//                     feedback.getEarningsPerShare(),
//                     feedback.getReturnOnEquity(),
//                     feedback.getReturnOnAssets(),
//                     feedback.getCurrentRatio(),
//                     feedback.getQuickRatio(),
//                     feedback.getDebtToEquityRatio(),
//                     feedback.getDividendYield(),
//                     feedback.getMarketCap()
//                 )
//                 .stream()
//                 .collect(Collectors.joining(" "));
//     }
// }