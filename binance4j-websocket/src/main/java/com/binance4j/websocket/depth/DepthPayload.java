package com.binance4j.websocket.depth;

import java.util.List;

import com.binance4j.core.dto.OrderBookEntry;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

/** The symbol order book */
@Data
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class DepthPayload {
	/** The event type. */
	@JsonProperty("e")
	private String eventType;
	/** The timestamp. */
	@JsonProperty("E")
	private Long eventTime;
	/** The trading pair. */
	@JsonProperty("s")
	private String symbol;
	/** first update id. */
	@JsonProperty("U")
	private Long firstUpdateId;
	/** last update id. */
	@JsonProperty("u")
	private Long finalUpdateId;
	/** The offers. */
	@JsonProperty("b")
	private List<OrderBookEntry> bids;
	/** The demands. */
	@JsonProperty("a")
	private List<OrderBookEntry> asks;
}