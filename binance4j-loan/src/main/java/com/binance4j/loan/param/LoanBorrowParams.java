package com.binance4j.loan.param;

import com.binance4j.core.annotation.Param;
import com.binance4j.core.dto.RateLimitType;
import com.binance4j.core.param.Params;

/**
 * <p> @Date : 2022/12/22 </p>
 * <p> @Project : binance4j</p>
 *
 * <p> @author konbluesky </p>
 */
@Param(weight = 6000, type = RateLimitType.UID)
public record LoanBorrowParams(String loanCoin, Double loanAmount, String collateralCoin, Double collateralAmount, Integer loanTerm) implements Params {

    public LoanBorrowParams(String loanCoin, String collateralCoin, Integer loanTerm) {
        this(loanCoin, null, collateralCoin, null, loanTerm);
    }
}
