package com.binance4j.margin.param;

import com.binance4j.core.param.FramedParams;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class CancelMarginOCOParams extends FramedParams {
	private String symbol;
	private Boolean isIsolated;
	/** Either orderListId or listClientOrderId must be provided */
	private Long orderListId;
	/** Either orderListId or listClientOrderId must be provided */
	private String listClientOrderId;
	/** Used to uniquely identify this cancel. Automatically generated by default */
	private String newClientOrderId;

	public CancelMarginOCOParams(String symbol) {
		super(1);
		this.symbol = symbol;
	}
}