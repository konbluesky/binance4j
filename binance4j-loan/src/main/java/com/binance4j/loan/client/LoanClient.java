package com.binance4j.loan.client;

import java.util.List;
import java.util.Map;

import com.binance4j.core.Request;
import com.binance4j.core.client.RestClient;
import com.binance4j.core.param.Paging;
import com.binance4j.core.param.Params;
import com.binance4j.core.param.TimeFrame;
import com.binance4j.loan.dto.LoanBorrow;
import com.binance4j.loan.dto.LoanBorrowHistory;
import com.binance4j.loan.dto.LoanBorrowHistoryPage;
import com.binance4j.loan.dto.LoanIncome;
import com.binance4j.loan.param.LoanBorrowHistoryParams;
import com.binance4j.loan.param.LoanBorrowParams;
import com.binance4j.loan.param.LoanIncomeHistoryParams;

/**
 * Api client for the loan endpoints
 *
 * @see <a href=
 *      "https://binance-docs.github.io/apidocs/spot/en/#pay-endpoints">Documentation</a>
 */
public class LoanClient extends RestClient<LoanMapping> {
	/**
	 * @param key    API public key.
	 * @param secret API secret key.
	 */
	public LoanClient(String key, String secret) {
		super(LoanMapping.class, key, secret);
	}

	/**
	 * Get crypto loans income history.
	 *
	 * @param params    Request params.
	 * @param timeFrame Time interval search.
	 * @return The request to execute.
	 */
	public Request<List<LoanIncome>> getLoansIncome(LoanIncomeHistoryParams params, TimeFrame timeFrame) {
		return new Request<>(service.getLoansIncome(Params.merge(params, timeFrame)));
	}

	/**
	 * Get crypto loans income history.
	 *
	 * @param params Request params.
	 * @return The request to execute.
	 */
	public Request<List<LoanIncome>> getLoansIncome(LoanIncomeHistoryParams params) {
		return new Request<>(service.getLoansIncome(params.toMap()));
	}

	/**
	 * Get crypto loan borrow
	 * @param params LoanBorrowParams
	 * @return
	 */
	public Request<LoanBorrow> borrow(LoanBorrowParams params){
		return new Request<>(service.borrow(params.toMap()));
	}

	/**
	 * Get crypto loan borrow history list
	 * @param params
	 * @return
	 */
	public Request<LoanBorrowHistoryPage> borrowHistory(LoanBorrowHistoryParams params){
		return new Request<>(service.borrowHistory(params.toMap()));
	}
	/**
	 * Get crypto loan borrow history list
	 * @param params
	 * @return
	 */
	public Request<LoanBorrowHistoryPage> borrowHistory(LoanBorrowHistoryParams params, Paging paging) {
		var replaceMap = Map.of("page", "current", "limit", "size");
		return new Request<>(service.borrowHistory(Params.merge(params.toMap(), paging.toMap(replaceMap))));
	}
}
