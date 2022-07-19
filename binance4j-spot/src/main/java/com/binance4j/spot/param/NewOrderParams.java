package com.binance4j.spot.param;

import java.math.BigDecimal;

import com.binance4j.core.client.RestClientConfiguration;
import com.binance4j.core.dto.NewOrderResponseType;
import com.binance4j.core.dto.OrderSide;
import com.binance4j.core.dto.OrderType;
import com.binance4j.core.dto.TimeInForce;
import com.binance4j.core.param.FramedParams;
import com.fasterxml.jackson.annotation.JsonProperty;

/** An order to open or close a position */
public class NewOrderParams extends FramedParams {
	/** The order symbol */
	private String symbol;
	/** The order side */
	private OrderSide side;
	/** The order quantity */
	private BigDecimal quantity;
	/** The order price */
	private BigDecimal price;
	/** The stop price */
	private BigDecimal stopPrice;
	/** The order response type Default: RESULT. */
	private NewOrderResponseType newOrderRespType;
	/** The order type */
	private OrderType type;
	/** Le order lifetime */
	private TimeInForce timeInForce;
	/** The quote order quantity */
	@JsonProperty("quoteOrderQty")
	private BigDecimal quoteOrderQuantity;
	/** The iceberg quantity */
	@JsonProperty("icebergQty")
	private BigDecimal icebergQuantity;
	/** The order unique id. Else is produced automatically. */
	private String newClientOrderId;
	/** Stop Limit price. */
	BigDecimal stopLimitPrice;

	private NewOrderParams() {
		super(1, true);
	}

	/**
	 * Produces an order without a price
	 *
	 * @param symbol      the asset pair on which to place the order.
	 * @param type        the order type.
	 * @param side        order direction.
	 * @param quantity    the quantity of the order.
	 * @param timeInForce the lifetime of the order.
	 */
	public NewOrderParams(String symbol, OrderType type, OrderSide side, BigDecimal quantity, TimeInForce timeInForce) {
		this();
		this.type = type;
		this.symbol = symbol;
		this.side = side;
		this.quantity = quantity;
		this.timeInForce = timeInForce;
	}

	/**
	 * Produces an order with a price
	 *
	 * @param symbol      the asset pair on which to place the order.
	 * @param type        the order type.
	 * @param side        the direction of the order.
	 * @param quantity    the quantity of the order.
	 * @param price       the order price.
	 * @param timeInForce the lifetime of the order.
	 */
	public NewOrderParams(String symbol, OrderType type, OrderSide side, BigDecimal quantity, BigDecimal price, TimeInForce timeInForce) {
		this(symbol, type, side, quantity, timeInForce);
		this.price = price;
	}

	/**
	 * Produces an order without price with time in force GTC by default
	 *
	 * @param symbol   the asset pair on which to place the order.
	 * @param type     the order type.
	 * @param side     the direction of the order.
	 * @param quantity the quantity of the order.
	 */
	public NewOrderParams(String symbol, OrderType type, OrderSide side, BigDecimal quantity) {
		this(symbol, type, side, quantity, RestClientConfiguration.getDefaultTimeInforce());
	}

	/**
	 * Produces an order with a default price and time in force GTC
	 *
	 * @param symbol   the asset pair on which to place the order.
	 * @param type     the order type.
	 * @param side     the direction of the order.
	 * @param quantity the quantity of the order.
	 * @param price    the order price.
	 */
	public NewOrderParams(String symbol, OrderType type, OrderSide side, BigDecimal quantity, BigDecimal price) {
		this(symbol, type, side, quantity, price, RestClientConfiguration.getDefaultTimeInforce());
	}

	// STATIQUE //

	/**
	 * Produces a MARKET buy order
	 *
	 * @param symbol      The asset pair.
	 * @param quantity    The quantity.
	 * @param timeInForce The lifetime of the order.
	 * @return The order to execute.
	 */
	public static NewOrderParams buyMarket(String symbol, BigDecimal quantity, TimeInForce timeInForce) {
		return new NewOrderParams(symbol, OrderType.MARKET, OrderSide.BUY, quantity, timeInForce);
	}

	/**
	 * Produces a MARKET buy order
	 *
	 * @param symbol   The asset pair.
	 * @param quantity The quantity.
	 * @return The order to execute.
	 */
	public static NewOrderParams buyMarket(String symbol, BigDecimal quantity) {
		return buyMarket(symbol, quantity, RestClientConfiguration.getDefaultTimeInforce());
	}

	/**
	 * Produces a MARKET order
	 *
	 * @param symbol      The asset pair.
	 * @param quantity    The quantity.
	 * @param timeInForce The lifetime of the order.
	 * @return The order to execute.
	 */
	public static NewOrderParams sellMarket(String symbol, BigDecimal quantity, TimeInForce timeInForce) {
		return new NewOrderParams(symbol, OrderType.MARKET, OrderSide.SELL, quantity, timeInForce);
	}

	/**
	 * Produces a MARKET order
	 *
	 * @param symbol   The asset pair.
	 * @param quantity The quantity.
	 * @return The order to execute.
	 */
	public static NewOrderParams sellMarket(String symbol, BigDecimal quantity) {
		return sellMarket(symbol, quantity, RestClientConfiguration.getDefaultTimeInforce());
	}

	/**
	 * Produces a LIMIT buy order
	 *
	 * @param symbol      The asset pair.
	 * @param quantity    The quantity.
	 * @param price       The purchase price.
	 * @param timeInForce The lifetime of the order.
	 * @return The order to execute.
	 */
	public static NewOrderParams buyLimit(String symbol, BigDecimal quantity, BigDecimal price, TimeInForce timeInForce) {
		return new NewOrderParams(symbol, OrderType.LIMIT, OrderSide.BUY, quantity, price, timeInForce);
	}

	/**
	 * Produces a LIMIT buy order
	 *
	 * @param symbol   The asset pair.
	 * @param quantity The quantity.
	 * @param price    The purchase price.
	 * @return The order to execute.
	 */
	public static NewOrderParams buyLimit(String symbol, BigDecimal quantity, BigDecimal price) {
		return buyLimit(symbol, quantity, price, RestClientConfiguration.getDefaultTimeInforce());
	}

	/**
	 * Produces a sell LIMIT order
	 *
	 * @param symbol      The asset pair.
	 * @param quantity    The quantity.
	 * @param price       The selling price.
	 * @param timeInForce The lifetime of the order.
	 * @return The order to execute.
	 */
	public static NewOrderParams sellLimit(String symbol, BigDecimal quantity, BigDecimal price, TimeInForce timeInForce) {
		return new NewOrderParams(symbol, OrderType.LIMIT, OrderSide.SELL, quantity, price, timeInForce);
	}

	/**
	 * Produces a sell LIMIT order
	 *
	 * @param symbol   The asset pair.
	 * @param quantity The quantity.
	 * @param price    The purchase prices.
	 * @return The order to execute.
	 */
	public static NewOrderParams sellLimit(String symbol, BigDecimal quantity, BigDecimal price) {
		return sellLimit(symbol, quantity, price, RestClientConfiguration.getDefaultTimeInforce());
	}

	// QUOTE ORDERS

	/**
	 * Produces a MARKET buy order with quote quantity
	 *
	 * @param symbol      The asset pair.
	 * @param quantity    The quantity.
	 * @param timeInForce The lifetime of the order.
	 * @return The order to execute.
	 */
	public static NewOrderParams buyQuote(String symbol, BigDecimal quantity, TimeInForce timeInForce) {
		NewOrderParams order = new NewOrderParams(symbol, OrderType.MARKET, OrderSide.BUY, null, timeInForce);
		order.setQuoteOrderQuantity(quantity);
		return order;
	}

	/**
	 * Produces a MARKET buy order with quote quantity and default timeInForce
	 *
	 * @param symbol   The asset pair.
	 * @param quantity The quantity.
	 * @return The order to execute.
	 */
	public static NewOrderParams buyQuote(String symbol, BigDecimal quantity) {
		return buyQuote(symbol, quantity, RestClientConfiguration.getDefaultTimeInforce());
	}

	/**
	 * Produces a MARKET order with quote quantity
	 *
	 * @param symbol      The asset pair.
	 * @param quantity    The quantity.
	 * @param timeInForce The lifetime of the order.
	 * @return The order to execute.
	 */
	public static NewOrderParams sellQuote(String symbol, BigDecimal quantity, TimeInForce timeInForce) {
		NewOrderParams order = new NewOrderParams(symbol, OrderType.MARKET, OrderSide.SELL, null, timeInForce);
		order.setQuoteOrderQuantity(quantity);
		return order;
	}

	/**
	 * Produces a MARKET order with quote quantity and default timeInForce
	 *
	 * @param symbol   The asset pair.
	 * @param quantity The quantity.
	 * @return The order to execute.
	 */
	public static NewOrderParams sellQuote(String symbol, BigDecimal quantity) {
		return sellQuote(symbol, quantity, RestClientConfiguration.getDefaultTimeInforce());
	}

	/**
	 * @return the stopLimitPrice
	 */
	public BigDecimal getStopLimitPrice() {
		return stopLimitPrice;
	}

	/**
	 * @param stopLimitPrice the stopLimitPrice to set
	 */
	public void setStopLimitPrice(BigDecimal stopLimitPrice) {
		this.stopLimitPrice = stopLimitPrice;
	}

	/**
	 * @return the symbol
	 */
	public String getSymbol() {
		return symbol;
	}

	/**
	 * @param symbol the symbol to set
	 */
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	/**
	 * @return the side
	 */
	public OrderSide getSide() {
		return side;
	}

	/**
	 * @param side the side to set
	 */
	public void setSide(OrderSide side) {
		this.side = side;
	}

	/**
	 * @return the quantity
	 */
	public BigDecimal getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}

	/**
	 * @return the price
	 */
	public BigDecimal getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	/**
	 * @return the stopPrice
	 */
	public BigDecimal getStopPrice() {
		return stopPrice;
	}

	/**
	 * @param stopPrice the stopPrice to set
	 */
	public void setStopPrice(BigDecimal stopPrice) {
		this.stopPrice = stopPrice;
	}

	/**
	 * @return the newOrderRespType
	 */
	public NewOrderResponseType getNewOrderRespType() {
		return newOrderRespType;
	}

	/**
	 * @param newOrderRespType the newOrderRespType to set
	 */
	public void setNewOrderRespType(NewOrderResponseType newOrderRespType) {
		this.newOrderRespType = newOrderRespType;
	}

	/**
	 * @return the type
	 */
	public OrderType getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(OrderType type) {
		this.type = type;
	}

	/**
	 * @return the timeInForce
	 */
	public TimeInForce getTimeInForce() {
		return timeInForce;
	}

	/**
	 * @param timeInForce the timeInForce to set
	 */
	public void setTimeInForce(TimeInForce timeInForce) {
		this.timeInForce = timeInForce;
	}

	/**
	 * @return the quoteOrderQuantity
	 */
	public BigDecimal getQuoteOrderQuantity() {
		return quoteOrderQuantity;
	}

	/**
	 * @param quoteOrderQuantity the quoteOrderQuantity to set
	 */
	public void setQuoteOrderQuantity(BigDecimal quoteOrderQuantity) {
		this.quoteOrderQuantity = quoteOrderQuantity;
	}

	/**
	 * @return the icebergQuantity
	 */
	public BigDecimal getIcebergQuantity() {
		return icebergQuantity;
	}

	/**
	 * @param icebergQuantity the icebergQuantity to set
	 */
	public void setIcebergQuantity(BigDecimal icebergQuantity) {
		this.icebergQuantity = icebergQuantity;
	}

	/**
	 * @return the newClientOrderId
	 */
	public String getNewClientOrderId() {
		return newClientOrderId;
	}

	/**
	 * @param newClientOrderId the newClientOrderId to set
	 */
	public void setNewClientOrderId(String newClientOrderId) {
		this.newClientOrderId = newClientOrderId;
	}

}