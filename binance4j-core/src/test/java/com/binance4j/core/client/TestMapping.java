package com.binance4j.core.client;

import retrofit2.Call;
import retrofit2.http.GET;

public interface TestMapping extends RestMapping {
	String BASE = "/api/v3/";

	@GET(BASE + "ping")
	Call<Void> ping();
}
