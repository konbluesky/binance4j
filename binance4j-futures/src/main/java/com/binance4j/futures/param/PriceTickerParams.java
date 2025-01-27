package com.binance4j.futures.param;

import com.binance4j.core.annotation.Param;
import com.binance4j.core.param.Params;
import com.binance4j.futures.client.UFuturesMarketClient;
/**
 * {@link UFuturesMarketClient#getTicker} params.
 * 
 * @param symbol Symbol.
 */
@Param(weight = 2, recvWindow = false, timestamp = false)
public record PriceTickerParams(String symbol) implements Params {

}