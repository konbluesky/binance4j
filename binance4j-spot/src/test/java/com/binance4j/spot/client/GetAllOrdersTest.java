package com.binance4j.spot.client;

import org.junit.jupiter.api.Test;

import com.binance4j.core.exception.ApiException;
import com.binance4j.spot.order.AllOrdersParams;

/** TODO JAVADOC */
public class GetAllOrdersTest extends SpotTest {

	@Test
	public void testGetAllOrders() throws ApiException {
		test(client.getAllOrders(new AllOrdersParams("APEBUSD")));
	}
}