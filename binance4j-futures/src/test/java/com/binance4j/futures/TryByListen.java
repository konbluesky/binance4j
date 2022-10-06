package com.binance4j.futures;

import com.binance4j.connectors.Connectors;
import com.binance4j.core.exception.ApiException;
import com.binance4j.core.test.CustomTest;
import com.binance4j.futures.client.UFuturesMarketClient;
import com.binance4j.futures.dto.SymbolInfo;
import com.binance4j.futures.param.PremiumIndexParams;
import com.binance4j.margin.client.MarginClient;
import com.binance4j.margin.dto.IsolatedFee;
import com.binance4j.margin.dto.IsolatedFeeData;
import com.binance4j.margin.dto.IsolatedSymbol;
import com.binance4j.margin.dto.MaxBorrowable;
import com.binance4j.margin.param.IsolatedFeeParams;
import com.binance4j.margin.param.MaxBorrowableParams;
import com.binance4j.market.client.MarketClient;
import com.binance4j.market.dto.ExchangeInfo;
import com.binance4j.market.dto.OrderBook;
import com.binance4j.market.dto.PriceTicker;
import com.binance4j.market.param.ExchangeInfoParams;
import com.binance4j.market.param.OrderBookParams;
import com.binance4j.market.param.PriceTickersParams;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * <p> @Date : 2022/10/5 </p>
 * <p> @Project : binance4j</p>
 *
 * <p> @author konbluesky </p>
 */
@Slf4j
public class TryByListen extends CustomTest {

    Connectors connectors = new Connectors(key, secret);
    MarketClient marketClient = connectors.rest().market();
    UFuturesMarketClient ufuturesMarketClient = new UFuturesMarketClient(key, secret);



    @Test
    public void report() throws ApiException {
        com.binance4j.futures.dto.ExchangeInfo contractExchangeInfo = ufuturesMarketClient.getExchangeInfo().sync();
        ExchangeInfo spotExchangeInfo = marketClient.getExchangeInfo().sync();


        //1. 取合约
        //   1.1 合约的费率
        //   1.2 合约卖一的深度
        //   1.3 合约精度
        //2. 取现货
        //   2.1 取现货价格
        //   2.2 取现货精度
        //3. 取杠杆
        Map<String, String> allSpotPriceTicker = marketClient.getTicker().sync().stream().collect(Collectors.toMap(PriceTicker::symbol, PriceTicker::price));
        Map<String, String> allFuturePriceTicker = ufuturesMarketClient.getTickers().sync().stream()
                                                                       .collect(Collectors.toMap(com.binance4j.futures.dto.PriceTicker::symbol,
                                                                                                 com.binance4j.futures.dto.PriceTicker::price));
        report(spotExchangeInfo, contractExchangeInfo, allSpotPriceTicker, allFuturePriceTicker);
    }

    @Test
    public void testListen() throws ApiException {

        PreLoader preLoader = new PreLoader(connectors, ufuturesMarketClient);
        DecimalFormat df=new DecimalFormat("0.00000000");
        while(true) {
            Map<String, String> allSpotPriceTicker = marketClient.getTicker().sync().stream().collect(Collectors.toMap(PriceTicker::symbol, PriceTicker::price));
            Map<String, String> allFuturePriceTicker = ufuturesMarketClient.getTickers().sync().stream()
                                                                           .collect(Collectors.toMap(com.binance4j.futures.dto.PriceTicker::symbol,
                                                                                                     com.binance4j.futures.dto.PriceTicker::price));
            preLoader.getPriceScales().forEach((symbol, priceScale) -> {
                try {
                    SpotFutureInterestRecord spotFutureInterestRecord = new SpotFutureInterestRecord();
                    spotFutureInterestRecord.setSpotFutureDiffThreshold(0.001);
                    spotFutureInterestRecord.setInterestRateSpreadThreshold(0.0025);
                    spotFutureInterestRecord.setFundingRateThreshold(0.0003);

                    spotFutureInterestRecord.setSymbol(symbol);
                    spotFutureInterestRecord.setSpotPrice(Double.parseDouble(allSpotPriceTicker.get(symbol)));
                    spotFutureInterestRecord.setFuturePrice(Double.parseDouble(allFuturePriceTicker.get(symbol)));
                    spotFutureInterestRecord.setDailyInterestRate(Double.parseDouble(preLoader.getDailyInterest(symbol)));
                    double fundingRate = ufuturesMarketClient.premiumIndex(new PremiumIndexParams(symbol)).sync().absLastFundingRate();
                    spotFutureInterestRecord.setFutureFundingRate(fundingRate);
                    if (spotFutureInterestRecord.fundingRateMatch()) {
                        log.warn("FundingRate:{} - {}", symbol, df.format(fundingRate));
                        if (spotFutureInterestRecord.spotFutureMatch()) {

                            OrderBook spotOrderBook = marketClient.getOrderBook(new OrderBookParams(symbol)).sync();
                            com.binance4j.futures.dto.OrderBook futureOrderBook = ufuturesMarketClient.getOrderBook(new com.binance4j.futures.param.OrderBookParams(symbol))
                                                                                                      .sync();
                            spotFutureInterestRecord.setSpotAskFirst(spotOrderBook.getFirstAsk());
                            spotFutureInterestRecord.setFutureAskFirst(futureOrderBook.getFirstAsk());

                            if (spotFutureInterestRecord.orderBookMatch()) {
                                double priceDiffRatio = (spotOrderBook.getFirstAsk() - futureOrderBook.getFirstAsk()) / spotOrderBook.getFirstAsk();
                                log.warn("{} priceDiffRatio : {} ", symbol, df.format(priceDiffRatio));
                                log.warn("{} priceScale: {} ", symbol, priceScale);
                                log.warn("{} dailyInterestPrice: {} ", symbol, df.format(spotFutureInterestRecord.getDailyInterestRate()));
                                double cerPer = priceDiffRatio - Double.parseDouble(priceScale) - spotFutureInterestRecord.getDailyInterestRate();
                                log.warn("{} cerPer: {} ", symbol, df.format(cerPer));
                            }
                        }
                    }
                } catch (ApiException e) {
                    //                    throw new RuntimeException(e);
                }
            });
        }
    }

    private void report(ExchangeInfo spotExchangeInfo, com.binance4j.futures.dto.ExchangeInfo futuresExchangeInfo, Map<String, String> spotPrices,
                        Map<String, String> futurePrices) {

        String s = String.format("Spot Symbols: %d, \t Futures Symbols: %d", spotExchangeInfo.symbols().size(), futuresExchangeInfo.symbols().size());
        log.info(s);
        log.info("Spot Prices: {} \t Futures Prices: {}", spotPrices.size(), futurePrices.size());
        //        Map<String, String> map = futuresExchangeInfo.symbols().stream().collect(Collectors.toMap(SymbolInfo::symbol, SymbolInfo::symbol));
        //        MapDifference<String, String> difference = Maps.difference(spotPrices, futurePrices);
        //        log.info("Difference :{} ", difference);
    }

    @Test
    public void testAllIsolateSymbols() throws ApiException {
        MarginClient marginClient = connectors.rest().margin();
        List<IsolatedSymbol> isolatedSymbols = marginClient.getAllIsolatedSymbols().sync();
        System.out.println("isolatedSymbols: " + isolatedSymbols.size());
        for (IsolatedSymbol isolatedSymbol : isolatedSymbols) {
            System.out.println(isolatedSymbol.symbol());
        }
    }

    /**
     * 获取有效的精度信息
     * 1. 获取合约精度
     * 2. 根据合约精度获取现货
     * 3. 现货精度提取
     * 4. 计算精度差值 存入map
     *
     * @throws ApiException
     */
    @Test
    public void testPrecision() throws ApiException {

        Map<String, String> futureTickSizes = new HashMap<>();
        Map<String, String> spotTickSizes = new HashMap<>();
        for (SymbolInfo symbolInfo : ufuturesMarketClient.getExchangeInfo().sync().symbols()) {
            futureTickSizes.put(symbolInfo.symbol(), symbolInfo.filters().price().tickSize());
        }

        List<String> avalibleSymbols = futureTickSizes.keySet().stream().filter(r -> {
            return !r.equalsIgnoreCase("ETHUSDT_221230") && !r.equalsIgnoreCase("BTCUSDT_221230") && !r.equalsIgnoreCase("BTCSTUSDT")
                    && !r.equalsIgnoreCase("1000XECUSDT") && !r.equalsIgnoreCase("FOOTBALLUSDT") && !r.equalsIgnoreCase("LUNA2USDT") && !r.equalsIgnoreCase("LUNA2BUSD")
                    && !r.equalsIgnoreCase("1000SHIBUSDT") && !r.equalsIgnoreCase("1000LUNCUSDT") && !r.equalsIgnoreCase("DEFIUSDT")
                    && !r.equalsIgnoreCase("1000SHIBBUSD") && !r.equalsIgnoreCase("BTCDOMUSDT") && !r.equalsIgnoreCase("1000LUNCBUSD");
        }).collect(Collectors.toList());

        List<PriceTicker> spotPriceTickers = connectors.rest().market().getTicker(new PriceTickersParams(avalibleSymbols)).sync();
        for (com.binance4j.market.dto.SymbolInfo symbolInfo : connectors.rest().market().getExchangeInfo(new ExchangeInfoParams(avalibleSymbols)).sync().symbols()) {
            spotTickSizes.put(symbolInfo.symbol(), symbolInfo.filters().price().tickSize());
        }

        DecimalFormat decimalFormat = new DecimalFormat("0.00000000");
        for (PriceTicker priceTicker : spotPriceTickers) {
            double futureTickSize = Double.parseDouble(futureTickSizes.get(priceTicker.symbol()));
            double spotTickSize = Double.parseDouble(spotTickSizes.get(priceTicker.symbol()));
            log.info("Symbol: {} , Spot price: {} , Spot TickSize : {} , Future TickSize: {}, Diff Value: {}",
                     priceTicker.symbol(),
                     priceTicker.price(),
                     decimalFormat.format(futureTickSize),
                     decimalFormat.format(spotTickSize),
                     decimalFormat.format(futureTickSize - spotTickSize));
        }
    }

    @Test
    public void testPreload() {
        PreLoader preLoader = new PreLoader(connectors, ufuturesMarketClient);
        log.info("PriceScales Size : {} ", preLoader.getPriceScales().size());
        preLoader.getPriceScales().forEach((key, value) -> {
            log.info("PriceScales : {} \t {}", key, value);
        });
        log.info("DailyInterest Size : {} ", preLoader.getDailyInterest().size());
        preLoader.getDailyInterest().forEach((key, value) -> {
            log.info("DailyInterest : {} \t {}", key, value);
        });
    }

    @Test
    public void testIsolateSymbolsFeeData() throws ApiException {
        MarginClient marginClient = connectors.rest().margin();
        List<IsolatedFee> isolatedFees = marginClient.getIsolatedFeeData(new IsolatedFeeParams("AXSUSDT")).sync();
        log.info("isolatedSymbols: {}", isolatedFees.size());
        for (IsolatedFee fee : isolatedFees) {
            log.info("IsolatedFee : " + fee.symbol());
            IsolatedFeeData useAsset = fee.getUseAsset();
            log.info("useAsset : {} {} {}", useAsset.coin(), useAsset.borrowLimit(), useAsset.dailyInterest());
        }
    }


    @Test
    void maxBorrowLimit() throws ApiException {
        MaxBorrowable maxBorrowable = connectors.rest().margin().getMaxBorrowable(new MaxBorrowableParams("DUSK")).sync();
        log.info(maxBorrowable.toString());
    }
}
