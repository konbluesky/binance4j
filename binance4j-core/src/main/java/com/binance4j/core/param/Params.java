package com.binance4j.core.param;

import java.util.Collections;
import java.util.Map;

import com.binance4j.core.dto.TimeInForce;
import com.binance4j.core.dto.WeightType;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import retrofit2.http.QueryMap;

/** The base of every Binance Request */
public class Params {
	/** Jackson object mapper used to convert a POJO into a {@link QueryMap} */
	protected static final ObjectMapper MAPPER = new ObjectMapper();
	/** The default order time in force. */
	protected TimeInForce timeInForce = TimeInForce.GTC;
	/** The default receiving window */
	public static long recvWindow = 60_000L;
	/** The request weight */
	protected int weight = 1;
	/** Is this request generating an order? */
	protected boolean isOrderRequest;
	/** The request weight type. */
	protected WeightType weightType = WeightType.IP;

	/** Constructor */
	protected Params() {
	}

	/** @param weight The Request weight */
	public Params(int weight) {
		this(weight, false);
	}

	/**
	 * @param weight         The Request weight.
	 * @param isOrderRequest Is the request a trading order.
	 */
	public Params(int weight, Boolean isOrderRequest) {
		this.weight = weight;
		this.isOrderRequest = isOrderRequest;
	}

	/**
	 * Converts the request into a {@link QueryMap}
	 *
	 * @return The generated {@link QueryMap}.
	 */
	public Map<String, Object> toMap() {
		Map<String, Object> map = MAPPER.convertValue(this, new TypeReference<Map<String, Object>>() {
		});

		// Removing null and useless parameters from the query map
		map.remove("weight");
		map.remove("weightType");
		map.remove("orderRequest");
		map.remove("isOrderRequest");
		map.values().removeAll(Collections.singleton(null));
		return map;
	}

	/** @return the recvWindow */
	public static long getRecvWindow() {
		return recvWindow;
	}

	/** @param recvWindow the recvWindow to set */
	public static void setRecvWindow(long recvWindow) {
		Params.recvWindow = recvWindow;
	}

	/** @return the weight */
	public int getWeight() {
		return weight;
	}

	/**
	 * @return the weightType
	 */
	public WeightType getWeightType() {
		return weightType;
	}

	/**
	 * @param weightType the weightType to set
	 */
	public void setWeightType(WeightType weightType) {
		this.weightType = weightType;
	}

	/**
	 * @return the timeInForce
	 */
	public TimeInForce getTimeInForce() {
		return timeInForce;
	}

	/**
	 * @param timeInForce the timeInForce to set
	 */
	public void setTimeInForce(TimeInForce timeInForce) {
		this.timeInForce = timeInForce;
	}
}