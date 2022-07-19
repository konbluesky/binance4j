package com.binance4j.market.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * A wrapper for the server time
 * 
 * @param serverTime The server time in ms.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record ServerTimeResponse(
		/** The server time in ms. */
		long serverTime) {
}