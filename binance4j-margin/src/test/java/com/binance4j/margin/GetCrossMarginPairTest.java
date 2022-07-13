package com.binance4j.margin;

import org.junit.jupiter.api.Test;

import com.binance4j.core.exception.ApiException;
import com.binance4j.margin.pair.MarginPairPrams;

public class GetCrossMarginPairTest extends MarginTest {

    @Test
    void test1() throws ApiException {
        test(getClient().getCrossMarginPair(new MarginPairPrams(getSymbol())).execute());
    }
}
