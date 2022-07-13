package com.binance4j.wallet.deposit;

import com.binance4j.core.param.IntervalParams;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * The parameters to get a coin deposit history
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class DepositHistoryParams extends IntervalParams {
	/**
	 * The deposited coin
	 */
	private String coin;
	/**
	 * The deposit status. 0(0:pending,6: credited but cannot withdraw,
	 * 1:success)
	 */
	private Integer status;

	/**
	 * The history offset
	 */
	private Integer offset;
	/**
	 * The history size. Default:1000, Max:1000
	 */
	private Integer limit = 1000;

	/**
	 * Default constructor
	 */
	public DepositHistoryParams() {
		super(1);
	}

	/**
	 * Constructor
	 *
	 * @param coin The coin we need deposit history
	 */
	public DepositHistoryParams(String coin) {
		this();
		this.coin = coin;
	}

	/**
	 * Constructor
	 *
	 * @param status The coin status (0:pending,6: credited but cannot withdraw,
	 *               1:success)
	 */
	public DepositHistoryParams(int status) {
		this();
		this.status = status;
	}

	/**
	 * Constructor
	 *
	 * @param status The coin status
	 */
	public DepositHistoryParams(DepositStatus status) {
		this();
		this.status = status.getValue();
	}

	/**
	 * Constructor
	 *
	 * @param coin   The coin we need deposit history
	 * @param status The coin status 0(0:pending,6: credited but cannot withdraw,
	 *               1:success)
	 */
	public DepositHistoryParams(String coin, int status) {
		this(coin);
		this.status = status;
	}

	/**
	 * Constructor
	 *
	 * @param coin   The coin we need deposit history
	 * @param status The coin status 0(0:pending,6: credited but cannot withdraw,
	 *               1:success)
	 */
	public DepositHistoryParams(String coin, DepositStatus status) {
		this(coin, status.getValue());
	}

	/**
	 * Constructor
	 *
	 * @param coin   The coin we need deposit history
	 * @param status The coin status 0(0:pending,6: credited but cannot withdraw,
	 *               1:success)
	 * @param limit  The history size. Default:1000, Max:1000
	 */
	public DepositHistoryParams(String coin, DepositStatus status, int limit) {
		this(coin, status.getValue());
		this.limit = limit;
	}

	/**
	 * Constructor
	 *
	 * @param coin   The coin we need deposit history
	 * @param status The coin status 0(0:pending,6: credited but cannot withdraw,
	 *               1:success)
	 * @param limit  The history size. Default:1000, Max:1000
	 */
	public DepositHistoryParams(String coin, int status, int limit) {
		this(coin, status);
		this.limit = limit;
	}

	/**
	 * Constructor
	 *
	 * @param coin   The coin we need deposit history
	 * @param status The coin status 0(0:pending,6: credited but cannot withdraw,
	 *               1:success)
	 * @param limit  The history size. Default:1000, Max:1000
	 * @param offset The history offset
	 */
	public DepositHistoryParams(String coin, DepositStatus status, int limit, int offset) {
		this(coin, status, limit);
		this.offset = offset;
	}

	/**
	 * Constructor
	 *
	 * @param coin   The coin we need deposit history
	 * @param status The coin status 0(0:pending,6: credited but cannot withdraw,
	 *               1:success)
	 * @param limit  The history size. Default:1000, Max:1000
	 * @param offset The history offset
	 */
	public DepositHistoryParams(String coin, int status, int limit, int offset) {
		this(coin, status, limit);
		this.offset = offset;
	}
}