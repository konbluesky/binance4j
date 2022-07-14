package com.binance4j.spot.client;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.binance4j.core.exception.ApiException;

/** TODO JAVADOC */
public class GetOpenOcoTest extends SpotTest {

	@Test
	public void testGetOpenOCO() throws ApiException {
		client.getOpenOCO().execute().forEach(oco -> assertTrue(hasNoNullProperty(oco)));
	}
}