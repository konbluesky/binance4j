package com.binance4j.spot.param;

import com.binance4j.core.annotation.Param;
import com.binance4j.core.dto.OrderSide;
import com.binance4j.core.dto.OrderType;
import com.binance4j.core.dto.RateLimitType;
import com.binance4j.core.dto.TimeInForce;

/** A STOP_LOSS_LIMIT order. */
@Param(weight = 1, isOrder = true, type = RateLimitType.UID_AND_IP)
public class StopLossLimitOrder extends BaseOrder {
	/** Order quantity. */
	String quantity;
	/** Order stop price. */
	String stopPrice;
	/** Trailing delta. */
	Long trailingDelta;
	/** Order price. */
	String price;
	/** Order time in force. */
	TimeInForce timeInForce;
	/** Iceberg quantity. */
	String icebergQty;

	/**
	 * 
	 * @param symbol        Symbol.
	 * @param side          Side.
	 * @param quantity      Order quantity.
	 * @param price         Order price.
	 * @param stopPrice     Order price.
	 * @param timeInForce   Order time in force.
	 * @param trailingDelta Trailing delta.
	 */
	private StopLossLimitOrder(String symbol, OrderSide side, String quantity, String price, String stopPrice,
			TimeInForce timeInForce) {
		super(symbol, side, OrderType.STOP_LOSS_LIMIT);
		this.quantity = quantity;
		this.price = price;
		this.stopPrice = stopPrice;
		this.timeInForce = timeInForce;
		this.trailingDelta = null;
	}

	/**
	 * 
	 * @param symbol        Symbol.
	 * @param side          Side.
	 * @param quantity      Order quantity.
	 * @param price         Order price.
	 * @param stopPrice     Order price.
	 * @param timeInForce   Order time in force.
	 * @param trailingDelta Trailing delta.
	 */
	private StopLossLimitOrder(String symbol, OrderSide side, String quantity, String price, Long trailingDelta,
			TimeInForce timeInForce) {
		super(symbol, side, OrderType.STOP_LOSS_LIMIT);
		this.quantity = quantity;
		this.price = price;
		this.timeInForce = timeInForce;
		this.stopPrice = null;
		this.trailingDelta = trailingDelta;
	}

	/**
	 * Creates an instance of {@link StopLossLimitOrder} in the BUY side.
	 * 
	 * @param symbol      Symbol.
	 * @param quantity    Quantity.
	 * @param price       Price.
	 * @param stopPrice   Stop price.
	 * @param timeInForce Time in force.
	 * @return An instance of {@link StopLossLimitOrder}.
	 */
	public static StopLossLimitOrder buy(String symbol, String quantity, String price, String stopPrice,
			TimeInForce timeInForce) {
		return new StopLossLimitOrder(symbol, OrderSide.BUY, quantity, price, stopPrice, timeInForce);
	}

	/**
	 * Creates an instance of {@link StopLossLimitOrder} in the SELL side.
	 * 
	 * @param symbol      Symbol.
	 * @param quantity    Quantity.
	 * @param price       Price.
	 * @param stopPrice   Stop price.
	 * @param timeInForce Time in force.
	 * @return An instance of {@link StopLossLimitOrder}.
	 */
	public static StopLossLimitOrder sell(String symbol, String quantity, String price, String stopPrice,
			TimeInForce timeInForce) {
		return new StopLossLimitOrder(symbol, OrderSide.SELL, quantity, price, stopPrice, timeInForce);
	}

	/**
	 * Creates an instance of {@link StopLossLimitOrder} in the BUY side.
	 * 
	 * @param symbol    Symbol.
	 * @param quantity  Quantity.
	 * @param price     Price.
	 * @param stopPrice Stop price.
	 * @return An instance of {@link StopLossLimitOrder}.
	 */
	public static StopLossLimitOrder buy(String symbol, String quantity, String price, String stopPrice) {
		return new StopLossLimitOrder(symbol, OrderSide.BUY, quantity, price, stopPrice, TimeInForce.GTC);
	}

	/**
	 * Creates an instance of {@link StopLossLimitOrder} in the SELL side.
	 * 
	 * @param symbol    Symbol.
	 * @param quantity  Quantity.
	 * @param price     Price.
	 * @param stopPrice Stop price.
	 * @return An instance of {@link StopLossLimitOrder}.
	 */
	public static StopLossLimitOrder sell(String symbol, String quantity, String price, String stopPrice) {
		return new StopLossLimitOrder(symbol, OrderSide.SELL, quantity, price, stopPrice, TimeInForce.GTC);
	}

	/**
	 * Creates an instance of {@link StopLossLimitOrder} in the BUY side.
	 * 
	 * @param symbol        Symbol.
	 * @param quantity      Quantity.
	 * @param price         Price.
	 * @param stopPrice     Stop price.
	 * @param trailingDelta Trailing delta.
	 * @return An instance of {@link StopLossLimitOrder}.
	 */
	public static StopLossLimitOrder buy(String symbol, String quantity, String price, Long trailingDelta) {
		return new StopLossLimitOrder(symbol, OrderSide.BUY, quantity, price, trailingDelta, TimeInForce.GTC);
	}

	/**
	 * Creates an instance of {@link StopLossLimitOrder} in the SELL side.
	 * 
	 * @param symbol        Symbol.
	 * @param quantity      Quantity.
	 * @param price         Price.
	 * @param stopPrice     Stop price.
	 * @param trailingDelta Trailing delta.
	 * @return An instance of {@link StopLossLimitOrder}.
	 */
	public static StopLossLimitOrder sell(String symbol, String quantity, String price, Long trailingDelta) {
		return new StopLossLimitOrder(symbol, OrderSide.SELL, quantity, price, trailingDelta, TimeInForce.GTC);
	}

	/**
	 * Creates an instance of {@link StopLossLimitOrder} in the BUY side.
	 * 
	 * @param symbol        Symbol.
	 * @param quantity      Quantity.
	 * @param price         Price.
	 * @param stopPrice     Stop price.
	 * @param trailingDelta Trailing delta.
	 * @return An instance of {@link StopLossLimitOrder}.
	 */
	public static StopLossLimitOrder buy(String symbol, String quantity, String price, Long trailingDelta,
			TimeInForce timeInForce) {
		return new StopLossLimitOrder(symbol, OrderSide.BUY, quantity, price, trailingDelta, timeInForce);
	}

	/**
	 * Creates an instance of {@link StopLossLimitOrder} in the SELL side.
	 * 
	 * @param symbol        Symbol.
	 * @param quantity      Quantity.
	 * @param price         Price.
	 * @param stopPrice     Stop price.
	 * @param trailingDelta Trailing delta.
	 * @return An instance of {@link StopLossLimitOrder}.
	 */
	public static StopLossLimitOrder sell(String symbol, String quantity, String price, Long trailingDelta,
			TimeInForce timeInForce) {
		return new StopLossLimitOrder(symbol, OrderSide.SELL, quantity, price, trailingDelta, timeInForce);
	}

	/**
	 * @return the quantity
	 */
	public String quantity() {
		return quantity;
	}

	/**
	 * @param quantity the quantity to set
	 */
	public StopLossLimitOrder quantity(String quantity) {
		this.quantity = quantity;
		return this;
	}

	/**
	 * @return the stopPrice
	 */
	public String stopPrice() {
		return stopPrice;
	}

	/**
	 * @param stopPrice the stopPrice to set
	 */
	public StopLossLimitOrder stopPrice(String stopPrice) {
		this.stopPrice = stopPrice;
		return this;
	}

	/**
	 * @return the trailingDelta
	 */
	public Long trailingDelta() {
		return trailingDelta;
	}

	/**
	 * @param trailingDelta the trailingDelta to set
	 */
	public StopLossLimitOrder trailingDelta(Long trailingDelta) {
		this.trailingDelta = trailingDelta;
		return this;
	}

	/**
	 * @return the price
	 */
	public String price() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public StopLossLimitOrder price(String price) {
		this.price = price;
		return this;
	}

	/**
	 * @return the timeInForce
	 */
	public TimeInForce timeInForce() {
		return timeInForce;
	}

	/**
	 * @param timeInForce the timeInForce to set
	 */
	public StopLossLimitOrder timeInForce(TimeInForce timeInForce) {
		this.timeInForce = timeInForce;
		return this;
	}

	/**
	 * @return the icebergQty
	 */
	public String icebergQty() {
		return icebergQty;
	}

	/**
	 * @param icebergQty the icebergQty to set
	 */
	public StopLossLimitOrder icebergQty(String icebergQty) {
		this.icebergQty = icebergQty;
		return this;
	}

	@Override
	public String toString() {
		return "StopLossLimitOrder [side=" + side + ", symbol=" + symbol + ", type=" + type + ", price=" + price
				+ ", quantity=" + quantity + ", stopPrice=" + stopPrice
				+ ", timeInForce=" + timeInForce + ", trailingDelta=" + trailingDelta + "]";
	}

}