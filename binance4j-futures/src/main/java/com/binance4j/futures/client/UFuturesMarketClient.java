package com.binance4j.futures.client;

import com.binance4j.core.Request;
import com.binance4j.futures.client.mapping.UMarketMapping;
import com.binance4j.futures.dto.*;
import com.binance4j.futures.param.*;

import java.util.List;

/**
 * <p> @Date : 2022/9/26 </p>
 * <p> @Project : binance4j</p>
 *
 * <p> @author konbluesky </p>
 */
public class UFuturesMarketClient extends BaseUFuturesClient<UMarketMapping> {

    public UFuturesMarketClient(String key, String secret) {
        super(UMarketMapping.class, key, secret);
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

    public Request<PriceTicker> getTicker(PriceTickerParams params) {
        return new Request<>(service.getTicker(params.toMap()));
    }

    public Request<List<PriceTicker>> getTickers() {
        return new Request<>(service.getTicker());
    }


    /**
     * Get older market trades.
     *
     * @param params Request params.
     * @return The request to execute.
     */
    public Request<List<Trade>> getHistoricalTrades(HistoricalTradesParams params) {
        return new Request<>(service.getHistoricalTrades(params.toMap()));
    }

    /**
     * Get compressed, aggregate trades. Trades that fill at the time, from the same
     * order, with the same price will have
     * the quantity aggregated.
     * <p>
     * If {@code startTime}, and {@code endTime} are sent, time between startTime
     * and endTime must be less than 1 hour.
     * <p>
     * If {@code fromId}, {@code startTime}, and {@code endTime} are not sent, the
     * most recent aggregate trades will be
     * returned.
     *
     * @param params Request params.
     * @return The request to execute.
     */
    public Request<List<AggTrade>> getAggTrades(AggTradeParams params) {
        return new Request<>(service.getAggTrades(params.toMap()));
    }
}
