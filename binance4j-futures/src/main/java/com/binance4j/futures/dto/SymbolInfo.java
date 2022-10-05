package com.binance4j.futures.dto;

import com.binance4j.futures.serialization.SymbolFiltersDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * Symbol information (base/quote).
 *
 * @param status                     Symbol status.
// * @param orderTypes                 Allowed orders on the symbol*.
// * @param filters                    Symbol filters.
// * @param permissions                Symbol permission.
 * @param symbol                     Symbol name.
 * @param quoteAsset                 Quote asset.
 * @param baseAsset                  Base asset.
// * @param baseAssetPrecision         Base asset precision.
// * @param baseCommissionPrecision    Base asset commission precision.
// * @param quoteAssetPrecision        Quote asset precision.
// * @param quotePrecision             Quote asset precision.
// * @param quoteCommissionPrecision   Quote asset commission precision.
// * @param icebergAllowed             Are iceberg orders allowed?
// * @param ocoAllowed                 Are OCO orders allowed?
// * @param quoteOrderQtyMarketAllowed Are orders by quote quantity allowed?
// * @param cancelReplaceAllowed       Cancel replace allowed?
// * @param allowTrailingStop          Is spot trading allowed?
// * @param isSpotTradingAllowed       Is trailing stop allowed?
// * @param isMarginTradingAllowed     Is margin trading allowed?
 * @see <a href=
 *      "https://binance-docs.github.io/apidocs/futures/cn/#0f3f2d5ee7"></a>
 */
@ApiModel("Symbol information (base/quote).")
public record SymbolInfo(
                         @ApiModelProperty("Symbol permission.") String symbol,
                         @ApiModelProperty("Underlying trading pair.") String pair,
                         @ApiModelProperty("Contract type.") String contractType,
                         @ApiModelProperty("Delivery date") String deliveryDate,
                         @ApiModelProperty("Launch date.") String onboardDate,
                         /* official advice ignore */
                         // maintMarginPercent,requiredMarginPercent
                         @ApiModelProperty("Base assets.") String baseAsset,
                         @ApiModelProperty("Quoted assets.") String quoteAsset,
                         @ApiModelProperty("Margin assets.") String marginAsset,


                         @ApiModelProperty("Effective way.") List<String> timeInForce,
                         @ApiModelProperty("Liquidation rate.") String liquidationFee,
                         @ApiModelProperty("The maximum allowable price deviation ratio (relative to the mark price) for a market taker order.") String marketTakeBound,
                         @ApiModelProperty("Is margin trading allowed?") String status,
                         @ApiModelProperty("价格小数点位数(仅作为系统精度使用，注意同tickSize 区分）") int pricePrecision,
                         @ApiModelProperty("数量小数点位数(仅作为系统精度使用，注意同stepSize 区分）") int quantityPrecision,
                         @ApiModelProperty("标的资产精度") int baseAssetPrecision,
                         @ApiModelProperty("报价资产精度") int quotePrecision,
                         @ApiModelProperty("") String underlyingType,
                         @ApiModelProperty("") List<String> underlyingSubType,

                         @ApiModelProperty("") int settlePlan,
                         @ApiModelProperty("Trigger threshold for conditional orders with 'price Protect' enabled") String triggerProtect,
                         @ApiModelProperty("Allowed orders on the symbol*.") @JsonDeserialize(using = SymbolFiltersDeserializer.class) SymbolFilters filters,
                         @ApiModelProperty("Symbol status.") List<String> OrderType

){

//                         @ApiModelProperty("Allowed orders on the symbol*.") @JsonDeserialize(using = SymbolFiltersDeserializer.class) SymbolFilters filters,
//                         @ApiModelProperty("Symbol filters.") List<String> permissions,
//                         @ApiModelProperty("Base asset.") int baseAssetPrecision,
//                         @ApiModelProperty("Base asset precision.") int baseCommissionPrecision,
//                         @ApiModelProperty("Quote asset commission precision.") int quoteAssetPrecision,
//                         @ApiModelProperty("Quote asset commission precision.") int quotePrecision,
//                         @ApiModelProperty("Quote asset precision.") int quoteCommissionPrecision,
//                         @ApiModelProperty("Quote asset commission precision.") boolean icebergAllowed,
//                         @ApiModelProperty("Are iceberg orders allowed?") boolean ocoAllowed,
//                         @ApiModelProperty("Are OCO orders allowed?") boolean quoteOrderQtyMarketAllowed,
//                         @ApiModelProperty("Are orders by quote quantity allowed?") boolean isSpotTradingAllowed,
//                         @ApiModelProperty("Cancel replace allowed?") boolean cancelReplaceAllowed,
//                         @ApiModelProperty("Is trailing stop allowed?") boolean allowTrailingStop,
//                         @ApiModelProperty("Is spot trading allowed?") boolean isMarginTradingAllowed,
//                         @ApiModelProperty("Is margin trading allowed?") String status) {
}