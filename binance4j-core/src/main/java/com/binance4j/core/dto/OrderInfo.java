package com.binance4j.core.dto;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Trade order information.
 * 
 * @param side                     The order side.
 * @param price                    Price.
 * @param origQuantity             Original quantity.
 * @param executedQuantity         Original quantity.
 * @param cummulativeQuoteQuantity Used to calculate the average price.
 * @param status                   Order status.
 * @param timeInForce              Time in force to indicate how long will the order remain active.
 * @param type                     Type of order.
 * @param stopPrice                Used with stop orders.
 * @param icebergQuantity          Used with iceberg orders.
 * @param time                     Order timestamp.
 * @param updateTime               Update timestamp.
 * @param origQuoteOrderQuantity   Original quote order quantity.
 * @param isWorking                is working.
 * @param isIsolated               is isolated margin.
 * @param symbol                   The order symbol.
 * @param orderId                  Order id.
 * @param clientOrderId            Client order id.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record OrderInfo(
		/** The order side */
		OrderSide side,
		/** Price. */
		BigDecimal price,
		/** Original quantity. */
		@JsonProperty("origQty") BigDecimal origQuantity,
		/** Original quantity. */
		@JsonProperty("executedQty") BigDecimal executedQuantity,
		/** Used to calculate the average price */
		@JsonProperty("cummulativeQuoteQty") BigDecimal cummulativeQuoteQuantity,
		/** Order status. */
		OrderStatus status,
		/** Time in force to indicate how long will the order remain active. */
		TimeInForce timeInForce,
		/** Type of order. */
		OrderType type,
		/** Used with stop orders. */
		BigDecimal stopPrice,
		/** Used with iceberg orders. */
		@JsonProperty("icebergQty") BigDecimal icebergQuantity,
		/** Order timestamp */
		long time,
		/** Update timestamp. */
		long updateTime,
		/** Original quote order quantity. */
		@JsonProperty("origQuoteOrderQty") BigDecimal origQuoteOrderQuantity,
		/** is working */
		boolean isWorking,
		/** is isolated margin */
		boolean isIsolated,
		/** The order symbol */
		String symbol,
		/** Order id. */
		long orderId,
		/** Client order id. */
		String clientOrderId) {
}