package com.binance4j.spot.dto;

import java.math.BigDecimal;
import java.util.List;

import com.binance4j.core.dto.OrderSide;
import com.binance4j.core.dto.OrderStatus;
import com.binance4j.core.dto.OrderType;
import com.binance4j.core.dto.TimeInForce;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

/** The response of a SpotOrder */
@Data
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class NewOrderResponse {
	/** The trading pair to trade. */
	private String symbol;
	/** The order id. */
	private Long orderId;
	/** The order list id. */
	private Long orderListId;
	/** The client order id. */
	private String clientOrderId;
	/** The order transaction timestamp. */
	private Long transactTime;
	/** The price of trade. */
	private BigDecimal price;
	/** The original traded quantity. */
	private BigDecimal origQty;
	/** The current executed quantity. */
	private BigDecimal executedQty;
	/** The opposite coin quantity. */
	private String cummulativeQuoteQty;
	/** The order status. */
	private OrderStatus status;
	/** How long the order will remain active. */
	private TimeInForce timeInForce;
	/** The order type. */
	private OrderType type;
	/** The order side. */
	private OrderSide side;
	/** The list of trades that partially of fully filled the order. */
	private List<OrderTrade> fills;
}
