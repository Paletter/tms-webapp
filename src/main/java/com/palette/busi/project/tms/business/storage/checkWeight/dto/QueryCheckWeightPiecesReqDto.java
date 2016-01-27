package com.palette.busi.project.tms.business.storage.checkWeight.dto;

import com.palette.busi.project.tms.common.base.BaseReqDto;

public class QueryCheckWeightPiecesReqDto extends BaseReqDto {

	private String queryNo;

	public String getQueryNo() {
		return queryNo;
	}

	public void setQueryNo(String queryNo) {
		this.queryNo = queryNo;
	}
}
