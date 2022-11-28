package com.binance4j.futures.client.mapping;

import com.binance4j.core.client.RestMapping;
import com.binance4j.futures.dto.*;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.QueryMap;

import java.util.List;
import java.util.Map;

/**
 * <p> @Date : 2022/9/26 </p>
 * <p> @Project : binance4j</p>
 *
 * <p> @author konbluesky </p>
 */
public interface UMarketMapping extends RestMapping {

    /** Base uri */
    String BASE = "/fapi/v1/";

    /**
     * @return The generated Retrofit call.
     */
    @GET(BASE + "ping")
    @Headers({ IP_H, WEIGHT_ONE_H })
    Call<Void> ping();

    /**
     * @return The generated Retrofit call.
     */
    @GET(BASE + "time")
    @Headers({ IP_H, WEIGHT_ONE_H })
    Call<ServerTimeResponse> getServerTime();

    /**
     * @return The generated Retrofit call.
     */
    @GET(BASE + "exchangeInfo")
    @Headers({ IP_H, WEIGHT_ONE_H })
    Call<ExchangeInfo> getExchangeInfo();

    /**
     * @param map Query map.
     *
     * @return The generated Retrofit call.
     */
    @GET(BASE + "depth")
    @Headers({ IP_H, "X-WEIGHT: 50" })
    Call<OrderBook> getOrderBook(@QueryMap Map<String, Object> map);

    /**
     * @param map Query map.
     *
     * @return The generated Retrofit call.
     */
    @GET(BASE + "premiumIndex")
    @Headers({ IP_H, WEIGHT_ONE_H })
    Call<PremiumIndex> premiumIndex(@QueryMap Map<String, Object> map);

    /**
     * @return The generated Retrofit call.
     */
    @GET(BASE + "ticker/price")
    @Headers({ IP_H, "X-WEIGHT: 2" })
    Call<List<PriceTicker>> getTicker();


    /**
     * @param map Query map.
     *
     * @return The generated Retrofit call.
     */
    @GET(BASE + "ticker/price")
    @Headers({ IP_H, WEIGHT_ONE_H })
    Call<PriceTicker> getTicker(@QueryMap Map<String, Object> map);


    /**
     * @param map Query map.
     * @return The generated Retrofit call.
     */
    @GET(BASE + "historicalTrades")
    @Headers({ API_H, IP_H, "X-WEIGHT: 50" })
    Call<List<Trade>> getHistoricalTrades(@QueryMap Map<String, Object> map);

    /**
     * @param map Query map.
     * @return The generated Retrofit call.
     */
    @GET(BASE + "aggTrades")
    @Headers({ IP_H, "X-WEIGHT: 50" })
    Call<List<AggTrade>> getAggTrades(@QueryMap Map<String, Object> map);



}
