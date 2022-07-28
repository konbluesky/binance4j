package com.binance4j.spot.param;

import com.binance4j.core.annotation.Mandatory;
import com.binance4j.core.annotation.Param;
import com.binance4j.core.param.Params;

/** The parameters to cancel an OCO request */
@Param
public class CancelOCOParams implements Params {
	/** The symbol to cancel the order. */
	@Mandatory
	String symbol;
	/** Either orderListId or listClientOrderId must be provided. */
	Long orderListId;
	/** Either orderListId or listClientOrderId must be provided. */
	String listClientOrderId;
	/** Used to uniquely identify this cancel. Automatically generated by default */
	String newClientOrderId;

	/** @param symbol The symbol to cancel the order. */
	public CancelOCOParams(String symbol) {
		this.symbol = symbol;
	}

	/**
	 * @param symbol      The symbol to cancel the order.
	 * @param orderListId The order list id.
	 */
	public CancelOCOParams(String symbol, Long orderListId) {
		this.symbol = symbol;
		this.orderListId = orderListId;
	}

	/**
	 * @param symbol            The symbol to cancel the order.
	 * @param listClientOrderId The list client order id.
	 */
	public CancelOCOParams(String symbol, String listClientOrderId) {
		this.symbol = symbol;
		this.listClientOrderId = listClientOrderId;
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
	 * @return the orderListId
	 */
	public Long getOrderListId() {
		return orderListId;
	}

	/**
	 * @param orderListId the orderListId to set
	 */
	public void setOrderListId(Long orderListId) {
		this.orderListId = orderListId;
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
