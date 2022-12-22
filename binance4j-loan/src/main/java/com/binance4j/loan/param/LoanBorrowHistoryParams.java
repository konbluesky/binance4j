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
@Param(weight = 400, type = RateLimitType.UID)
public record LoanBorrowHistoryParams(Long orderId, String loanCoin, String collateralCoin) implements Params {

    public LoanBorrowHistoryParams() {
        this(null, null, null);
    }

}
