package com.binance4j.futures.serialization;

import com.binance4j.futures.dto.SymbolFilters;
import com.binance4j.futures.dto.filter.*;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.node.ArrayNode;

import java.io.IOException;

/** {@link SymbolFilters} deserializer */
public class SymbolFiltersDeserializer extends JsonDeserializer<SymbolFilters> {
	LotSizeFilter lotSizeFilter;
	MarketLotSizeFilter marketLotSizeFilter;
	MaxNumAlgoOrdersFilter maxNumAlgoOrdersFilter;
	MaxNumOrdersFilter maxNumOrdersFilter;
	MinNotionalFilter minNotionalFilter;
	PercentPriceFilter percentPriceFilter;
	PriceFilter priceFilter;

	@Override
	public SymbolFilters deserialize(JsonParser jp, DeserializationContext ctx) throws IOException {
		ObjectCodec oc = jp.getCodec();
		ArrayNode node = (ArrayNode) oc.readTree(jp);
		node.forEach(n -> {
			switch (n.get("filterType").asText()) {
				case "LOT_SIZE" -> lotSizeFilter = new LotSizeFilter(n.get("minQty").asText(), n.get("maxQty").asText(),
						n.get("stepSize").asText());
				case "MARKET_LOT_SIZE" ->
					marketLotSizeFilter = new MarketLotSizeFilter(n.get("minQty").asText(), n.get("maxQty").asText(),
							n.get("stepSize").asText());
				case "MAX_NUM_ALGO_ORDERS" ->
					maxNumAlgoOrdersFilter = new MaxNumAlgoOrdersFilter(n.get("limit").asInt());
				case "MAX_NUM_ORDERS" -> maxNumOrdersFilter = new MaxNumOrdersFilter(n.get("limit").asInt());
				case "MIN_NOTIONAL" -> minNotionalFilter = new MinNotionalFilter(n.get("notional").asText());
				case "PERCENT_PRICE" -> percentPriceFilter = new PercentPriceFilter(n.get("multiplierUp").asText(),
						n.get("multiplierDown").asText(),
						n.get("multiplierDecimal").asInt());
				case "PRICE_FILTER" -> priceFilter = new PriceFilter(n.get("minPrice").asText(),
						n.get("maxPrice").asText(), n.get("tickSize").asText());
				default -> {
				}
			}
		});
		return new SymbolFilters(lotSizeFilter, marketLotSizeFilter, maxNumAlgoOrdersFilter, maxNumOrdersFilter, minNotionalFilter, percentPriceFilter, priceFilter);
	}
}
