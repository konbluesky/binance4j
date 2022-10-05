package com.binance4j.futures.param;

import com.binance4j.core.annotation.Param;
import com.binance4j.core.param.Params;

/**
 *
 * @param symbol
 * @param limit
 */
@Param(recvWindow = false, timestamp = false)
public record DepthParams(String symbol, String limit) implements Params {

    /**
     * Creates an instance of {@link DepthParams}
     *
     * @param symbol Trading pair we want the depth.
     * @param limit  Market depth size.
     */
    public DepthParams(String symbol, String limit) {
        this.symbol = symbol;
        this.limit = limit;
    }

    /**
     * Creates an instance of {@link DepthParams}.
     *
     * @param symbol Trading pair we want the depth.
     */
    public DepthParams(String symbol) {
        this(symbol, "100");
    }

    /**
     * Creates an instance of {@link DepthParams}.
     *
     * @param symbol Trading pair we want the depth.
     * @param limit  Order book limit.
     */
    public DepthParams(String symbol, DepthLimit limit) {
        this(symbol, limit.toString());
    }
}
