package com.binance4j.futures;

import com.binance4j.connectors.Connectors;
import com.binance4j.core.exception.ApiException;
import com.binance4j.core.test.CustomTest;
import com.binance4j.margin.dto.CrossSymbol;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * <p> @Date : 2022/10/6 </p>
 * <p> @Project : binance4j</p>
 *
 * <p> @author konbluesky </p>
 */
@Slf4j
public class PairTests extends CustomTest {

    Connectors connectors = new Connectors(key, secret);


    @Test
    public void index() throws ApiException {
        List<CrossSymbol> crossSymbols = connectors.rest().margin().getAllCrossMarginPairs().sync();
        log.info(crossSymbols.toString());
    }
}
