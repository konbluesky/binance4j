package com.binance4j.futures;

import com.binance4j.connectors.Connectors;
import com.binance4j.core.exception.ApiException;
import com.binance4j.core.test.CustomTest;
import com.binance4j.futures.client.UFuturesMarketClient;
import com.binance4j.market.client.MarketClient;
import com.binance4j.market.dto.ExchangeInfo;
import com.binance4j.market.dto.SymbolInfo;
import org.junit.jupiter.api.Test;

/**
 * <p> @Date : 2022/10/5 </p>
 * <p> @Project : binance4j</p>
 *
 * <p> @author konbluesky </p>
 */
public class TryByListen extends CustomTest {

    @Test
    public void testListen() throws ApiException {

        MarketClient marketClient = new Connectors(key, secret).rest().market();
        UFuturesMarketClient ufuturesMarketClient = new UFuturesMarketClient(key, secret);
        com.binance4j.futures.dto.ExchangeInfo contractExchangeInfo = ufuturesMarketClient.getExchangeInfo().sync();
        ExchangeInfo spotExchangeInfo = marketClient.getExchangeInfo().sync();

        report(spotExchangeInfo,contractExchangeInfo);

    }


    private void report(ExchangeInfo spotExchangeInfo, com.binance4j.futures.dto.ExchangeInfo futuresExchangeInfo){

        String s = String.format("Spot Symbols: %d, \t Futures Symbols: %d", spotExchangeInfo.symbols().size(), futuresExchangeInfo.symbols().size());
        System.out.println(s);

    }

}
