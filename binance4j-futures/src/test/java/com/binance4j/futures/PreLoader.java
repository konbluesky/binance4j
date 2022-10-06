package com.binance4j.futures;

import com.binance4j.connectors.Connectors;
import com.binance4j.core.exception.ApiException;
import com.binance4j.futures.client.UFuturesMarketClient;
import com.binance4j.futures.dto.SymbolInfo;
import com.binance4j.margin.client.MarginClient;
import com.binance4j.margin.dto.IsolatedFee;
import com.binance4j.margin.dto.IsolatedFeeData;
import com.binance4j.market.dto.PriceTicker;
import com.binance4j.market.param.ExchangeInfoParams;
import com.binance4j.market.param.PriceTickersParams;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;

/**
 * <p> @Date : 2022/10/5 </p>
 * <p> @Project : binance4j</p>
 *
 * <p> @author konbluesky </p>
 */
@Slf4j
@Getter
public class PreLoader {

    private Connectors connectors;

    private UFuturesMarketClient uFuturesMarketClient;

    private Set<String> symbols = new TreeSet<>();

    private Map<String, String> dailyInterest = new HashMap<>();

    private Map<String, String> priceScales = new HashMap<>();

    public String getDailyInterest(String symbol){
        return dailyInterest.get(symbol);
    }
    public String getPriceScale(String symbol){
        return priceScales.get(symbol);
    }

    public PreLoader(Connectors connectors, UFuturesMarketClient client) {
        this.connectors = connectors;
        this.uFuturesMarketClient = client;
        initPriceScales();
        initDailyInterest();
    }

    private void initPriceScales() {
        try {
            Map<String, String> futureTickSizes = new HashMap<>();
            Map<String, String> spotTickSizes =  new HashMap<>();
            for (SymbolInfo symbolInfo : uFuturesMarketClient.getExchangeInfo().sync().symbols()) {
                futureTickSizes.put(symbolInfo.symbol(), symbolInfo.filters().price().tickSize());
            }

            List<String> avalibleSymbols = futureTickSizes.keySet().stream().filter(
                    r->{
                        return !r.equalsIgnoreCase("ETHUSDT_221230")&&
                                !r.equalsIgnoreCase("BTCUSDT_221230")&&
                                !r.equalsIgnoreCase("BTCSTUSDT")&&
                                !r.equalsIgnoreCase("1000XECUSDT")&&
                                !r.equalsIgnoreCase("FOOTBALLUSDT")&&
                                !r.equalsIgnoreCase("LUNA2USDT")&&
                                !r.equalsIgnoreCase("LUNA2BUSD")&&
                                !r.equalsIgnoreCase("1000SHIBUSDT")&&
                                !r.equalsIgnoreCase("1000LUNCUSDT")&&
                                !r.equalsIgnoreCase("DEFIUSDT")&&
                                !r.equalsIgnoreCase("1000SHIBBUSD")&&
                                !r.equalsIgnoreCase("BTCDOMUSDT")&&
                                !r.equalsIgnoreCase("1000LUNCBUSD")
                                ;
                    }
            ).collect(Collectors.toList());

            List<PriceTicker> spotPriceTickers = connectors.rest().market().getTicker(new PriceTickersParams(avalibleSymbols)).sync();
            for (com.binance4j.market.dto.SymbolInfo symbolInfo : connectors.rest().market().getExchangeInfo(new ExchangeInfoParams(avalibleSymbols)).sync().symbols()) {
                spotTickSizes.put(symbolInfo.symbol(), symbolInfo.filters().price().tickSize());
            }

            DecimalFormat decimalFormat = new DecimalFormat("0.00000000");
            for (PriceTicker priceTicker : spotPriceTickers) {
                double futureTickSize = Double.parseDouble(futureTickSizes.get(priceTicker.symbol()));
                double spotTickSize = Double.parseDouble(spotTickSizes.get(priceTicker.symbol()));
                log.debug("Symbol: {} , Spot price: {} , Spot TickSize : {} , Future TickSize: {}, Diff Value: {}",
                         priceTicker.symbol(),
                         priceTicker.price(),
                         decimalFormat.format(futureTickSize),
                         decimalFormat.format(spotTickSize),
                         decimalFormat.format(futureTickSize - spotTickSize));
                priceScales.put(priceTicker.symbol(),decimalFormat.format(futureTickSize - spotTickSize));
            }

        } catch (ApiException e) {
            throw new RuntimeException(e);
        }
    }

    private void initDailyInterest() {
        MarginClient marginClient = connectors.rest().margin();
        List<IsolatedFee> isolatedFees = null;
        try {
            isolatedFees = marginClient.getIsolatedFeeData().sync();
        } catch (ApiException e) {
            throw new RuntimeException(e);
        }
        for (IsolatedFee fee : isolatedFees) {
            //            log.info("IsolatedFee : " + fee.symbol());
            IsolatedFeeData useAsset = fee.getUseAsset();
            //            log.info("useAsset : {} {} {}", useAsset.coin(), useAsset.borrowLimit(), useAsset.dailyInterest());
            if(priceScales.containsKey(fee.symbol())) {
                dailyInterest.put(fee.symbol(), useAsset.dailyInterest());
            }
        }
        log.debug("Init DailyInterest OK. Item Has : {} ", dailyInterest.size());
    }
}
