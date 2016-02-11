package com.palette.busi.project.tms.business.delivery.packGoods.dto;

import java.math.BigDecimal;

import com.palette.busi.project.tms.common.base.BaseRespDto;

public class PackPiecesInUnitRespDto extends BaseRespDto {

	private String piecesNo;
	private BigDecimal actualWeight;

	public String getPiecesNo() {
		return piecesNo;
	}

	public void setPiecesNo(String piecesNo) {
		this.piecesNo = piecesNo;
	}

	public BigDecimal getActualWeight() {
		return actualWeight;
	}

	public void setActualWeight(BigDecimal actualWeight) {
		this.actualWeight = actualWeight;
	}
	
}
