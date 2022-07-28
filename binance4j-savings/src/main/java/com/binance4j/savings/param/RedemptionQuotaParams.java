package com.binance4j.savings.param;

import com.binance4j.core.annotation.Mandatory;
import com.binance4j.core.param.Params;
import com.binance4j.savings.client.SavingsClient;
import com.binance4j.savings.dto.ProductType;

/** The {@link SavingsClient#getLeftDailyRedemptionQuota} params. */
public class RedemptionQuotaParams implements Params {
	/** The product id. */
	@Mandatory
	String productId;
	/** The product type. */
	@Mandatory
	ProductType type;

	/**
	 * @param productId The product id.
	 * @param type      The product type.
	 */
	public RedemptionQuotaParams(String productId, ProductType type) {
		this.productId = productId;
		this.type = type;
	}

	/**
	 * @return the productId
	 */
	public String getProductId() {
		return productId;
	}

	/**
	 * @param productId the productId to set
	 */
	public void setProductId(String productId) {
		this.productId = productId;
	}

	/**
	 * @return the type
	 */
	public ProductType getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(ProductType type) {
		this.type = type;
	}
}