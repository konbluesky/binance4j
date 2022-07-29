package com.binance4j.nft.param;

import com.binance4j.core.annotation.Param;
import com.binance4j.core.dto.RateLimitType;
import com.binance4j.core.param.Params;
import com.binance4j.nft.client.NFTClient;

/** {@link NFTClient#getAssets} params. */

@Param(weight = 3000, type = RateLimitType.UID)
public record AssetParams() implements Params {
}