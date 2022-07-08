package com.binance4j.spot.client;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.binance4j.core.exception.ApiException;
import com.binance4j.core.test.ConcurrentTest;
import com.binance4j.spot.order.AllOrdersRequest;

public class GetAllOrdersTest extends ConcurrentTest {
	final SpotClient client = SpotCLIENT;

	@Test
	@DisplayName("Properties shouldn't be null or ApiException should not be null")
	public void testGetAllOrders() throws ApiException {
		client.getAllOrders(new AllOrdersRequest("APEBUSD")).execute()
				.forEach(order -> assertTrue(SpothasNoNullProperty(order)));
	}
}