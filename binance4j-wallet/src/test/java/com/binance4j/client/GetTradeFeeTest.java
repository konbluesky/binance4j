package com.binance4j.client;

import org.junit.jupiter.api.Test;

import com.binance4j.core.exception.ApiException;
import com.binance4j.wallet.param.TradeFeeParams;

class GetTradeFeeTest extends WalletTest {

	@Test
	void testGetTradeFeeOfAll() throws ApiException {
		testNoNulls(client.getTradeFee());
	}

	@Test
	void testGetTradeFeeOfOne() throws ApiException {
		testNoNulls(client.getTradeFee(new TradeFeeParams("BNBBTC")));
	}
}
