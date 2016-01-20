package com.palette.busi.project.tms.business.storage.piecesManage.vo;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.palette.busi.project.tms.core.entity.TmConsignmentItem;
import com.palette.busi.project.tms.core.entity.TmPiecesHistory;

public class PiecesDetailResultVo {

	private String piecesNo;
	private String consignmentNo;
    private String memberCode;
    private String logisticsNo;
    private String locationCode;
    private Date checkDate;
    private BigDecimal volumeWeight;
    private BigDecimal actualWeight;
    private BigDecimal length;
    private BigDecimal width;
    private BigDecimal height;
    private String totalGoodsDescription;
    private BigDecimal totalGoodsValue;
    private BigDecimal totalQty;
    private String csmVas;
    private String actionDesc;
    private String userViewCode;
    private String serviceProductName;
    private String memo;
    
    private String unitLabel;
    private String mawbCode;
    private String deliveryName;
    private String deliveryNo;
    
    private Integer payStatus;
    private Integer auditStatus;
    private Integer combinationStatus;
    private String currentMemo;
    
    private List<TmConsignmentItem> tmConsignmentItemList;
    private List<PiecesDetailHistoryResultVo> piecesHistoryVoList;

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

	public String getMemberCode() {
		return memberCode;
	}

	public void setMemberCode(String memberCode) {
		this.memberCode = memberCode;
	}

	public String getLocationCode() {
		return locationCode;
	}

	public void setLocationCode(String locationCode) {
		this.locationCode = locationCode;
	}

	public Date getCheckDate() {
		return checkDate;
	}

	public void setCheckDate(Date checkDate) {
		this.checkDate = checkDate;
	}

	public String getLogisticsNo() {
		return logisticsNo;
	}

	public void setLogisticsNo(String logisticsNo) {
		this.logisticsNo = logisticsNo;
	}

	public BigDecimal getVolumeWeight() {
		return volumeWeight;
	}

	public void setVolumeWeight(BigDecimal volumeWeight) {
		this.volumeWeight = volumeWeight;
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

	public String getCsmVas() {
		return csmVas;
	}

	public void setCsmVas(String csmVas) {
		this.csmVas = csmVas;
	}

	public Integer getPayStatus() {
		return payStatus;
	}

	public void setPayStatus(Integer payStatus) {
		this.payStatus = payStatus;
	}

	public Integer getAuditStatus() {
		return auditStatus;
	}

	public void setAuditStatus(Integer auditStatus) {
		this.auditStatus = auditStatus;
	}

	public Integer getCombinationStatus() {
		return combinationStatus;
	}

	public void setCombinationStatus(Integer combinationStatus) {
		this.combinationStatus = combinationStatus;
	}

	public String getCurrentMemo() {
		return currentMemo;
	}

	public void setCurrentMemo(String currentMemo) {
		this.currentMemo = currentMemo;
	}

	public String getUserViewCode() {
		return userViewCode;
	}

	public void setUserViewCode(String userViewCode) {
		this.userViewCode = userViewCode;
	}

	public String getActionDesc() {
		return actionDesc;
	}

	public void setActionDesc(String actionDesc) {
		this.actionDesc = actionDesc;
	}

	public String getServiceProductName() {
		return serviceProductName;
	}

	public void setServiceProductName(String serviceProductName) {
		this.serviceProductName = serviceProductName;
	}
	
	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getUnitLabel() {
		return unitLabel;
	}

	public void setUnitLabel(String unitLabel) {
		this.unitLabel = unitLabel;
	}

	public String getMawbCode() {
		return mawbCode;
	}

	public void setMawbCode(String mawbCode) {
		this.mawbCode = mawbCode;
	}

	public String getDeliveryName() {
		return deliveryName;
	}

	public void setDeliveryName(String deliveryName) {
		this.deliveryName = deliveryName;
	}

	public String getDeliveryNo() {
		return deliveryNo;
	}

	public void setDeliveryNo(String deliveryNo) {
		this.deliveryNo = deliveryNo;
	}

	public List<TmConsignmentItem> getTmConsignmentItemList() {
		return tmConsignmentItemList;
	}

	public void setTmConsignmentItemList(
			List<TmConsignmentItem> tmConsignmentItemList) {
		this.tmConsignmentItemList = tmConsignmentItemList;
	}

	public String getTotalGoodsDescription() {
		return totalGoodsDescription;
	}

	public void setTotalGoodsDescription(String totalGoodsDescription) {
		this.totalGoodsDescription = totalGoodsDescription;
	}

	public BigDecimal getTotalGoodsValue() {
		return totalGoodsValue;
	}

	public void setTotalGoodsValue(BigDecimal totalGoodsValue) {
		this.totalGoodsValue = totalGoodsValue;
	}

	public BigDecimal getTotalQty() {
		return totalQty;
	}

	public void setTotalQty(BigDecimal totalQty) {
		this.totalQty = totalQty;
	}

	public List<PiecesDetailHistoryResultVo> getPiecesHistoryVoList() {
		return piecesHistoryVoList;
	}

	public void setPiecesHistoryVoList(
			List<PiecesDetailHistoryResultVo> piecesHistoryVoList) {
		this.piecesHistoryVoList = piecesHistoryVoList;
	}
    
}
