package com.palette.busi.project.tms.business.storage.checkWeight.vo;

import java.math.BigDecimal;

public class CheckWeightUpdateVo {

	private Integer tmPiecesId;
	private String piecesNo;
	private Integer userViewNo;
	private String currentActionDesc;
	private BigDecimal acutualWeight;
	private BigDecimal length;
    private BigDecimal width;
    private BigDecimal height;
    private BigDecimal volumeWeight;

	public String getPiecesNo() {
		return piecesNo;
	}

	public void setPiecesNo(String piecesNo) {
		this.piecesNo = piecesNo;
	}

	public BigDecimal getActualWeight() {
		return acutualWeight;
	}

	public void setActualWeight(BigDecimal kernelWeight) {
		this.acutualWeight = kernelWeight;
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

	public Integer getTmPiecesId() {
		return tmPiecesId;
	}

	public void setTmPiecesId(Integer tmPiecesId) {
		this.tmPiecesId = tmPiecesId;
	}

	public Integer getUserViewNo() {
		return userViewNo;
	}

	public void setUserViewNo(Integer userViewNo) {
		this.userViewNo = userViewNo;
	}

	public String getCurrentActionDesc() {
		return currentActionDesc;
	}

	public void setCurrentActionDesc(String currentActionDesc) {
		this.currentActionDesc = currentActionDesc;
	}
    
}
