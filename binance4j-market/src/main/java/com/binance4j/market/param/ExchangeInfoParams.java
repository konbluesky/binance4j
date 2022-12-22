package com.binance4j.market.param;

import com.binance4j.core.annotation.Param;
import com.binance4j.core.param.Params;
import com.binance4j.market.client.MarketClient;

import java.util.List;
import java.util.stream.Collectors;

/**
 * {@link MarketClient#getExchangeInfo} params.
 *
 * @param symbols Symbols.
 */
@Param(weight = 10, recvWindow = false, timestamp = false)
public record ExchangeInfoParams(String symbols, String permissions, Boolean byPermissions) implements Params {

    /** Creates an instance of {@link ExchangeInfoParams}. */
    public ExchangeInfoParams() {
        this("");
    }

    /**
     * @param symbols Trading pair list.
     */
    public ExchangeInfoParams(String symbols) {
        this(symbols, "", false);
    }

    /**
     * @param permissions   If {byPermissions} is True ，then permissions takeEffect ;
     * @param byPermissions Is a marker variable
     */
    public ExchangeInfoParams(String permissions, boolean byPermissions) {
        this("", permissions, true);
    }

    public ExchangeInfoParams(String symbols, String permissions, Boolean byPermissions) {
        if (byPermissions) {
            this.symbols = "";
            this.permissions = "[" + List.of(permissions.split(","))
                                         .stream()
                                         .map(s -> String.format("\"%s\"", s.trim()))
                                         .collect(Collectors.joining(",")) + "]";
        } else {
            this.permissions = "";
            if (symbols.equals("")) {
                this.symbols = "";
            } else {
                this.symbols = "[" + List.of(symbols.split(","))
                                         .stream()
                                         .map(s -> String.format("\"%s\"", s.trim()))
                                         .collect(Collectors.joining(",")) + "]";
            }
        }
        this.byPermissions = null;
    }

    /**
     * @param symbols Trading pair list.
     */
    public ExchangeInfoParams(List<String> symbols) {
        this(symbols.stream()
                    .collect(Collectors.joining(",")));
    }
}