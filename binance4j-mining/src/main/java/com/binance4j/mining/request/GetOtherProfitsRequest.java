package com.binance4j.mining.request;

import com.binance4j.core.Request;
import com.binance4j.core.annotation.GetRequest;
import com.binance4j.core.dto.Signature;
import com.binance4j.mining.client.MiningClient;
import com.binance4j.mining.dto.OtherProfitsResponse;

import retrofit2.Call;

/** {@link MiningClient#getOtherProfits} request. */
@GetRequest(path = "/sapi/v1/mining/payment/other", signature = Signature.USER_DATA, weight = 5)
public class GetOtherProfitsRequest extends Request<OtherProfitsResponse> {
	/**
	 * @param call the retrofit call
	 */
	public GetOtherProfitsRequest(Call<OtherProfitsResponse> call) {
		super(call);
	}
}