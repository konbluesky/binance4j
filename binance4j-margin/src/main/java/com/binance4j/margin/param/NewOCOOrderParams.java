package com.binance4j.margin.param;

import com.binance4j.core.annotation.Mandatory;
import com.binance4j.core.annotation.Param;
import com.binance4j.core.dto.NewOrderResponseType;
import com.binance4j.core.dto.OrderSide;
import com.binance4j.core.dto.RateLimitType;
import com.binance4j.core.dto.TimeInForce;
import com.binance4j.core.param.Params;
import com.binance4j.margin.client.MarginClient;

/** {@link MarginClient#newOCO} params. */
@Param(type = RateLimitType.UID)
public class NewOCOOrderParams implements Params {
	/** The order symbol */
	@Mandatory
	String symbol;
	/** The order side */
	@Mandatory
	OrderSide side;
	/** The order quantity */
	@Mandatory
	String quantity;
	/** The order price */
	@Mandatory
	String price;
	/** The stop price */
	@Mandatory
	String stopPrice;
	/** The order response type Default: RESULT. */
	NewOrderResponseType newOrderRespType;
	/** A unique Id for the entire orderList */
	String listClientOrderId;
	/** A unique Id for the limit order */
	String limitClientOrderId;
	/** Used to make the LIMIT_MAKER leg an iceberg order. */
	String limitIcebergQty;
	/** A unique Id for the stop loss/stop loss limit leg */
	String stopClientOrderId;
	/** If provided, stopLimitTimeInForce is required. */
	String stopLimitPrice;
	/** Used with STOP_LOSS_LIMIT leg to make an iceberg order. */
	String stopIcebergQty;
	/** Valid values are GTC/FOK/IOC */
	TimeInForce stopLimitTimeInForce;
	/** Is the order isolated? */
	Boolean isIsolated;

	/**
	 * Produces an OCO order
	 *
	 * @param symbol    The symbol the order is made on.
	 * @param side      The order side (BUY/SELL).
	 * @param quantity  The order quantity.
	 * @param price     The order price.
	 * @param stopPrice The stop price.
	 */
	public NewOCOOrderParams(String symbol, OrderSide side, String quantity, String price, String stopPrice) {
		this.symbol = symbol;
		this.side = side;
		this.quantity = quantity;
		this.price = price;
		this.stopPrice = stopPrice;
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
	public String getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	/**
	 * @return the price
	 */
	public String getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(String price) {
		this.price = price;
	}

	/**
	 * @return the stopPrice
	 */
	public String getStopPrice() {
		return stopPrice;
	}

	/**
	 * @param stopPrice the stopPrice to set
	 */
	public void setStopPrice(String stopPrice) {
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
	 * @return the listClientOrderId
	 */
	public String getListClientOrderId() {
		return listClientOrderId;
	}

	/**
	 * @param listClientOrderId the listClientOrderId to set
	 */
	public void setListClientOrderId(String listClientOrderId) {
		this.listClientOrderId = listClientOrderId;
	}

	/**
	 * @return the limitClientOrderId
	 */
	public String getLimitClientOrderId() {
		return limitClientOrderId;
	}

	/**
	 * @param limitClientOrderId the limitClientOrderId to set
	 */
	public void setLimitClientOrderId(String limitClientOrderId) {
		this.limitClientOrderId = limitClientOrderId;
	}

	/**
	 * @return the limitIcebergQty
	 */
	public String getLimitIcebergQty() {
		return limitIcebergQty;
	}

	/**
	 * @param limitIcebergQty the limitIcebergQty to set
	 */
	public void setLimitIcebergQty(String limitIcebergQty) {
		this.limitIcebergQty = limitIcebergQty;
	}

	/**
	 * @return the stopClientOrderId
	 */
	public String getStopClientOrderId() {
		return stopClientOrderId;
	}

	/**
	 * @param stopClientOrderId the stopClientOrderId to set
	 */
	public void setStopClientOrderId(String stopClientOrderId) {
		this.stopClientOrderId = stopClientOrderId;
	}

	/**
	 * @return the stopLimitPrice
	 */
	public String getStopLimitPrice() {
		return stopLimitPrice;
	}

	/**
	 * @param stopLimitPrice the stopLimitPrice to set
	 */
	public void setStopLimitPrice(String stopLimitPrice) {
		this.stopLimitPrice = stopLimitPrice;
	}

	/**
	 * @return the stopIcebergQty
	 */
	public String getStopIcebergQty() {
		return stopIcebergQty;
	}

	/**
	 * @param stopIcebergQty the stopIcebergQty to set
	 */
	public void setStopIcebergQty(String stopIcebergQty) {
		this.stopIcebergQty = stopIcebergQty;
	}

	/**
	 * @return the stopLimitTimeInForce
	 */
	public TimeInForce getStopLimitTimeInForce() {
		return stopLimitTimeInForce;
	}

	/**
	 * @param stopLimitTimeInForce the stopLimitTimeInForce to set
	 */
	public void setStopLimitTimeInForce(TimeInForce stopLimitTimeInForce) {
		this.stopLimitTimeInForce = stopLimitTimeInForce;
	}

	/**
	 * @return the isIsolated
	 */
	public Boolean getIsIsolated() {
		return isIsolated;
	}

	/**
	 * @param isIsolated the isIsolated to set
	 */
	public void setIsIsolated(Boolean isIsolated) {
		this.isIsolated = isIsolated;
	}

}