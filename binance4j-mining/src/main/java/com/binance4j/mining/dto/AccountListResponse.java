package com.binance4j.mining.dto;

import java.util.List;

import com.binance4j.mining.client.MiningClient;

/**
 * The {@link MiningClient} response.
 * 
 * @param code The response code.
 * @param msg  The response message.
 * @param data The response data.
 */
public record AccountListResponse(int code, String msg, List<AccountData> data) {
}