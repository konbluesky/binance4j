package com.binance4j.wallet.dto;

import java.util.List;

/** The response of a MARGIN account snapshot request */
public record MarginAccountSnapshotResponse(
		/** The response status code (200 for success; others are error codes) */
		int code,
		/** The potential response error message. */
		String msg,
		/** A list of account snapshots. */
		List<MarginAccountSnapshot> snapshotVos) implements AccountSnapshotResponse<MarginAccountSnapshot> {
}