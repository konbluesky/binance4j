package com.binance4j.spot.client;

import org.junit.jupiter.api.Test;

import com.binance4j.core.exception.ApiException;

/** TODO JAVADOC */
public class GetAccountTest extends SpotTest {

	@Test
	public void testGetAccount() throws ApiException {
		test(client.getAccount());
	}
}
