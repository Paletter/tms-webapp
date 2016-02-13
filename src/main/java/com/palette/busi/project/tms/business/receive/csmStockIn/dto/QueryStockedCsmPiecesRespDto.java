package com.palette.busi.project.tms.business.receive.csmStockIn.dto;

import java.math.BigDecimal;

import com.palette.busi.project.tms.business.receive.csmStockIn.vo.StockedCsmResultVo;
import com.palette.busi.project.tms.common.base.BaseRespDto;
import com.palette.busi.project.tms.core.entity.TmConsignment;

public class QueryStockedCsmPiecesRespDto extends BaseRespDto {

	// Pieces
	private Integer tmPiecesId;
    private String memberCode;
    private String piecesNo;
    private String logisticsNo;
    private BigDecimal actualWeight;
    private BigDecimal volumeWeight;
    private BigDecimal length;
    private BigDecimal width;
    private BigDecimal height;
    private String memo;
    private Integer tmConsignmentId;
    private String consignmentNo;
    
    // Consignment
 	private StockedCsmResultVo stockedCsmResultVo;
    
	public Integer getTmPiecesId() {
		return tmPiecesId;
	}

	public void setTmPiecesId(Integer tmPiecesId) {
		this.tmPiecesId = tmPiecesId;
	}

	public String getMemberCode() {
		return memberCode;
	}

	public void setMemberCode(String memberCode) {
		this.memberCode = memberCode;
	}

	public String getPiecesNo() {
		return piecesNo;
	}

	public void setPiecesNo(String piecesNo) {
		this.piecesNo = piecesNo;
	}

	public String getLogisticsNo() {
		return logisticsNo;
	}

	public void setLogisticsNo(String logisticsNo) {
		this.logisticsNo = logisticsNo;
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

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
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

	public StockedCsmResultVo getStockedCsmResultVo() {
		return stockedCsmResultVo;
	}

	public void setStockedCsmResultVo(StockedCsmResultVo stockedCsmResultVo) {
		this.stockedCsmResultVo = stockedCsmResultVo;
	}

}
