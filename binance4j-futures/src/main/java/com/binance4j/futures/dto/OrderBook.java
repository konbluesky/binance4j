package com.binance4j.futures.dto;

import com.binance4j.core.dto.OrderBookEntry;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * The market depth.
 *
 * @param lastUpdateId Last update id of this order book.
 * @param bids         List of bids (price/qty).
 * @param asks         List of asks (price/qty).
 *
 * @see <a href="https://binance-docs.github.io/apidocs/futures/cn/#38a975b802"></a>
 */
@ApiModel("The market depth.")
@Slf4j
public record OrderBook(@ApiModelProperty("Last update id of this order book.") long lastUpdateId,
                        @ApiModelProperty("Message output time.") @JsonProperty("E") Long messageTime,
                        @ApiModelProperty("Transaction time.") @JsonProperty("T") String transactionTime,
                        @ApiModelProperty("List of bids (price/qty).") List<OrderBookEntry> bids,
                        @ApiModelProperty("List of asks (price/qty).") List<OrderBookEntry> asks) {

    public double getFirstAsk() {
        return Double.parseDouble(asks().get(0).price());
    }
}
