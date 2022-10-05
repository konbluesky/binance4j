package com.binance4j.futures.client;

import com.binance4j.core.client.RestClient;
import com.binance4j.core.interceptor.AuthenticationInterceptor;
import com.binance4j.core.interceptor.MetaHeadersInterceptor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import okhttp3.Dispatcher;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

/**
 * <p> @Date : 2022/10/5 </p>
 * <p> @Project : binance4j</p>
 *
 * <p> @author konbluesky </p>
 */
public class BaseBFuturesClient<T> extends RestClient<T> {

    /** URL base domain. */
    protected String baseDomain = "dapi.binance.com";

    /** Testnet URL base domain. */
    protected String testnetDomain = "testnet.binancefuture.com";

    protected BaseBFuturesClient(Class<T> mapping, String key, String secret) {
        super(mapping, key, secret);
        this.createService();
    }

    @Override
    protected void createService() {
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        converterFactory = JacksonConverterFactory.create(mapper);
        dispatcher = new Dispatcher();
        httpClient = new OkHttpClient.Builder().dispatcher(dispatcher).build();
        apiUrl = String.format("https://%s", useTestnet ? testnetDomain : baseDomain);
        interceptor = new AuthenticationInterceptor(key, secret);
        client = httpClient.newBuilder().addInterceptor(interceptor).addInterceptor(new MetaHeadersInterceptor()).build();
        service = new Retrofit.Builder().baseUrl(apiUrl).addConverterFactory(converterFactory).client(client).build().create(mapping);
    }
}