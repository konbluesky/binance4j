package com.binance4j.futures.param;

import com.binance4j.core.annotation.Param;
import com.binance4j.core.param.Params;
import com.binance4j.futures.client.UFuturesMarketClient;
import com.binance4j.futures.dto.OrderBookLimit;

/**
 * {@link UFuturesMarketClient#getOrderBook} params.
 *
 * @param symbol Trading pair we want the depth.
 * @param limit  Market depth size.
 */
@Param(recvWindow = false, timestamp = false)
public record OrderBookParams(String symbol, String limit) implements Params {

    /**
     * Creates an instance of {@link OrderBookParams}.
     *
     * @param symbol Trading pair we want the depth.
     * @param limit  Market depth size.
     */
    public OrderBookParams(String symbol, String limit) {
        this.symbol = symbol;
        this.limit = limit;
    }

    /**
     * Creates an instance of {@link OrderBookParams}.
     *
     * @param symbol Trading pair we want the depth.
     */
    public OrderBookParams(String symbol) {
        this(symbol, "100");
    }

    /**
     * Creates an instance of {@link OrderBookParams}.
     *
     * @param symbol Trading pair we want the depth.
     * @param limit  Order book limit.
     */
    public OrderBookParams(String symbol, OrderBookLimit limit) {
        this(symbol, limit.toString());
    }
}