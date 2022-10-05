package com.binance4j.futures.client;

import com.binance4j.core.Request;
import com.binance4j.futures.client.mapping.BMarketMapping;
import com.binance4j.futures.client.mapping.UMarketMapping;
import com.binance4j.futures.dto.ExchangeInfo;
import com.binance4j.futures.dto.OrderBook;
import com.binance4j.futures.dto.PremiumIndex;
import com.binance4j.futures.dto.ServerTimeResponse;
import com.binance4j.futures.param.OrderBookParams;
import com.binance4j.futures.param.PremiumIndexParams;

/**
 * <p> @Date : 2022/9/26 </p>
 * <p> @Project : binance4j</p>
 *
 * <p> @author konbluesky </p>
 */
public class BFuturesMarketClient extends BaseUFuturesClient<BMarketMapping> {

    public BFuturesMarketClient(String key, String secret) {
        super(BMarketMapping.class, key, secret);
    }

    /**
     * @return The generated Retrofit call
     */
    public Request<Void> ping() {
        return new Request<>(service.ping());
    }

    /**
     * @return The generated Retrofit call
     */
    public Request<ServerTimeResponse> getServerTime() {
        return new Request<>(service.getServerTime());
    }

    /**
     * @return The generated Retrofit call
     */
    public Request<ExchangeInfo> getExchangeInfo() {
        return new Request<>(service.getExchangeInfo());
    }

    /**
     * Get the symbol order book.
     *
     * @param params Request params.
     *
     * @return The request to execute.
     */
    public Request<OrderBook> getOrderBook(OrderBookParams params) {
        return new Request<>(service.getOrderBook(params.toMap()));
    }

    public Request<PremiumIndex> premiumIndex(PremiumIndexParams params) {
        return new Request<>(service.premiumIndex(params.toMap()));
    }
}
