package com.binance4j.market;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.binance4j.core.exception.ApiException;
import com.binance4j.market.dto.OrderBook;
import com.binance4j.market.dto.OrderBookLimit;
import com.binance4j.market.param.OrderBookParams;

class GetOrderBookTest extends MarketTest {
	OrderBookLimit orderBookLimit = OrderBookLimit.LIMIT_10;

	@Test
	void testGetTrades() throws ApiException {
		OrderBookParams params = new OrderBookParams(symbol);
		OrderBook history = client.getOrderBook(params).execute();
		testNoNulls(history);
	}

	@Test
	void testGetTradesWithLimit() throws ApiException {
		OrderBookParams params = new OrderBookParams(symbol, orderBookLimit);
		OrderBook orderBook = client.getOrderBook(params).execute();
		assertTrue(orderBook.asks().size() <= Integer.valueOf(orderBookLimit.toString()));
		assertTrue(orderBook.bids().size() <= Integer.valueOf(orderBookLimit.toString()));
		testNoNulls(orderBook);
	}
}
