package com.palette.busi.project.tms.business.receive.piecesStockIn.dto;

import com.palette.busi.project.tms.common.base.BaseRespDto;

public class PiecesStockInRespDto extends BaseRespDto {

	private Integer tmPiecesId;
	private String logisticsNo;
	
	public Integer getTmPiecesId() {
		return tmPiecesId;
	}

	public void setTmPiecesId(Integer tmPiecesId) {
		this.tmPiecesId = tmPiecesId;
	}

	public String getLogisticsNo() {
		return logisticsNo;
	}

	public void setLogisticsNo(String logisticsNo) {
		this.logisticsNo = logisticsNo;
	}
}
