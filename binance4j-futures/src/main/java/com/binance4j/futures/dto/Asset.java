package com.binance4j.futures.dto;

import io.swagger.annotations.ApiModel;

/**
 * <p> @Date : 2022/9/26 </p>
 * <p> @Project : binance4j</p>
 *
 * <p> @author konbluesky </p>
 */
@ApiModel("Asset Information")
public record Asset(String asset, boolean marginAvailable, String autoAssetExchange) {

}
