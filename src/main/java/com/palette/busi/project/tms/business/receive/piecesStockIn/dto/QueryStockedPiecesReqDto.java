package com.palette.busi.project.tms.business.receive.piecesStockIn.dto;

import com.palette.busi.project.tms.common.base.BaseReqDto;

public class QueryStockedPiecesReqDto extends BaseReqDto {

	private String logisticsNo;

	public String getLogisticsNo() {
		return logisticsNo;
	}

	public void setLogisticsNo(String logisticsNo) {
		this.logisticsNo = logisticsNo;
	}
}
