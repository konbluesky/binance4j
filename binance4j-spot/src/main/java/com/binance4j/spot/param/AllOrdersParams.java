package com.binance4j.spot.param;

import com.binance4j.core.param.IntervalParams;

/** The parameters to display past orders */
public class AllOrdersParams extends IntervalParams {
	/** The trading pair we want the orders. */
	private String symbol;
	/**
	 * If orderId is set, it will get orders &gt;= that orderId. Otherwise, most recent orders are returned. If startTime
	 * and/or endTime provided, orderId is not required.
	 */
	private Long orderId;

	/** The result size. Default 500; max 1000. */
	private Integer limit = 500;

	/**
	 * Default constructor.
	 *
	 * @param symbol The symbol we want the orders.
	 */
	public AllOrdersParams(String symbol) {
		super(10);
		this.symbol = symbol;
	}

	/**
	 * Default constructor
	 *
	 * @param symbol The symbol we want the orders.
	 * @param limit  The result limit.
	 */
	public AllOrdersParams(String symbol, Integer limit) {
		this(symbol);
		this.limit = limit;
	}

	/**
	 * with search after orderId
	 *
	 * @param symbol  The symbol we want the orders.
	 * @param orderId The order id to get &gt;= orders.
	 */
	public AllOrdersParams(String symbol, long orderId) {
		this(symbol);
		this.orderId = orderId;
	}

	/**
	 * with startTime and endTime
	 *
	 * @param symbol    The symbol we want the orders.
	 * @param startTime The starting time of results.
	 * @param endTime   The ending time of results.
	 */
	public AllOrdersParams(String symbol, long startTime, long endTime) {
		this(symbol);
		this.setStartTime(startTime);
		this.setEndTime(endTime);
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
	 * @return the orderId
	 */
	public Long getOrderId() {
		return orderId;
	}

	/**
	 * @param orderId the orderId to set
	 */
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	/**
	 * @return the limit
	 */
	public Integer getLimit() {
		return limit;
	}

	/**
	 * @param limit the limit to set
	 */
	public void setLimit(Integer limit) {
		this.limit = limit;
	}

}