package com.binance4j.futures.dto.filter;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * The maximum number of orders an account is allowed to have open on a symbol.
 * Note that both "algo" orders and normal
 * orders are counted for this filter.
 * 
 * @see <a href=
 *      "https://binance-docs.github.io/apidocs/spot/en/#filters">Documentation</a>
 * @param maxNumAlgoOrders Maximum number of "algo" orders an account is allowed
 *                         to have open on a symbol. "Algo".
 *                         orders are {@code STOP_LOSS} {@code STOP_LOSS_LIMIT}
 *                         {@code TAKE_PROFIT} and
 *                         {@code TAKE_PROFIT_LIMIT} orders.
 */
@ApiModel("The maximum number of orders an account is allowed to have open on a symbol.")
public record MaxNumAlgoOrdersFilter(
		/**
		 * The maximum number of "algo" orders an account is allowed to have open on a
		 * symbol. "Algo" orders are
		 * {@code STOP_LOSS} {@code STOP_LOSS_LIMIT} {@code TAKE_PROFIT} and
		 * {@code TAKE_PROFIT_LIMIT} orders.
		 */
		@ApiModelProperty("The maximum number of \"algo\" orders an account is allowed to have open on a symbol.") int limit) {
}