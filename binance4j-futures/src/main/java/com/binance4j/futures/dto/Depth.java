package com.binance4j.futures.dto;

import com.binance4j.core.dto.OrderBookEntry;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * The symbol order book.
 * @param messageTime
 * @param transactionTime
 * @param lastUpdateId
 * @param bids
 * @param asks
 */
@ApiModel("The symbol order book.")
public record Depth(

                    @ApiModelProperty("Last update id.") @JsonProperty("lastUpdateId") Long lastUpdateId,
                    @ApiModelProperty("Offers.") List<OrderBookEntry> bids,
                    @ApiModelProperty("Demands.") List<OrderBookEntry> asks) {
}