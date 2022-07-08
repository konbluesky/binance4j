package com.binance4j.nft;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.binance4j.core.exception.ApiException;
import com.binance4j.nft.transaction.NFTOrderType;
import com.binance4j.nft.transaction.NFTTransactionHistory;
import com.binance4j.nft.transaction.NFTTransactionHistoryRequest;

/**
 * Tests the transaction history request
 */
public class GetTransactionsTest extends NFTTest {
	@Test
	@DisplayName("Response should not contain null properties for every type")
	void testSellOrder() throws ApiException {
		Arrays.asList(NFTOrderType.values()).forEach(v -> {
			NFTTransactionHistoryRequest req = new NFTTransactionHistoryRequest(v);
			NFTTransactionHistory history;
			try {
				history = client.getTransactions(req).execute();
				test(history);
			} catch (ApiException e) {
				fail();
			}
		});
	}

	@Test
	@DisplayName("It should return a non null result")
	void testLimitAndPage() throws ApiException {
		NFTTransactionHistoryRequest req = new NFTTransactionHistoryRequest(NFTOrderType.SELL_ORDER, limit, page);
		NFTTransactionHistory history = client.getTransactions(req).execute();
		test(history);
		assertTrue(history.getTotal() <= limit);
	}
}
