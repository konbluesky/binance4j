package com.binance4j.margin;

import org.junit.jupiter.api.Test;

import com.binance4j.core.exception.ApiException;

/** TODO JAVADOC */
public class GetEnabledIsolatedAccountLimitTest extends MarginTest {
    @Test
    void test1() throws ApiException {
        test(client.getEnabledIsolatedAccountLimit());
    }
}
