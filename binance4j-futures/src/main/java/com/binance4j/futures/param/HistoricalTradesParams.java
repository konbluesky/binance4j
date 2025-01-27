package com.binance4j.futures.param;

import com.binance4j.core.annotation.Param;
import com.binance4j.core.param.Params;
import com.binance4j.futures.client.UFuturesMarketClient;
/**
 * {@link UFuturesMarketClient#getHistoricalTrades} params.
 * 
 * @param symbol Trading pair to get the trades.
 * @param limit  Default 500; max 1000.
 * @param fromId Trade id to fetch from. Default gets most recent trades.
 */
@Param(weight = 20, recvWindow = false, timestamp = false)
public record HistoricalTradesParams(String symbol, Integer limit, Long fromId) implements Params {
	/**
	 * Creates an instance of {@link HistoricalTradesParams}.
	 * 
	 * @param symbol Trading pair to get the trades.
	 */
	public HistoricalTradesParams(String symbol) {
		this(symbol, null, null);
	}

	/**
	 * Creates an instance of {@link HistoricalTradesParams}.
	 * 
	 * @param symbol Trading pair to get the trades.
	 * @param limit  Default 500; max 1000.
	 */
	public HistoricalTradesParams(String symbol, Integer limit) {
		this(symbol, limit, null);
	}

	/**
	 * Creates an instance of {@link HistoricalTradesParams}.
	 * 
	 * @param symbol Trading pair to get the trades.
	 * @param fromId Trade id to fetch from. Default gets most recent trades.
	 */
	public HistoricalTradesParams(String symbol, Long fromId) {
		this(symbol, null, fromId);
	}
}