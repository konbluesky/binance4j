package com.binance4j.spot.order;

import com.binance4j.core.param.FramedParams;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * The parameters to fetch open orders from one or all pairs
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class OpenOrdersStatusParams extends FramedParams {
	/**
	 * The pair we want the open orders
	 */
	private String symbol;

	/**
	 * Constructor toi get all open orders
	 */
	public OpenOrdersStatusParams() {
		super(1);
	}

	/**
	 * Constructor to get the open orders of a specific pair
	 *
	 * @param symbol The pair we want the open orders
	 */
	public OpenOrdersStatusParams(String symbol) {
		this();
		this.symbol = symbol;
	}
}