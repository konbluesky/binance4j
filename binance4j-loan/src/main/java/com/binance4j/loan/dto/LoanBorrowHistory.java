package com.binance4j.loan.dto;

/**
 * <p> @Date : 2022/12/22 </p>
 * <p> @Project : binance4j</p>
 *
 * <p> @author konbluesky </p>
 */
public record LoanBorrowHistory(
        Long orderId,
        String loanCoin,
        Long initialLoanAmount,
        Double hourlyInterestRate,
        Integer loanTerm,
        String collateralCoin,
        Double initialCollateralAmount,
        Long borrowTime,
        String status
) {

}
