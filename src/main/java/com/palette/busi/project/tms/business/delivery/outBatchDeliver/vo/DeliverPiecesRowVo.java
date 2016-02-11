package com.palette.busi.project.tms.business.delivery.outBatchDeliver.vo;

import java.math.BigDecimal;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import com.palette.busi.project.tms.common.base.BaseRowVo;

@JsonIgnoreProperties(ignoreUnknown=true)
public class DeliverPiecesRowVo extends BaseRowVo {

	private Integer tmPiecesId;
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

	public Integer getTmPiecesId() {
		return tmPiecesId;
	}

	public void setTmPiecesId(Integer tmPiecesId) {
		this.tmPiecesId = tmPiecesId;
	}

}
