package com.palette.busi.project.tms.business.delivery.outBatch.dto;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import com.palette.busi.project.tms.common.base.BaseReqDto;

@JsonIgnoreProperties(ignoreUnknown=true)
public class QueryOutBatchReqDto extends BaseReqDto {

	private String outBatchNo;
	private String outDate;
	private String status;
	private String startOutDate;
	private String endOutDate;

	public String getOutBatchNo() {
		return outBatchNo;
	}

	public void setOutBatchNo(String outBatchNo) {
		this.outBatchNo = outBatchNo;
	}

	public String getOutDate() {
		return outDate;
	}

	public void setOutDate(String outDate) {
		this.outDate = outDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStartOutDate() {
		return startOutDate;
	}

	public void setStartOutDate(String startOutDate) {
		this.startOutDate = startOutDate;
	}

	public String getEndOutDate() {
		return endOutDate;
	}

	public void setEndOutDate(String endOutDate) {
		this.endOutDate = endOutDate;
	}
}
