package com.binance4j.vision.dto;

import java.math.BigDecimal;
import java.util.List;

/**
 * The representation of a trade.
 * 
 * @param tradeId       Was it a buyer maker.
 * @param time          Was it a buyer maker.
 * @param price         Was it a buyer maker.
 * @param quantity      Was it a buyer maker.
 * @param quoteQuantity Was it a buyer maker.
 * @param isBuyerMaker  Was it a buyer maker.
 * @param isBestMatch   Was it the best price match?
 */
public record VisionTrade(
		/** The trade id. */
		long tradeId,
		/** The timestamp. */
		long time,
		/** The price. */
		BigDecimal price,
		/** The quantity. */
		BigDecimal quantity,
		/** The quote asset quantity. */
		BigDecimal quoteQuantity,
		/** Was it a buyer maker. */
		boolean isBuyerMaker, /** Was it the best price match? */
		boolean isBestMatch) {
	/**
	 * @param input A csv line in a list format
	 */
	public VisionTrade(List<String> input) {
		this(Long.parseLong(input.get(0)), Long.parseLong(input.get(4)), new BigDecimal(input.get(1)), new BigDecimal(input.get(2)),
				new BigDecimal(input.get(3)), Boolean.parseBoolean(input.get(5)), Boolean.parseBoolean(input.get(6)));
	}
}
