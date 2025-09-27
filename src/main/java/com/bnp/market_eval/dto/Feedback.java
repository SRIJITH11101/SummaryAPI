package com.bnp.market_eval.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Feedback {

    private String priceEarningsRatio;
    private String earningsPerShare;
    private String dividendYield;
    private String marketCap;
    private String debtToEquityRatio;
    private String returnOnEquity;
    private String returnOnAssets;
    private String currentRatio;
    private String quickRatio;
    private String bookValuePerShare;

}
