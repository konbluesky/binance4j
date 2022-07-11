package com.binance4j.client;

import java.util.concurrent.ExecutionException;

import org.junit.jupiter.api.Test;

import com.binance4j.core.exception.ApiException;
import com.binance4j.websocket.ticker.MiniTickerPayload;
import com.binance4j.websocket.ticker.WebsocketAllMiniTickersClient;

/**
 * endpoint doesn't seem to work
 */
class WebsocketAllMiniTickersClientTest {

	TestCallback<MiniTickerPayload> callback = new TestCallback<>();

	@Test
	void test1() throws ApiException, InterruptedException, ExecutionException {
		WebsocketAllMiniTickersClient client = new WebsocketAllMiniTickersClient(callback);
		callback.setWebsocketClient(client);
		client.open();
		callback.future.get();
	}
}