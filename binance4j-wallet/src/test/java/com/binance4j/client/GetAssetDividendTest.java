package com.binance4j.client;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.binance4j.core.exception.ApiException;
import com.binance4j.wallet.assetdividendrecord.AssetDividend;
import com.binance4j.wallet.assetdividendrecord.AssetDividendRecord;
import com.binance4j.wallet.assetdividendrecord.AssetDividendRecordRequest;
import com.binance4j.wallet.client.WalletClient;

class GetAssetDividendTest {
	final WalletClient client = CLIENT;

	static void testDividend(AssetDividend dividend) {
		assertTrue(hasNoNullProperty(dividend));
	}

	@Test
	@DisplayName("It should return dividend record of all assets")
	void testGetAnyAssetDividend() throws ApiException {
		AssetDividendRecord record = client.getAssetDividendRecord().execute();

		assertNotNull(record.getTotal());
		record.getRows().forEach(GetAssetDividendTest::testDividend);
	}

	@Test
	@DisplayName("It should return dividend record of the given asset")
	void testGetGivenAssetDividend() throws ApiException {
		AssetDividendRecordRequest req = new AssetDividendRecordRequest(getAsset());
		AssetDividendRecord record = client.getAssetDividendRecord(req).execute();

		assertNotNull(record.getTotal());
		record.getRows().forEach(r -> assertEquals(getAsset(), r.getAsset()));
		record.getRows().forEach(GetAssetDividendTest::testDividend);
	}

	@Test
	@DisplayName("It should return the given size (or less) of dividend records of the given asset")
	void testGetGivenAssetDividendWithLimit() throws ApiException {
		int limit = 25;
		AssetDividendRecordRequest req = new AssetDividendRecordRequest(getAsset(), limit);
		AssetDividendRecord record = client.getAssetDividendRecord(req).execute();

		assertTrue(record.getTotal() <= limit);
		assertTrue(record.getRows().size() <= limit);

		record.getRows().forEach(r -> assertEquals(getAsset(), r.getAsset()));
		record.getRows().forEach(GetAssetDividendTest::testDividend);
	}
}
