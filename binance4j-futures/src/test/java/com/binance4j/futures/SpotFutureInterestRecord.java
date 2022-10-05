package com.binance4j.futures;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.text.DecimalFormat;

/**
 * <p> @Date : 2022/10/5 </p>
 * <p> @Project : binance4j</p>
 *
 * <p> @author konbluesky </p>
 */
@Data
@Slf4j
public class SpotFutureInterestRecord {

    private static DecimalFormat df = new DecimalFormat("0.00000000");

    private String symbol;//交易对

    private double spotPrice; //现货价格

    private double spotAskFirst;//现货卖一价格

    private double futurePrice;//合约价格

    private double futureFundingRate;//合约资金费率

    private double futureAskFirst;//合约卖一价格

    private double dailyInterestRate;//杠杆利率

    private double spotFutureDiffThreshold;//现期差价阈值

    private double interestRateSpreadThreshold;// 套利阈值

    private double fundingRateThreshold;

    public boolean spotFutureMatch() {
        double absSFDiff = Math.abs(getSpotFutureDiff() / spotPrice);
        if (absSFDiff > spotFutureDiffThreshold) {
            log.info("Symbol: {} \t Spot Price: {}, \t Futures Price: {} \t Diff Price: {} ", symbol, df.format(spotPrice), df.format(futurePrice), df.format(absSFDiff));
        }
        return absSFDiff > spotFutureDiffThreshold;
    }

    public double getSpotFutureDiff() {
        return spotPrice - futurePrice;
    }

    public boolean orderBookMatch() {
        boolean result = spotAskFirst > futureAskFirst;
        if (result) {
            log.info("Spot Ask First : {} ,Future Ask First : {}", df.format(spotAskFirst), df.format(futureAskFirst));
        }
        return result;
    }

    public boolean fundingRateMatch() {
        boolean result = futureFundingRate > fundingRateThreshold;
        if (result) {
            log.info("FundingRate Threshold : {} ,Future Funding Rate : {}", df.format(fundingRateThreshold),df.format(futureFundingRate));
        }
        return result;
    }
}
