package com.binance4j.market.param;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import com.binance4j.core.annotation.Mandatory;
import com.binance4j.core.annotation.Param;
import com.binance4j.core.param.Params;

/**
 * The parameters to get the the best price/quantity on the order book for the given symbols.
 */
@Param(weight = 2, recvWindow = false, timestamp = false)
public class BookTickersParams implements Params {
	/** Ticker symbol. */
	@Mandatory
	String symbols;

	/**
	 * .
	 *
	 * @param symbols The trading pairs we want the ticker.
	 */
	public BookTickersParams(Collection<String> symbols) {
		List<String> list = symbols.stream().map(String::trim).map(s -> String.format("\"%s\"", s)).collect(Collectors.toList());
		this.symbols = "[" + String.join(",", list) + "]";
	}

	/**
	 * .
	 *
	 * @param symbols The trading pairs we want the ticker.
	 */
	public BookTickersParams(String symbols) {
		this(Arrays.asList(symbols.split(",")));
	}

	/**
	 * @return the symbols.
	 */
	public String getSymbols() {
		return symbols;
	}

	/**
	 * @param symbols the symbols to set.
	 */
	public void setSymbols(String symbols) {
		this.symbols = symbols;
	}

}
