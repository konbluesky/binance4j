package com.binance4j.market.dto;

/**
 * Represents an executed trade history item.
 * 
 * @param id           The trade id.
 * @param price        The trad price.
 * @param qty          The trade volume.
 * @param quoteQty     The trade opposite volume.
 * @param time         The trade execution in ms.
 * @param isBuyerMaker Is the trade a buyer maker trade.
 * @param isBestMatch  Was the trade the best price match?
 */
public record Trade(long id, String price, String qty, String quoteQty, long time, boolean isBuyerMaker, boolean isBestMatch) {
}