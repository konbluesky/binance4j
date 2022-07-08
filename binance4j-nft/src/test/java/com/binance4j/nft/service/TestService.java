package com.binance4j.nft.service;

import com.binance4j.nft.client.NFTClient;
import com.binance4j.nft.client.TestnetNFTClient;

/**
 * Singleton class to get unique client
 */
public class TestService implements TestService {
	public static final NFTClient CLIENT = new NFTClient(KEY, SECRET);
	public static final NFTClient TESTNETCLIENT = new TestnetNFTClient(TESTNETKEY, TESTNETSECRET);
}
