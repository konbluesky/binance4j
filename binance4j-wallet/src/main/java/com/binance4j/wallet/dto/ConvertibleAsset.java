package com.binance4j.wallet.dto;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Asset that can be converted into BNB.
 * 
 * @param asset            The asset name.
 * @param assetFullName    The asset full name.
 * @param amountFree       The free balance.
 * @param toBTC            The BTC valuation.
 * @param toBNB            The BNB valuation.
 * @param toBNBOffExchange The BNB valuation commissions fees deducted.
 * @param exchange         Commission fees.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record ConvertibleAsset(
		/** The asset name. */
		String asset,
		/** The asset full name. */
		String assetFullName,
		/** The free balance. */
		BigDecimal amountFree,
		/** The BTC valuation. */
		BigDecimal toBTC,
		/** The BNB valuation. */
		BigDecimal toBNB,
		/** The BNB valuation commissions fees deducted. */
		BigDecimal toBNBOffExchange,
		/** Commission fees. */
		BigDecimal exchange) {
}