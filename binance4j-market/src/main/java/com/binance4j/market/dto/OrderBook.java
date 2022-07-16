package com.binance4j.market.dto;

import java.util.List;

import com.binance4j.core.dto.OrderBookEntry;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

/** The market depth */
@Data
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderBook {
	/** Last update id of this order book. */
	private Long lastUpdateId;
	/** List of bids (price/qty). */
	private List<OrderBookEntry> bids;
	/** List of asks (price/qty). */
	private List<OrderBookEntry> asks;
}
