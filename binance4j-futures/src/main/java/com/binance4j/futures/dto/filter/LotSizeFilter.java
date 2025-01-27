package com.binance4j.futures.dto.filter;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * The quantity (aka "lots" in auction terms) rules for a symbol.
 * 
 * @param minQty   Minimum quantity/iceberg Quantity allowed.
 * @param maxQty   Maximum quantity/iceberg Quantity allowed.
 * @param stepSize Intervals that a quantity/iceberg Quantity can be
 *                 increased/decreased by.
 * @see <a href=
 *      "https://binance-docs.github.io/apidocs/spot/en/#filters">Documentation</a>
 */
@ApiModel("The quantity (aka \"lots\" in auction terms) rules for a symbol.")
public record LotSizeFilter(@ApiModelProperty("Minimum quantity/iceberg Quantity allowed.") String minQty,
		@ApiModelProperty("Maximum quantity/iceberg Quantity allowed.") String maxQty,
		@ApiModelProperty("Intervals that a quantity/iceberg Quantity can be increased/decreased by.") String stepSize) {
}