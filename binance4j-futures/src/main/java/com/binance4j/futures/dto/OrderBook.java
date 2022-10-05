package com.binance4j.futures.dto;

import com.binance4j.core.dto.OrderBookEntry;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * The market depth.
 *
 * @param lastUpdateId Last update id of this order book.
 * @param bids         List of bids (price/qty).
 * @param asks         List of asks (price/qty).
 */
@ApiModel("The market depth.")
public record OrderBook(@ApiModelProperty("Last update id of this order book.") long lastUpdateId,
                        @ApiModelProperty("Message output time.") @JsonProperty("E") Long messageTime,
                        @ApiModelProperty("Transaction time.") @JsonProperty("T") String transactionTime,
                        @ApiModelProperty("List of bids (price/qty).") List<OrderBookEntry> bids,
                        @ApiModelProperty("List of asks (price/qty).") List<OrderBookEntry> asks) {

}
