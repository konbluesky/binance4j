package com.binance4j.nft;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.binance4j.core.exception.ApiException;
import com.binance4j.nft.client.NFTClient;
import com.binance4j.nft.deposit.NFTDepositHistory;
import com.binance4j.nft.deposit.NFTDepositHistoryRequest;
import com.binance4j.nft.service.TestService;

/**
 * Tests the Deposit history request
 */
public class GetDepositsTest {
	final NFTClient client = TestService.CLIENT;
	final int limit = 25;
	final int page = 1;

	@Test
	@DisplayName("It should return a non null result")
	void testRequest() throws ApiException {
		NFTDepositHistoryRequest req = new NFTDepositHistoryRequest();
		test(req);
	}

	@Test
	@DisplayName("It should return a non null result")
	void testLimitAndPage() throws ApiException {
		NFTDepositHistoryRequest req = new NFTDepositHistoryRequest(limit, page);
		testLimit(req);
	}

	/**
	 * Tests that the result fields ar not null
	 *
	 * @param req The request
	 * @throws ApiException The Exception sent by the server
	 */
	NFTDepositHistory test(NFTDepositHistoryRequest req) throws ApiException {
		NFTDepositHistory history = client.getDeposits(req).execute();
		assertTrue(TestService.hasNoNullProperty(history));
		history.getList().forEach(deposit -> assertTrue(TestService.hasNoNullProperty(deposit)));
		return history;
	}

	/**
	 * Tests that the result fields ar not null and that the total is inferior or
	 * equal to the request limit
	 *
	 * @param req The request
	 * @throws ApiException The Exception sent by the server
	 */
	void testLimit(NFTDepositHistoryRequest req) throws ApiException {
		NFTDepositHistory history = test(req);
		assertTrue(history.getTotal() <= limit);
	}
}
