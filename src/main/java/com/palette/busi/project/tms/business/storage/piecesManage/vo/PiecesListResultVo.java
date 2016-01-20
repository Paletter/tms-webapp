package com.palette.busi.project.tms.business.storage.piecesManage.vo;

import java.math.BigDecimal;
import java.util.Date;

public class PiecesListResultVo {

	private Integer tmPiecesId;
	private String piecesNo;
	private String consignmentNo;
	private String logisticsNo;
	private String locCode;
	private String piecesWarehouse;
	private Integer tmConsignmentId;
	private String userViewCode;
	private Integer userViewNo;
	private Date checkDate;
	private String memberCode;
	private BigDecimal actualWeight;
	private BigDecimal volumeWeight;
	private String piecesMemo;
	private String currentActionCode;
	private String currentActionDesc;

	public Integer getTmPiecesId() {
		return tmPiecesId;
	}

	public void setTmPiecesId(Integer tmPiecesId) {
		this.tmPiecesId = tmPiecesId;
	}

	public String getPiecesNo() {
		return piecesNo;
	}

	public void setPiecesNo(String piecesNo) {
		this.piecesNo = piecesNo;
	}

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

	public String getLocCode() {
		return locCode;
	}

	public void setLocCode(String locCode) {
		this.locCode = locCode;
	}

	public String getPiecesWarehouse() {
		return piecesWarehouse;
	}

	public void setPiecesWarehouse(String piecesWarehouse) {
		this.piecesWarehouse = piecesWarehouse;
	}

	public Integer getTmConsignmentId() {
		return tmConsignmentId;
	}

	public void setTmConsignmentId(Integer tmConsignmentId) {
		this.tmConsignmentId = tmConsignmentId;
	}

	public String getUserViewCode() {
		return userViewCode;
	}

	public void setUserViewCode(String userViewCode) {
		this.userViewCode = userViewCode;
	}

	public Integer getUserViewNo() {
		return userViewNo;
	}

	public void setUserViewNo(Integer userViewNo) {
		this.userViewNo = userViewNo;
	}

	public Date getCheckDate() {
		return checkDate;
	}

	public void setCheckDate(Date checkDate) {
		this.checkDate = checkDate;
	}

	public String getMemberCode() {
		return memberCode;
	}

	public void setMemberCode(String memberCode) {
		this.memberCode = memberCode;
	}

	public BigDecimal getActualWeight() {
		return actualWeight;
	}

	public void setActualWeight(BigDecimal actualWeight) {
		this.actualWeight = actualWeight;
	}

	public BigDecimal getVolumeWeight() {
		return volumeWeight;
	}

	public void setVolumeWeight(BigDecimal volumeWeight) {
		this.volumeWeight = volumeWeight;
	}

	public String getPiecesMemo() {
		return piecesMemo;
	}

	public void setPiecesMemo(String piecesMemo) {
		this.piecesMemo = piecesMemo;
	}

	public String getCurrentActionCode() {
		return currentActionCode;
	}

	public void setCurrentActionCode(String currentActionCode) {
		this.currentActionCode = currentActionCode;
	}

	public String getCurrentActionDesc() {
		return currentActionDesc;
	}

	public void setCurrentActionDesc(String currentActionDesc) {
		this.currentActionDesc = currentActionDesc;
	}
	
}
