package com.binance4j.core.exchangeinfo;

import java.util.List;

import com.binance4j.core.order.OrderType;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * Symbol information (base/quote).
 */
@Data
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class SymbolInfo {
  /**
   * The trading status
   */
  private SymbolStatus status;
  /**
   * Types of order to submit to the system.
   */
  private List<OrderType> orderTypes;
  /**
   * Trading rules of the symbol
   */
  private List<SymbolFilter> filters;
  /**
   * The trading permissions of a symbol
   */
  private List<SymbolPermission> permissions;
  /**
   * The trading pair
   */
  private String symbol;
  /**
   * THe quote coin of the pair
   */
  private String quoteAsset;
  /**
   * The base coin of the pair
   */
  private String baseAsset;
  /**
   * The base coin precision
   */
  private Integer baseAssetPrecision;
  /**
   * The base coin commission precision
   */
  private Integer baseCommissionPrecision;
  /**
   * The quote coin precision
   */
  private Integer quoteAssetPrecision;
  /**
   * The quote coin commission precision
   */
  private Integer quoteCommissionPrecision;
  /**
   * Is iceberg trade allowed
   */
  @Getter(AccessLevel.NONE)
  @Setter(AccessLevel.NONE)
  private Boolean icebergAllowed;
  /**
   * Is coo trade allowed
   */
  @Getter(AccessLevel.NONE)
  @Setter(AccessLevel.NONE)
  private Boolean ocoAllowed;
  /**
   * Does market trading allows opening a position with quote asset quantity
   */
  @Getter(AccessLevel.NONE)
  @Setter(AccessLevel.NONE)
  private Boolean quoteOrderQtyMarketAllowed;
  /**
   * Is spot trading allowed
   */
  @Getter(AccessLevel.NONE)
  @Setter(AccessLevel.NONE)
  private Boolean isSpotTradingAllowed;
  /**
   * Is margin trading allowed
   */
  @Getter(AccessLevel.NONE)
  @Setter(AccessLevel.NONE)
  private Boolean isMarginTradingAllowed;

  /**
   * symbol filter information for the provided filter type.
   */
  public SymbolFilter getSymbolFilter(FilterType filterType) {
    return filters.stream().filter(symbolFilter -> symbolFilter.getFilterType() == filterType)
        .findFirst().orElseThrow(() -> new NullPointerException("Filter not found"));
  }

  public Boolean icebergAllowed() {
    return icebergAllowed;
  }

  public void icebergAllowed(boolean icebergAllowed) {
    this.icebergAllowed = icebergAllowed;
  }

  public Boolean isOcoAllowed() {
    return ocoAllowed;
  }

  public void isOcoAllowed(boolean ocoAllowed) {
    this.ocoAllowed = ocoAllowed;
  }

  public Boolean isQuoteOrderQtyMarketAllowed() {
    return quoteOrderQtyMarketAllowed;
  }

  public void isQuoteOrderQtyMarketAllowed(boolean quoteOrderQtyMarketAllowed) {
    this.quoteOrderQtyMarketAllowed = quoteOrderQtyMarketAllowed;
  }

  public Boolean isSpotTradingAllowed() {
    return isSpotTradingAllowed;
  }

  public void isSpotTradingAllowed(boolean isSpotTradingAllowed) {
    this.isSpotTradingAllowed = isSpotTradingAllowed;
  }

  public Boolean isMarginTradingAllowed() {
    return isMarginTradingAllowed;
  }

  public void isMarginTradingAllowed(boolean isMarginTradingAllowed) {
    this.isMarginTradingAllowed = isMarginTradingAllowed;
  }
}
