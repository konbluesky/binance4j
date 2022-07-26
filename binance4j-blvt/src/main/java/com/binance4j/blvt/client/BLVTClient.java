package com.binance4j.blvt.client;

import java.util.List;

import com.binance4j.blvt.dto.LimitInfo;
import com.binance4j.blvt.dto.Redemption;
import com.binance4j.blvt.dto.RedemptionResponse;
import com.binance4j.blvt.dto.Subscription;
import com.binance4j.blvt.dto.SubscriptionResponse;
import com.binance4j.blvt.dto.Token;
import com.binance4j.blvt.param.LimitInfoParams;
import com.binance4j.blvt.param.RedemptionParams;
import com.binance4j.blvt.param.RedemptionRecordParams;
import com.binance4j.blvt.param.SubscriptionParams;
import com.binance4j.blvt.param.SubscriptionRecordParams;
import com.binance4j.blvt.param.TokenInfoParams;
import com.binance4j.core.Request;
import com.binance4j.core.client.RestClient;

/**
 * Api client for the NFT endpoints
 * 
 * @see <a href= "https://binance-docs.github.io/apidocs/spot/en/#blvt-endpoints">Documentation</a>
 */
public class BLVTClient extends RestClient<BLVTMapping> {
	/**
	 * @param key    The API public key.
	 * @param secret The API secret key.
	 */
	public BLVTClient(String key, String secret) {
		super(BLVTMapping.class, key, secret);
	}

	/**
	 * Get BLVT Info.
	 *
	 * @param params The request params.
	 * @return The request to execute.
	 */
	public Request<List<Token>> getTokenInfo(TokenInfoParams params) {
		return new Request<>(service.getTokenInfo(params.toMap()));
	}

	/**
	 * Get BLVT Info.
	 *
	 * @return The request to execute.
	 */
	public Request<List<Token>> getTokenInfo() {
		return new Request<>(service.getTokenInfo(new TokenInfoParams().toMap()));
	}

	/**
	 * Subscribe BLVT.
	 * 
	 * @param params The request params.
	 * @return The request to execute.
	 */
	public Request<SubscriptionResponse> subscribe(SubscriptionParams params) {
		return new Request<>(service.subscribe(params.toMap()));
	}

	/**
	 * Get subscription record.
	 * 
	 * @param params The request params.
	 * @return The request to execute.
	 */
	public Request<List<Subscription>> getSubscriptions(SubscriptionRecordParams params) {
		return new Request<>(service.getSubscriptions(params.toMap()));
	}

	/**
	 * Get subscription record.
	 * 
	 * @return The request to execute.
	 */
	public Request<List<Subscription>> getSubscriptions() {
		return new Request<>(service.getSubscriptions(new SubscriptionRecordParams().toMap()));
	}

	/**
	 * Redeem BLVT.
	 * 
	 * @param params The request params.
	 * @return The request to execute.
	 */
	public Request<RedemptionResponse> redeem(RedemptionParams params) {
		return new Request<>(service.redeem(params.toMap()));
	}

	/**
	 * Get redemption record.
	 * 
	 * @param params The request params.
	 * @return The request to execute.
	 */
	public Request<List<Redemption>> getRedemptions(RedemptionRecordParams params) {
		return new Request<>(service.getRedemptions(params.toMap()));
	}

	/**
	 * Get redemption record.
	 * 
	 * @return The request to execute.
	 */
	public Request<List<Redemption>> getRedemptions() {
		return new Request<>(service.getRedemptions(new RedemptionRecordParams().toMap()));
	}

	/**
	 * Get user limit info.
	 * 
	 * @param params The request params.
	 * @return The request to LimitInfo
	 */
	public Request<List<LimitInfo>> getLimitInfo(LimitInfoParams params) {
		return new Request<>(service.getLimitInfo(params.toMap()));
	}

	/**
	 * Get user limit info.
	 * 
	 * @return The request to LimitInfo
	 */
	public Request<List<LimitInfo>> getLimitInfo() {
		return new Request<>(service.getLimitInfo(new LimitInfoParams().toMap()));
	}

}
