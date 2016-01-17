package com.palette.busi.project.tms.business.basic.welcome.vo;

public class DaylyStockInPiecesResultVo {

	private String piecesNo;
	private String logisticsNo;
	private String locationCode;
	private String stockInDate;

	public String getPiecesNo() {
		return piecesNo;
	}

	public void setPiecesNo(String piecesNo) {
		this.piecesNo = piecesNo;
	}

	public String getLocationCode() {
		return locationCode;
	}

	public void setLocationCode(String locationCode) {
		this.locationCode = locationCode;
	}

	public String getLogisticsNo() {
		return logisticsNo;
	}

	public void setLogisticsNo(String logisticsNo) {
		this.logisticsNo = logisticsNo;
	}

	public String getStockInDate() {
		return stockInDate;
	}

	public void setStockInDate(String stockInDate) {
		this.stockInDate = stockInDate;
	}
	
}
