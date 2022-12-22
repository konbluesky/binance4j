package com.binance4j.loan.dto;

import java.util.List;

/**
 * <p> @Date : 2022/12/22 </p>
 * <p> @Project : binance4j</p>
 *
 * <p> @author konbluesky </p>
 */
public record LoanBorrowHistoryPage(List<LoanBorrowHistory> rows, int total) {

}
