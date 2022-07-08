package com.binance4j.core;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.binance4j.core.client.MarketClient;
import com.binance4j.core.client.TestnetMarketClient;

public class TestnetTest {

    @Test
    @DisplayName("It should not thrown an exception when using testnet")
    void testTestnet() {
        MarketClient client = new TestnetMarketClient();

        assertDoesNotThrow(() -> {
            client.ping();
        });
    }
}
