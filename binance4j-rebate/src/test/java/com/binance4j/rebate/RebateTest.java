package com.binance4j.rebate;

import com.binance4j.core.test.ConcurrentTest;
import com.binance4j.rebate.client.RebateClient;

public class RebateTest extends ConcurrentTest<RebateClient> {
	public RebateTest() {
		super(RebateClient.class);
	}
}
