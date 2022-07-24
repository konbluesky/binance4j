package com.binance4j.pay.dto;

import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * A pay transaction.
 * 
 * @param transactionId   Transaction id.
 * @param transactionTime Transaction time in ms.
 * @param amount          Transaction amount.
 * @param currency        Transaction asset.
 * @param fundsDetail     Funds details.
 * @param orderType       Order type
 *                            <ul>
 *                            <li>PAY: C2B Merchant Acquiring Payment</li>
 *                            <li>PAY_REFUND: C2B Merchant Acquiring Payment,refund</li>
 *                            <li>C2C: C2C Transfer Payment</li>
 *                            <li>CRYPTO_BOX: Crypto box</li>
 *                            <li>CRYPTO_BOX_RF: Crypto Box, refund</li>
 *                            <li>C2C_HOLDING: Transfer to new Binance user</li>
 *                            <li>C2C_HOLDING_RF: Transfer to new Binance user,refund</li>
 *                            <li>PAYOUT: B2C Disbursement Payment</li>
 *                            </ul>
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record Trade(
		/**
		 * Order type.
		 * <ul>
		 * <li>PAY: C2B Merchant Acquiring Payment</li>
		 * <li>PAY_REFUND: C2B Merchant Acquiring Payment,refund</li>
		 * <li>C2C: C2C Transfer Payment</li>
		 * <li>CRYPTO_BOX: Crypto box</li>
		 * <li>CRYPTO_BOX_RF: Crypto Box, refund</li>
		 * <li>C2C_HOLDING: Transfer to new Binance user</li>
		 * <li>C2C_HOLDING_RF: Transfer to new Binance user,refund</li>
		 * <li>PAYOUT: B2C Disbursement Payment</li>
		 * </ul>
		 */
		String orderType,
		/** Transaction id. */
		String transactionId,
		/** Transaction time in ms. */
		long transactionTime,
		/** Transaction amount. */
		BigDecimal amount,
		/** Transaction asset. */
		String currency,
		/** Funds details. */
		List<FundsDetail> fundsDetail) {
}