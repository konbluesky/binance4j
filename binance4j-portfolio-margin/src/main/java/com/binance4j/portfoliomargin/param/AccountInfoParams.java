package com.binance4j.portfoliomargin.param;

import com.binance4j.core.param.FramedParams;
import com.binance4j.portfoliomargin.client.PortfolioMarginClient;

/** The {@link PortfolioMarginClient#getAccountInfo} params */
public class AccountInfoParams extends FramedParams {

	/**
	 * Constructor
	 */
	public AccountInfoParams() {
		super(1);
	}

}