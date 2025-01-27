package com.binance4j.futures.dto.filter;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Defines valid range for a price based on the average of the previous trades.
 * avgPriceMins is the number of minutes
 * the average price is calculated over. 0 means the last price is used.
 * 
 * @param multiplierUp   Multiplier up.
 * @param multiplierDown Multiplier down.
 * @param multiplierDecimal   Multiplier Decimal.
 * @see <a href=
 *      "https://binance-docs.github.io/apidocs/spot/en/#filters">Documentation</a>
 *      *
 */
@ApiModel("Defines valid range for a price based on the average of the previous trades. avgPriceMins is the number of minutes the average price is calculated over. 0 means the last price is used.")
public record PercentPriceFilter(@ApiModelProperty("Multiplier up.") String multiplierUp,
		@ApiModelProperty("Multiplier down.") String multiplierDown,
		@ApiModelProperty("Multiplier Decimal.") int multiplierDecimal) {
}