package com.binance4j.spot.param;

import com.binance4j.core.param.FramedParams;

/**
 * The parameters to display the user's current order count usage for all intervals.
 */
public class OrderCountParams extends FramedParams {
	/** Default constructor. */
	public OrderCountParams() {
		super(20);
	}
}