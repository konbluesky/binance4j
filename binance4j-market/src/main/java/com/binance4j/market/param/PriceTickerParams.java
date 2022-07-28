package com.binance4j.market.param;

/** The parameters to get the latest price for a symbol or symbols. */
public class PriceTickerParams extends MarketParams {
	/** Ticker symbol. */
	String symbol;

	/** for all symbols ticker. */
	public PriceTickerParams() {
		super(2);
	}

	/**
	 * for a unique symbol
	 *
	 * @param symbol The symbol we want the ticker.
	 */
	public PriceTickerParams(String symbol) {

		this.symbol = symbol;
	}

	/**
	 * @return the symbol.
	 */
	public String getSymbol() {
		return symbol;
	}

	/**
	 * @param symbol the symbol to set.
	 */
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
}