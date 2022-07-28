package com.binance4j.market.param;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import com.binance4j.core.annotation.Mandatory;
import com.binance4j.core.annotation.Param;
import com.binance4j.core.param.Params;

/**
 * The parameters to get the 24 hour rolling window price change statistics of specific symbols.
 */
@Param(recvWindow = false, timestamp = false)
public class TickersStatisticsParams implements Params {
	/** The trading pair we want the ticker stats. */
	@Mandatory
	String symbols;
	List<String> list;

	/**
	 * @param symbols The trading pairs we want the ticker stats.
	 */
	public TickersStatisticsParams(Collection<String> symbols) {
		list = symbols.stream().map(String::trim).map(s -> String.format("\"%s\"", s)).collect(Collectors.toList());
		this.symbols = "[" + String.join(",", list) + "]";
	}

	@Override
	public int weight() {
		if (list.size() <= 21) {
			return 1;
		} else if (list.size() <= 101) {
			return 20;
		} else {
			return 40;
		}
	}

	/**
	 * to get the ticker stats of multiple symbol
	 *
	 * @param symbols The trading pairs we want the ticker stats.
	 */
	public TickersStatisticsParams(String symbols) {
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