package com.palette.busi.project.tms.server.dto;

import java.util.List;

import com.palette.busi.project.tms.common.base.BaseRespDto;
import com.palette.busi.project.tms.server.vo.PiecesHistoryResultVo;

public class QueryPiecesRespDto extends BaseRespDto {

	private String referenceNo;
	private String consigneeName;
	private String consigneeMobileNo;
	private String consigneeChineseFullAddress;
	private String totalGoodsDescription;
	private String deliveryName;
	private String deliveryNo;
	
	private List<PiecesHistoryResultVo> piecesHistoryVoList;

	public String getDeliveryNo() {
		return deliveryNo;
	}

	public void setDeliveryNo(String deliveryNo) {
		this.deliveryNo = deliveryNo;
	}

	public String getReferenceNo() {
		return referenceNo;
	}

	public void setReferenceNo(String referenceNo) {
		this.referenceNo = referenceNo;
	}

	public String getConsigneeName() {
		return consigneeName;
	}

	public void setConsigneeName(String consigneeName) {
		this.consigneeName = consigneeName;
	}

	public String getConsigneeMobileNo() {
		return consigneeMobileNo;
	}

	public void setConsigneeMobileNo(String consigneeMobileNo) {
		this.consigneeMobileNo = consigneeMobileNo;
	}

	public String getConsigneeChineseFullAddress() {
		return consigneeChineseFullAddress;
	}

	public void setConsigneeChineseFullAddress(String consigneeChineseFullAddress) {
		this.consigneeChineseFullAddress = consigneeChineseFullAddress;
	}

	public String getTotalGoodsDescription() {
		return totalGoodsDescription;
	}

	public void setTotalGoodsDescription(String totalGoodsDescription) {
		this.totalGoodsDescription = totalGoodsDescription;
	}

	public List<PiecesHistoryResultVo> getPiecesHistoryVoList() {
		return piecesHistoryVoList;
	}

	public void setPiecesHistoryVoList(
			List<PiecesHistoryResultVo> piecesHistoryVoList) {
		this.piecesHistoryVoList = piecesHistoryVoList;
	}

	public String getDeliveryName() {
		return deliveryName;
	}

	public void setDeliveryName(String deliveryName) {
		this.deliveryName = deliveryName;
	}

}
