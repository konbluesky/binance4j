package com.binance4j.futures.dto;

import io.swagger.annotations.ApiModel;

/**
 * <p> @Date : 2022/10/5 </p>
 * <p> @Project : binance4j</p>
 * <p>
 * {
 * "symbol": "BTCUSDT",            // 交易对
 * "markPrice": "11793.63104562",  // 标记价格
 * "indexPrice": "11781.80495970", // 指数价格
 * "estimatedSettlePrice": "11781.16138815",  // 预估结算价,仅在交割开始前最后一小时有意义
 * "lastFundingRate": "0.00038246",    // 最近更新的资金费率
 * "nextFundingTime": 1597392000000,   // 下次资金费时间
 * "interestRate": "0.00010000",       // 标的资产基础利率
 * "time": 1597370495002               // 更新时间
 * }
 *
 * <p> @author konbluesky </p>
 */
@ApiModel("Latest marked prices and capital rates")
public record PremiumIndex(String symbol, String markPrice, String indexPrice, String estimatedSettlePrice, String lastFundingRate, long nextFundingTime,
                           String interestRate, long time) {

    public double absLastFundingRate() {
        return Math.abs(Double.parseDouble(lastFundingRate));
    }
}
