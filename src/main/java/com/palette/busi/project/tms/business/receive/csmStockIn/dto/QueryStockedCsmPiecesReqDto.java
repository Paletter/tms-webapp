package com.palette.busi.project.tms.business.receive.csmStockIn.dto;

import com.palette.busi.project.tms.common.base.BaseReqDto;

public class QueryStockedCsmPiecesReqDto extends BaseReqDto {

	private String referenceNo;

	public String getReferenceNo() {
		return referenceNo;
	}

	public void setReferenceNo(String referenceNo) {
		this.referenceNo = referenceNo;
	}

}
