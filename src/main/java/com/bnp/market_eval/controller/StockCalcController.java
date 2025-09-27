// package com.bnp.market_eval.controller;

// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;

// import com.bnp.market_eval.dto.EvaluationRequest;
// import com.bnp.market_eval.dto.MarketEvalResponse;
// import com.bnp.market_eval.model.StockParams;
// import com.bnp.market_eval.service.StockCalculation;

// @RestController
// @RequestMapping("/api/stocks")
// public class StockCalcController {

//     private final StockCalculation stockCalc;
//     public StockCalcController(StockCalculation stockCalc) {
//         this.stockCalc = stockCalc;
//     }

//      @PostMapping("/evaluate") // 3. Use POST for sending data
//     public MarketEvalResponse evaluateStock(@RequestBody EvaluationRequest request) { // 4. Use @RequestBody on the new DTO
        
//         // 5. Call the injected service instance
//         return stockCalc.calculate(
//             request.getStockSymbol(),
//             request.getParameters()
//         );
//     }

// }
