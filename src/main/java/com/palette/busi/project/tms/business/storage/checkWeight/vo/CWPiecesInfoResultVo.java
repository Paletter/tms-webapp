package com.palette.busi.project.tms.business.storage.checkWeight.vo;

import java.math.BigDecimal;

public class CWPiecesInfoResultVo {
	
	private Integer tmPiecesId;
	private String piecesNo;
	private Integer tmConsignmentId;
	private String consignmentNo;
	private String memberCode;
	private BigDecimal actualWeight;
    private BigDecimal length;
    private BigDecimal width;
    private BigDecimal height;
    private BigDecimal volumeWeight;
    private Integer userViewNo;
    private String currentActionDesc;
    
	public String getPiecesNo() {
		return piecesNo;
	}

	public void setPiecesNo(String piecesNo) {
		this.piecesNo = piecesNo;
	}

	public Integer getTmConsignmentId() {
		return tmConsignmentId;
	}

	public void setTmConsignmentId(Integer tmConsignmentId) {
		this.tmConsignmentId = tmConsignmentId;
	}

	public String getConsignmentNo() {
		return consignmentNo;
	}

	public void setConsignmentNo(String consignmentNo) {
		this.consignmentNo = consignmentNo;
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

	public BigDecimal getLength() {
		return length;
	}

	public void setLength(BigDecimal length) {
		this.length = length;
	}

	public BigDecimal getWidth() {
		return width;
	}

	public void setWidth(BigDecimal width) {
		this.width = width;
	}

	public BigDecimal getHeight() {
		return height;
	}

	public void setHeight(BigDecimal height) {
		this.height = height;
	}

	public BigDecimal getVolumeWeight() {
		return volumeWeight;
	}

	public void setVolumeWeight(BigDecimal volumeWeight) {
		this.volumeWeight = volumeWeight;
	}

	public Integer getUserViewNo() {
		return userViewNo;
	}

	public void setUserViewNo(Integer userViewNo) {
		this.userViewNo = userViewNo;
	}

	public Integer getTmPiecesId() {
		return tmPiecesId;
	}

	public void setTmPiecesId(Integer tmPiecesId) {
		this.tmPiecesId = tmPiecesId;
	}

	public String getCurrentActionDesc() {
		return currentActionDesc;
	}

	public void setCurrentActionDesc(String currentActionDesc) {
		this.currentActionDesc = currentActionDesc;
	}
    
}
