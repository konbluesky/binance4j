package com.binance4j.c2c.client;

import org.junit.jupiter.api.Test;

import com.binance4j.c2c.dto.TradeType;
import com.binance4j.c2c.param.TradeHistoryParams;
import com.binance4j.core.exception.ApiException;
import com.binance4j.core.param.Paging;
import com.binance4j.core.test.CustomTest;

public class C2CClientTest extends CustomTest {
	protected C2CClient client = new C2CClient(key, secret);
	protected Paging paging = new Paging(1, 25);

	@Test
	void testGetTrades() throws ApiException {
		testNoNulls(client.getTrades(new TradeHistoryParams(TradeType.BUY)));
		testNoNulls(client.getTrades(new TradeHistoryParams(TradeType.SELL)));
	}

	@Test
	void testGetTrades2() throws ApiException {
		testNoNulls(client.getTrades(new TradeHistoryParams(TradeType.BUY), paging));
		testNoNulls(client.getTrades(new TradeHistoryParams(TradeType.SELL), paging));
	}
}