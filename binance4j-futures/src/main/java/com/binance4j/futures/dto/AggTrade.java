package com.binance4j.futures.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * Aggregated trades.
 */
@ApiModel(description = "Aggregated trades.")
public class AggTrade {
	/** The trade id. */
	@ApiModelProperty("The trade id")
	long tradeId;
	/** The price. */
	@ApiModelProperty("The price")
	String price;
	/** The quantity. */
	@ApiModelProperty("The quantity")
	String quantity;
	/** The first trade id. */
	@ApiModelProperty("The first trade id")
	long firstTradeId;
	/** The last trade id. */
	@ApiModelProperty("The last trade id")
	long lastTradeId;
	/** The timestamp. */
	@ApiModelProperty("The timestamp")
	long time;
	/** Was it a buyer maker. */
	@ApiModelProperty("Was it a buyer maker")
	boolean buyerMaker;
	/** Was it the best price match. */

	/** Constructor. */
	protected AggTrade() {
	}

	/**
	 * @param tradeId      Trade id
	 * @param price        Price
	 * @param quantity     Quantity
	 * @param firstTradeId First trade id
	 * @param lastTradeId  Last trade id
	 * @param time         Timestamp
	 * @param isBuyerMaker Was it a buyer maker
	 */
	public AggTrade(@JsonProperty("a") long tradeId, @JsonProperty("p") String price,
                    @JsonProperty("q") String quantity, @JsonProperty("f") long firstTradeId,
                    @JsonProperty("l") long lastTradeId, @JsonProperty("T") long time, @JsonProperty("m") Boolean isBuyerMaker
                    ) {
		this.tradeId = tradeId;
		this.price = price;
		this.quantity = quantity;
		this.firstTradeId = firstTradeId;
		this.lastTradeId = lastTradeId;
		this.time = time;
		this.buyerMaker = isBuyerMaker;
	}

	/**
	 * @param input CSV line.
	 */
	public AggTrade(List<String> input) {
		this(Long.parseLong(input.get(0)), input.get(1), input.get(2), Long.parseLong(input.get(3)),
				Long.parseLong(input.get(4)), Long.parseLong(input.get(5)),
				Boolean.parseBoolean(input.get(6)));
	}

	/**
	 * @return the tradeId
	 */
	@JsonProperty("tradeId")
	public long tradeId() {
		return tradeId;
	}

	/**
	 * @return the price
	 */
	@JsonProperty("price")
	public String price() {
		return price;
	}

	/**
	 * @return the quantity
	 */
	@JsonProperty("quantity")
	public String quantity() {
		return quantity;
	}

	/**
	 * @return the firstTradeId
	 */
	@JsonProperty("firstTradeId")
	public long firstTradeId() {
		return firstTradeId;
	}

	/**
	 * @return the lastTradeId
	 */
	@JsonProperty("lastTradeId")
	public long lastTradeId() {
		return lastTradeId;
	}

	/**
	 * @return the time
	 */
	@JsonProperty("time")
	public long time() {
		return time;
	}

	/**
	 * @return the isBuyerMaker
	 */
	@JsonProperty("isBuyerMaker")
	public boolean isBuyerMaker() {
		return buyerMaker;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (firstTradeId ^ (firstTradeId >>> 32));
		result = prime * result + (buyerMaker ? 1231 : 1237);
		result = prime * result + (int) (lastTradeId ^ (lastTradeId >>> 32));
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result + ((quantity == null) ? 0 : quantity.hashCode());
		result = prime * result + (int) (time ^ (time >>> 32));
		result = prime * result + (int) (tradeId ^ (tradeId >>> 32));
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AggTrade other = (AggTrade) obj;
		if (firstTradeId != other.firstTradeId)
			return false;
		if (buyerMaker != other.buyerMaker)
			return false;
		if (lastTradeId != other.lastTradeId)
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		if (quantity == null) {
			if (other.quantity != null)
				return false;
		} else if (!quantity.equals(other.quantity))
			return false;
		if (time != other.time)
			return false;
		if (tradeId != other.tradeId)
			return false;
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */

	@Override
	public String toString() {
		return "AggTrade [firstTradeId=" + firstTradeId +  ", isBuyerMaker=" + buyerMaker
				+ ", lastTradeId=" + lastTradeId
				+ ", price=" + price + ", quantity=" + quantity + ", time=" + time + ", tradeId=" + tradeId + "]";
	}

}