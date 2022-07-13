package com.binance4j.client;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.binance4j.core.exception.ApiException;
import com.binance4j.wallet.deposit.DepositHistory;
import com.binance4j.wallet.deposit.DepositHistoryParams;
import com.binance4j.wallet.deposit.DepositStatus;

class GetDepositHistoryTest extends WalletTest {

	@Test
	@DisplayName("It should return the deposit history")
	void testGetDepositHistory() throws ApiException {
		test(client.getDepositHistory());
	}

	@Test
	@DisplayName("It should return the deposit history of the given asset")
	void testGetDepositHistoryOfGivenCoin() throws ApiException {
		test(client.getDepositHistory(new DepositHistoryParams(asset)));
	}

	@Test
	@DisplayName("It should return the deposit history of the given status")
	void testGetDepositHistoryOfGivenStatus() throws ApiException {
		test(client.getDepositHistory(new DepositHistoryParams(DepositStatus.SUCCESS)));
	}

	@Test
	@DisplayName("It should return the deposit history of the given status")
	void testGetDepositHistoryOfGivenAssetAndStatus() throws ApiException {
		test(client.getDepositHistory(new DepositHistoryParams(asset, DepositStatus.SUCCESS)));
	}

	@Test
	@DisplayName("It should return the deposit history of the given status")
	void testGetDepositHistoryOfGivenAssetAndStatusAndLimit() throws ApiException {
		test(client.getDepositHistory(new DepositHistoryParams(asset, DepositStatus.SUCCESS, limit)));
	}

	@Test
	@DisplayName("It should return the deposit history of the given status")
	void testGetDepositHistoryOfGivenAssetAndStatusAndLimitAndOffset() throws ApiException {
		List<DepositHistory> history = client
				.getDepositHistory(new DepositHistoryParams(asset, DepositStatus.SUCCESS, limit, 0)).execute();
		test(history);

		assertTrue(history.size() <= limit);
		history.forEach(h -> {
			assertEquals(asset, h.getCoin());
			assertEquals(DepositStatus.SUCCESS, h.getDepositStatus());
		});
	}
}
