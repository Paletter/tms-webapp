package com.palette.busi.project.tms.business.delivery.packGoods.vo;

import java.math.BigDecimal;

public class UnitCsmInfoResultVo {

	private String piecesNo;
	private String consignmentNo;
	private BigDecimal actualWeight;

	public String getConsignmentNo() {
		return consignmentNo;
	}

	public void setConsignmentNo(String consignmentNo) {
		this.consignmentNo = consignmentNo;
	}

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
