package com.binance4j.loan.dto;

import com.binance4j.core.param.Params;

/**
 * <p> @Date : 2022/12/22 </p>
 * <p> @Project : binance4j</p>
 * <p>
 * {
 * "loanCoin": "BUSD",
 * "loanAmount": "100.5",
 * "collateralCoin": "BNB",
 * "collateralAmount": "50.5",
 * "hourlyInterestRate": "0.001234",
 * "orderId": "100000001"
 * }
 * <p> @author konbluesky </p>
 */
public record LoanBorrow(String loanCoin, Double loanAmount, String collateralCoin,
                         Double collateralAmount,
                         Double hourlyInterestRate,
                         Long orderId) {

}
