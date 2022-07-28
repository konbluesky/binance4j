package com.binance4j.margin.param;

import com.binance4j.core.annotation.Param;
import com.binance4j.core.param.Params;
import com.binance4j.margin.client.MarginClient;
import com.binance4j.margin.dto.TransferRecordType;

/** The {@link MarginClient#getTransferHistory} params. */
@Param
public class TransferHistoryParams implements Params {
	/** The starting timestamp of the results */
	Long startTime;
	/** The ending timestamp of the results */
	Long endTime;

	String asset;
	TransferRecordType type;
	Long current;
	Integer size;
	Boolean archived;

	/** @return the asset */
	public String getAsset() {
		return asset;
	}

	/** @param asset the asset to set */
	public void setAsset(String asset) {
		this.asset = asset;
	}

	/** @return the type */
	public TransferRecordType getType() {
		return type;
	}

	/** @param type the type to set */
	public void setType(TransferRecordType type) {
		this.type = type;
	}

	/** @return the current */
	public Long getCurrent() {
		return current;
	}

	/** @param current the current to set */
	public void setCurrent(Long current) {
		this.current = current;
	}

	/** @return the size */
	public Integer getSize() {
		return size;
	}

	/** @param size the size to set */
	public void setSize(Integer size) {
		this.size = size;
	}

	/** @return the archived */
	public Boolean getArchived() {
		return archived;
	}

	/** @param archived the archived to set */
	public void setArchived(Boolean archived) {
		this.archived = archived;
	}

	/** @return the startTime */
	public Long getStartTime() {
		return startTime;
	}

	/** @param startTime the startTime to set */
	public void setStartTime(Long startTime) {
		this.startTime = startTime;
	}

	/** @return the endTime */
	public Long getEndTime() {
		return endTime;
	}

	/** @param endTime the endTime to set */
	public void setEndTime(Long endTime) {
		this.endTime = endTime;
	}
}