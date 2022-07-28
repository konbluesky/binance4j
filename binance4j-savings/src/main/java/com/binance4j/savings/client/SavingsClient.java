package com.binance4j.savings.client;

import java.util.List;

import com.binance4j.core.Request;
import com.binance4j.core.client.RestClient;
import com.binance4j.savings.dto.FixedProject;
import com.binance4j.savings.dto.FixedProjectPosition;
import com.binance4j.savings.dto.FlexibleProduct;
import com.binance4j.savings.dto.FlexibleProductPosition;
import com.binance4j.savings.dto.Interest;
import com.binance4j.savings.dto.LendingAccount;
import com.binance4j.savings.dto.PositionChangedResponse;
import com.binance4j.savings.dto.Purchase;
import com.binance4j.savings.dto.PurchaseQuota;
import com.binance4j.savings.dto.PurchaseResponse;
import com.binance4j.savings.dto.Redemption;
import com.binance4j.savings.dto.RedemptionQuota;
import com.binance4j.savings.param.ChangePositionParams;
import com.binance4j.savings.param.FixedProjectListParams;
import com.binance4j.savings.param.FixedProjectPositionParams;
import com.binance4j.savings.param.FixedPurchaseParams;
import com.binance4j.savings.param.FlexibleProductPositionParams;
import com.binance4j.savings.param.FlexibleProductsParams;
import com.binance4j.savings.param.FlexiblePurchaseParams;
import com.binance4j.savings.param.LendingAccountParams;
import com.binance4j.savings.param.LendingParams;
import com.binance4j.savings.param.PurchaseQuotaParams;
import com.binance4j.savings.param.RedemptionParams;
import com.binance4j.savings.param.RedemptionQuotaParams;

/**
 * Api client for the savings endpoints
 * 
 * @see <a href= "https://binance-docs.github.io/apidocs/spot/en/#savings-endpoints">Documentation</a>
 */
public class SavingsClient extends RestClient<SavingsMapping> {
	/**
	 * @param key    The API public key.
	 * @param secret The API secret key.
	 */
	public SavingsClient(String key, String secret) {
		super(SavingsMapping.class, key, secret);
	}

	/**
	 * Get flexible product list.
	 *
	 * @param params The request params.
	 * @return The request to execute.
	 */
	public Request<List<FlexibleProduct>> getFlexibleProducts(FlexibleProductsParams params) {
		return new Request<>(service.getFlexibleProducts(params.toMap()));
	}

	/**
	 * Get flexible product list.
	 *
	 * @return The request to execute.
	 */
	public Request<List<FlexibleProduct>> getFlexibleProducts() {
		return new Request<>(service.getFlexibleProducts(new FlexibleProductsParams().toMap()));
	}

	/**
	 * Get left daily purchase quota of flexible product.
	 * 
	 * @param params The request params.
	 * @return The request to execute.
	 */
	public Request<PurchaseQuota> getLeftDailyFlexiblePurchaseQuota(PurchaseQuotaParams params) {
		return new Request<>(service.getLeftDailyFlexiblePurchaseQuota(params.toMap()));
	}

	/**
	 * Purchase Flexible Product.
	 * 
	 * @param params The request params.
	 * @return The request to execute.
	 */
	public Request<PurchaseResponse> purchaseFlexible(FlexiblePurchaseParams params) {
		return new Request<>(service.purchaseFlexible(params.toMap()));
	}

	/**
	 * Get Left Daily Redemption Quota of Flexible Product.
	 * 
	 * @param params The request params.
	 * @return The request to execute.
	 */
	public Request<RedemptionQuota> getLeftDailyRedemptionQuota(RedemptionQuotaParams params) {
		return new Request<>(service.getLeftDailyRedemptionQuota(params.toMap()));
	}

	/**
	 * Redeem Flexible Product.
	 * 
	 * @param params The request params.
	 * @return The request to execute.
	 */
	public Request<Void> redeemFlexible(RedemptionParams params) {
		return new Request<>(service.redeemFlexible(params.toMap()));
	}

	/**
	 * Get flexible product position.
	 * 
	 * @param params The request params.
	 * @return The request to execute.
	 */
	public Request<List<FlexibleProductPosition>> getFlexibleProductPosition(FlexibleProductPositionParams params) {
		return new Request<>(service.getFlexibleProductPosition(params.toMap()));
	}

	/**
	 * Get flexible product position.
	 *
	 * @return The request to execute.
	 */
	public Request<List<FlexibleProductPosition>> getFlexibleProductPosition() {
		return new Request<>(service.getFlexibleProductPosition(new FlexibleProductPositionParams().toMap()));
	}

	/**
	 * Get fixed and activity project list.
	 * 
	 * @param params The request params.
	 * @return The request to execute.
	 */
	public Request<List<FixedProject>> getFixedProjects(FixedProjectListParams params) {
		return new Request<>(service.getFixedProjects(params.toMap()));
	}

	/**
	 * Purchase fixed project.
	 * 
	 * @param params The request params.
	 * @return The request to execute.
	 */
	public Request<PurchaseResponse> purchaseFixed(FixedPurchaseParams params) {
		return new Request<>(service.purchaseFixed(params.toMap()));
	}

	/**
	 * Get fixed/activity project position.
	 * 
	 * @param params The request params.
	 * @return The request to execute.
	 */
	public Request<List<FixedProjectPosition>> getFixedProjectPosition(FixedProjectPositionParams params) {
		return new Request<>(service.getFixedProjectPosition(params.toMap()));
	}

	/**
	 * Get lending account.
	 * 
	 * @param params The request params.
	 * @return The request to execute.
	 */
	public Request<LendingAccount> getAccount(LendingAccountParams params) {
		return new Request<>(service.getAccount(params.toMap()));
	}

	/**
	 * Get lending account.
	 *
	 * @return The request to execute.
	 */
	public Request<LendingAccount> getAccount() {
		return new Request<>(service.getAccount(new LendingAccountParams().toMap()));
	}

	/**
	 * Get purchase record.
	 * 
	 * @param params The request params.
	 * @return The request to execute.
	 */
	public Request<List<Purchase>> getPurchases(LendingParams params) {
		return new Request<>(service.getPurchases(params.toMap()));
	}

	/**
	 * Get redemption record.
	 * 
	 * @param params The request params.
	 * @return The request to execute.
	 */
	public Request<List<Redemption>> getRedemptions(LendingParams params) {
		return new Request<>(service.getRedemptions(params.toMap()));
	}

	/**
	 * Get interest record.
	 * 
	 * @param params The request params.
	 * @return The request to execute.
	 */
	public Request<List<Interest>> getInterests(LendingParams params) {
		return new Request<>(service.getInterests(params.toMap()));
	}

	/**
	 * Get interest record.
	 * 
	 * @param params The request params.
	 * @return The request to execute.
	 */
	public Request<PositionChangedResponse> fixedToDailyPosition(ChangePositionParams params) {
		return new Request<>(service.fixedToDailyPosition(params.toMap()));
	}
}