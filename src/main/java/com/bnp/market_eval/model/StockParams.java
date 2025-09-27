package com.bnp.market_eval.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StockParams {

    private double priceEarningsRatio;
    private double earningsPerShare;
    private double dividendYield;
    private double marketCap;
    private double debtToEquityRatio;
    private double returnOnEquity;
    private double returnOnAssets;
    private double currentRatio;
    private double quickRatio;
    private double bookValuePerShare;

}
