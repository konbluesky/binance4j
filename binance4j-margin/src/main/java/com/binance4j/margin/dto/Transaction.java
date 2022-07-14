package com.binance4j.margin.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * MarginTransaction information.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record Transaction(
		@JsonProperty("tranId") String transactionId) {
}