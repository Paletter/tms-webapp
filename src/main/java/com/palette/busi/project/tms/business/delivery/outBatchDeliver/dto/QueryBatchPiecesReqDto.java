package com.palette.busi.project.tms.business.delivery.outBatchDeliver.dto;

import com.palette.busi.project.tms.common.base.BaseReqDto;

public class QueryBatchPiecesReqDto extends BaseReqDto {

	private Integer tmOutBatchId;
	private String outBatchNo;

	public Integer getTmOutBatchId() {
		return tmOutBatchId;
	}

	public void setTmOutBatchId(Integer tmOutBatchId) {
		this.tmOutBatchId = tmOutBatchId;
	}

	public String getOutBatchNo() {
		return outBatchNo;
	}

	public void setOutBatchNo(String outBatchNo) {
		this.outBatchNo = outBatchNo;
	}
	
}
