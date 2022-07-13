package com.binance4j.nft;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.binance4j.core.exception.ApiException;
import com.binance4j.nft.asset.NFTAssetHistory;
import com.binance4j.nft.asset.NFTAssetParams;

/**
 * Tests the Deposit history request
 */
public class GetAssetsTest extends NFTTest {
	@Test
	@DisplayName("It should return a non null result")
	void testRequest() throws ApiException {
		NFTAssetParams params = new NFTAssetParams();
		NFTAssetHistory history = client.getAssets(params).execute();
		test(history);
	}

	@Test
	@DisplayName("It should return a non null result")
	void testLimitAndPage() throws ApiException {
		NFTAssetParams params = new NFTAssetParams(limit, page);
		NFTAssetHistory history = client.getAssets(params).execute();
		test(history);
		assertTrue(history.getTotal() <= limit);
	}

}
