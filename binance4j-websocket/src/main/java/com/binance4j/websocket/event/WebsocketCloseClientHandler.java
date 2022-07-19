package com.binance4j.websocket.event;

import com.binance4j.websocket.client.WebsocketClient;
import com.binance4j.websocket.client.WebsocketInterceptorCallback;
import com.binance4j.websocket.configuration.WebsocketClientConfiguration;

/** Will close the client after {@link WebsocketClientConfiguration#closeAfter} */
public class WebsocketCloseClientHandler extends BaseWebsocketEventHandler {
	/**
	 * @param websocketClient The websocket client.
	 * @param callback        The callback.
	 */
	public WebsocketCloseClientHandler(WebsocketClient websocketClient, WebsocketInterceptorCallback<?> callback) {
		super(websocketClient, callback, "Client not closing", "Disconnected");
	}

	public void run() {
		cancel();
		disconnect(websocketClient.getConfiguration().getCloseAfter());
	}
}
