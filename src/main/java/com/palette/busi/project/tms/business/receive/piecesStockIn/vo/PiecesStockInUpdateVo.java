package com.palette.busi.project.tms.business.receive.piecesStockIn.vo;

import java.math.BigDecimal;

import com.palette.busi.project.tms.common.base.BaseUpdateVo;

public class PiecesStockInUpdateVo extends BaseUpdateVo {

	private Integer tmPiecesId;
	private String logisticsNo;
	private String memberCode;
	private BigDecimal length;
    private BigDecimal width;
    private BigDecimal height;
    private BigDecimal actualWeight;
    private BigDecimal volumeWeight;
    private String memo;

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

	public String getMemberCode() {
		return memberCode;
	}

	public void setMemberCode(String memberCode) {
		this.memberCode = memberCode;
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

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

}
