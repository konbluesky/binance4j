package com.binance4j.core.dto;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/** The CancelOrder request result. */
@JsonIgnoreProperties(ignoreUnknown = true)
public record CancelOrderResponse(
		/** The order status. */
		OrderStatus status,
		/** The order side. */
		OrderSide side,
		/** The order type. */
		OrderType type,
		/** The order timeInForce. */
		TimeInForce timeInForce,
		/** The order id. */
		long orderId,
		/** The order list. */
		long orderListId,
		/** The order symbol. */
		String symbol,
		/** The original client order id. */
		String origClientOrderId,
		/** The client order id. */
		String clientOrderId,
		/** The order executed quantity. */
		@JsonProperty("executedQty") String executedQuantity,
		/** The order price. */
		BigDecimal price,
		/** The order original quantity. */
		@JsonProperty("origQty") BigDecimal origQuantity,
		/** The order cumulative quote quantity. */
		@JsonProperty("cummulativeQuoteQty") BigDecimal cummulativeQuoteQuantity,
		/** Is the order margin isolated. */
		boolean isIsolated) {
}