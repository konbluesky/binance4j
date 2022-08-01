package com.binance4j.websocket.dto;

import java.util.List;

import com.binance4j.core.dto.AssetBalance;
import com.binance4j.websocket.serialization.AssetBalanceDeserializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * Account update event which will reflect the current position/balances of the account.
 * <p>
 * This event is embedded as part of a user data update event.
 *
 * @param eventType The event type.
 * @param eventTime The timestamp.
 * @param balances  The assets balance.
 * @see UserDataUpdate
 */
public record AccountUpdate(String e, Long E, @JsonProperty("B") @JsonDeserialize(contentUsing = AssetBalanceDeserializer.class) List<AssetBalance> balances) {
}
