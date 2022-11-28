package com.binance4j.futures;

import com.binance4j.core.exception.ApiException;
import com.binance4j.core.test.CustomTest;
import com.binance4j.futures.client.UFuturesMarketClient;
import com.binance4j.futures.dto.*;
import com.binance4j.futures.param.OrderBookParams;
import com.binance4j.futures.param.PremiumIndexParams;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.text.DecimalFormat;
import java.text.ParseException;

@Slf4j
public class Binance4jFuturesApplicationTests extends CustomTest {

    UFuturesMarketClient client = new UFuturesMarketClient(key, secret);

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
        SymbolInfo symbolInfo = exchangeInfo.symbols().get(100);
        System.out.println(exchangeInfo.symbols().size());
        System.out.println(symbolInfo.filters().price().tickSize());
        System.out.println(objectMapper.writeValueAsString(symbolInfo));
    }

    @Test
    public void testGetExchangeInfoPrice() throws ApiException, JsonProcessingException {
        ExchangeInfo exchangeInfo = client.getExchangeInfo().sync();
        ObjectMapper objectMapper = new ObjectMapper();
        SymbolInfo symbolInfo = exchangeInfo.symbols().get(0);
        System.out.println(exchangeInfo.symbols().size());
        System.out.println(objectMapper.writeValueAsString(symbolInfo));
    }

    @Test
    void testGetOrderBook() throws ApiException, JsonProcessingException {
        OrderBook orderBook = client.getOrderBook(new OrderBookParams("BNBUSDT", OrderBookLimit.LIMIT_5)).sync();
        ObjectMapper objectMapper = new ObjectMapper();
        System.out.println(objectMapper.writeValueAsString(orderBook));
        //        testNotThrow(client.getOrderBook(new OrderBookParams(symbol)));
    }

    @Test
    void testPremiumIndex() throws ApiException, JsonProcessingException, ParseException {
        PremiumIndex premiumIndex = client.premiumIndex(new PremiumIndexParams("SUSHIUSDT")).sync();
        ObjectMapper objectMapper = new ObjectMapper();

        DecimalFormat decimalFormat = new DecimalFormat("0.00000000");
        //{"symbol":"BNBUSDT","markPrice":"294.98000000","indexPrice":"295.10113400","estimatedSettlePrice":"294.93111754","lastFundingRate":"-0.00008278","nextFundingTime":1664956800000,"interestRate":"0","time":1664943186000}
        System.out.println(premiumIndex.lastFundingRate());
        System.out.println(Math.abs(Double.parseDouble(premiumIndex.lastFundingRate())));
        System.out.println("lastFundingRate: " + Double.toString(premiumIndex.absLastFundingRate()));
        System.out.println(Math.abs(Double.parseDouble(premiumIndex.lastFundingRate())) > 0.0001);
        System.out.println(Double.parseDouble(premiumIndex.lastFundingRate()) < -0.001);
        System.out.println(Double.parseDouble(premiumIndex.lastFundingRate()) > -0.001);
        System.out.println(objectMapper.writeValueAsString(premiumIndex));
        System.out.println(decimalFormat.format(Double.parseDouble(premiumIndex.lastFundingRate())));
        //        testNotThrow(client.getOrderBook(new OrderBookParams(symbol)));
    }


    @Test
    void maxBorrowLimit(){
    }
}
