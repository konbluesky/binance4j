package com.binance4j.futures.dto;

import com.binance4j.futures.dto.filter.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/**
 * The trading rules of a symbol.
 *
 * @param lotSize             {@link LotSizeFilter}.
 * @param marketLotSize       {@link MarketLotSizeFilter}.
 * @param maxNumAlgoOrders    {@link MaxNumAlgoOrdersFilter}.
 * @param maxNumOrders        {@link MaxNumOrdersFilter}.
 * @param minNotional         {@link MinNotionalFilter}.
 * @param percentPrice        {@link PercentPriceFilter}.
 * @param price               {@link PriceFilter}.
 */
@ApiModel("The trading rules of a symbol.")
public record SymbolFilters(
                            @ApiModelProperty("LotSize filter") LotSizeFilter lotSize,
                            @ApiModelProperty("MarketLotSize filter") MarketLotSizeFilter marketLotSize,
                            @ApiModelProperty("MaxNumAlgoOrders filter") MaxNumAlgoOrdersFilter maxNumAlgoOrders,
                            @ApiModelProperty("MaxNumOrders filter") MaxNumOrdersFilter maxNumOrders,
                            @ApiModelProperty("MinNotional filter") MinNotionalFilter minNotional,
                            @ApiModelProperty("PercentPrice filter") PercentPriceFilter percentPrice,
                            @ApiModelProperty("Price filter") PriceFilter price
                            ) {
}