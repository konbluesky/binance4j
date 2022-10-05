package com.binance4j.futures.client.mapping;

import com.binance4j.core.client.RestMapping;
import com.binance4j.futures.dto.ExchangeInfo;
import com.binance4j.futures.dto.OrderBook;
import com.binance4j.futures.dto.ServerTimeResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.QueryMap;

import java.util.Map;

/**
 * <p> @Date : 2022/9/26 </p>
 * <p> @Project : binance4j</p>
 *
 * <p> @author konbluesky </p>
 */
public interface MarketMapping extends RestMapping {

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
     * @return The generated Retrofit call.
     */
    @GET(BASE + "depth")
    @Headers({ IP_H, "X-WEIGHT: 50" })
    Call<OrderBook> getOrderBook(@QueryMap Map<String, Object> map);

}
