package com.binance4j.margin.param;

import com.binance4j.core.param.Params;
import com.binance4j.margin.client.MarginClient;

/** The {@link MarginClient#getMarginFeeData} params. */
public class CrossFeeParams extends Params {
	/** The request timestamp */
	private long timestamp = System.currentTimeMillis();
	/** The related coin */
	private final String coin;
	/** The related VIP level */
	private Integer vipLevel;

	/** Default constructor */
	public CrossFeeParams() {
		super(5);
		coin = null;
	}

	/** @param coin The related coin */
	public CrossFeeParams(String coin) {
		super();
		this.coin = coin;
	}

	/** @return the coin */
	public String getCoin() {
		return coin;
	}

	/** @return the vipLevel */
	public Integer getVipLevel() {
		return vipLevel;
	}

	/** @param vipLevel the vipLevel to set */
	public void setVipLevel(Integer vipLevel) {
		this.vipLevel = vipLevel;
	}

	/** @return the timestamp */
	public long getTimestamp() {
		return timestamp;
	}

	/** @param timestamp the timestamp to set */
	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}
}