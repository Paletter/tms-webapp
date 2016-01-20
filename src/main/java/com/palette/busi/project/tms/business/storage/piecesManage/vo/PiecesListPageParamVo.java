package com.palette.busi.project.tms.business.storage.piecesManage.vo;

import com.palette.busi.project.tms.core.base.BasePo;

public class PiecesListPageParamVo extends BasePo {

	private static final long serialVersionUID = 1L;
	
	private String consignmentNo;
	private String logisticsNo;
	private String piecesNo;
	private String warehouseCode;
	private String memberCode;
	private String startStockedTime;
	private String endStockedTime;
	private String stockStatus;
	private String auditStatus;
	private String piecesClaimStatus;
	private String piecesMemo;

	public String getConsignmentNo() {
		return consignmentNo;
	}

	public void setConsignmentNo(String consignmentNo) {
		this.consignmentNo = consignmentNo;
	}

	public String getLogisticsNo() {
		return logisticsNo;
	}

	public void setLogisticsNo(String logisticsNo) {
		this.logisticsNo = logisticsNo;
	}

	public String getPiecesNo() {
		return piecesNo;
	}

	public void setPiecesNo(String piecesNo) {
		this.piecesNo = piecesNo;
	}

	public String getWarehouseCode() {
		return warehouseCode;
	}

	public void setWarehouseCode(String warehouseCode) {
		this.warehouseCode = warehouseCode;
	}

	public String getMemberCode() {
		return memberCode;
	}

	public void setMemberCode(String memberCode) {
		this.memberCode = memberCode;
	}

	public String getStartStockedTime() {
		return startStockedTime;
	}

	public void setStartStockedTime(String startStockedTime) {
		this.startStockedTime = startStockedTime;
	}

	public String getEndStockedTime() {
		return endStockedTime;
	}

	public void setEndStockedTime(String endStockedTime) {
		this.endStockedTime = endStockedTime;
	}

	public String getStockStatus() {
		return stockStatus;
	}

	public void setStockStatus(String stockStatus) {
		this.stockStatus = stockStatus;
	}

	public String getAuditStatus() {
		return auditStatus;
	}

	public void setAuditStatus(String auditStatus) {
		this.auditStatus = auditStatus;
	}

	public String getPiecesClaimStatus() {
		return piecesClaimStatus;
	}

	public void setPiecesClaimStatus(String piecesClaimStatus) {
		this.piecesClaimStatus = piecesClaimStatus;
	}

	public String getPiecesMemo() {
		return piecesMemo;
	}

	public void setPiecesMemo(String piecesMemo) {
		this.piecesMemo = piecesMemo;
	}

}
