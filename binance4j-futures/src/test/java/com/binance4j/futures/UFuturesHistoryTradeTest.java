package com.binance4j.futures;

import com.binance4j.core.exception.ApiException;
import com.binance4j.core.test.CustomTest;
import com.binance4j.futures.client.UFuturesMarketClient;
import com.binance4j.futures.dto.AggTrade;
import com.binance4j.futures.dto.Trade;
import com.binance4j.futures.param.AggTradeParams;
import com.binance4j.futures.param.HistoricalTradesParams;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * <p> @Date : 2022/11/28 </p>
 * <p> @Project : binance4j</p>
 *
 * <p> @author konbluesky </p>
 */
@Slf4j
public class UFuturesHistoryTradeTest extends CustomTest {

    UFuturesMarketClient client = new UFuturesMarketClient(key, secret);

    @Test
    void testHistoryTrades() throws ApiException {

        List<Trade> vetusdt = client.getHistoricalTrades(new HistoricalTradesParams("VETUSDT"))
                                    .sync();
        log.info("Trade List Size : {}", vetusdt.size());
        for (Trade trade : vetusdt) {
            log.info(" ID : {}  Price : {}  Quantity: {}", trade.id(), trade.price(), trade.qty());
        }

    }

    @Test
    void testAggTrades() throws ApiException {
        List<AggTrade> vetusdt = client.getAggTrades(new AggTradeParams("VETUSDT"))
                                       .sync();
        log.info("Trade List Size : {}", vetusdt.size());
        for (AggTrade trade : vetusdt) {
            log.info(" ID : {}  Price : {}  Quantity: {}", trade.tradeId(), trade.price(), trade.quantity());
        }
    }

}
