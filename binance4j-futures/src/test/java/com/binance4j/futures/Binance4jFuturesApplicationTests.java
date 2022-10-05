package com.binance4j.futures;

import com.binance4j.core.exception.ApiException;
import com.binance4j.core.test.CustomTest;
import com.binance4j.futures.client.FuturesMarketClient;
import com.binance4j.futures.dto.ExchangeInfo;
import com.binance4j.futures.dto.OrderBook;
import com.binance4j.futures.dto.OrderBookLimit;
import com.binance4j.futures.dto.SymbolInfo;
import com.binance4j.futures.param.OrderBookParams;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

public class Binance4jFuturesApplicationTests extends CustomTest {

    FuturesMarketClient client = new FuturesMarketClient(key, secret);

    public Binance4jFuturesApplicationTests() {
        //        client.getMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);
        //        client.getMapper().configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, true);
    }

    @Test
    void testPing() throws ApiException {
        System.out.println(client.ping());
    }

    @Test
    void testGetServerTime() throws ApiException {
        System.out.println(client.getServerTime().sync());
    }

    @Test
    public void testGetExchangeInfo() throws ApiException, JsonProcessingException {
        ExchangeInfo exchangeInfo = client.getExchangeInfo().sync();
        ObjectMapper objectMapper = new ObjectMapper();
        SymbolInfo symbolInfo = exchangeInfo.symbols().get(0);
        System.out.println(objectMapper.writeValueAsString(symbolInfo));
    }

    @Test
    void testGetOrderBook() throws ApiException, JsonProcessingException {
        OrderBook orderBook = client.getOrderBook(new OrderBookParams("BNBUSDT", OrderBookLimit.LIMIT_5)).sync();
        ObjectMapper objectMapper = new ObjectMapper();
        System.out.println(objectMapper.writeValueAsString(orderBook));
        //        testNotThrow(client.getOrderBook(new OrderBookParams(symbol)));
    }

}
