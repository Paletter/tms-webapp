package com.palette.busi.project.tms.business.receive.csmStockIn.dto;

import java.math.BigDecimal;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import com.palette.busi.project.tms.common.base.BaseReqDto;

@JsonIgnoreProperties(ignoreUnknown=true)
public class CsmStockInReqDto extends BaseReqDto {

    // Other
    private Integer tmConsignmentId;
    private Integer tmPiecesId;
    private String referenceNo;
    private String memberCode;
	private BigDecimal length;
    private BigDecimal width;
    private BigDecimal height;
    private BigDecimal actualWeight;
    private BigDecimal volumeWeight;
    private String memo;
	
	// Shipper info
	private String shipperName;
	private String shipperMobileNo;
	private String shipperEnglishFullAddress;
	private String shipperCompanyName;
	
	// Consignee info
    private String consigneeStateName;
    private String consigneeCityName;
    private String consigneeStreet;
    private String consigneeChineseFullAddress;
    private String consigneePostCode;
    private String consigneeMobileNo;
    private String consigneeName;
	
	// Goods
	private String totalGoodsDescription;
    private BigDecimal totalGoodsValue;
    private String totalGoodsValueCurrency;
    private BigDecimal totalQty;
    private String totalGoodsBrand;
    private String totalGoodsSpec;
    private String totalGoodsUnit;

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

	public String getMemberCode() {
		return memberCode;
	}

	public void setMemberCode(String memberCode) {
		this.memberCode = memberCode;
	}

	public Integer getTmPiecesId() {
		return tmPiecesId;
	}

	public void setTmPiecesId(Integer tmPiecesId) {
		this.tmPiecesId = tmPiecesId;
	}

	public String getShipperName() {
		return shipperName;
	}

	public void setShipperName(String shipperName) {
		this.shipperName = shipperName;
	}

	public String getShipperMobileNo() {
		return shipperMobileNo;
	}

	public void setShipperMobileNo(String shipperMobileNo) {
		this.shipperMobileNo = shipperMobileNo;
	}

	public String getShipperEnglishFullAddress() {
		return shipperEnglishFullAddress;
	}

	public void setShipperEnglishFullAddress(String shipperEnglishFullAddress) {
		this.shipperEnglishFullAddress = shipperEnglishFullAddress;
	}

	public String getShipperCompanyName() {
		return shipperCompanyName;
	}

	public void setShipperCompanyName(String shipperCompanyName) {
		this.shipperCompanyName = shipperCompanyName;
	}

	public String getConsigneeChineseFullAddress() {
		return consigneeChineseFullAddress;
	}

	public void setConsigneeChineseFullAddress(String consigneeChineseFullAddress) {
		this.consigneeChineseFullAddress = consigneeChineseFullAddress;
	}

	public String getConsigneeName() {
		return consigneeName;
	}

	public void setConsigneeName(String consigneeName) {
		this.consigneeName = consigneeName;
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

	public String getTotalGoodsBrand() {
		return totalGoodsBrand;
	}

	public void setTotalGoodsBrand(String totalGoodsBrand) {
		this.totalGoodsBrand = totalGoodsBrand;
	}

	public String getTotalGoodsSpec() {
		return totalGoodsSpec;
	}

	public void setTotalGoodsSpec(String totalGoodsSpec) {
		this.totalGoodsSpec = totalGoodsSpec;
	}

	public String getTotalGoodsUnit() {
		return totalGoodsUnit;
	}

	public void setTotalGoodsUnit(String totalGoodsUnit) {
		this.totalGoodsUnit = totalGoodsUnit;
	}

	public String getReferenceNo() {
		return referenceNo;
	}

	public void setReferenceNo(String referenceNo) {
		this.referenceNo = referenceNo;
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

	public String getConsigneeStateName() {
		return consigneeStateName;
	}

	public void setConsigneeStateName(String consigneeStateName) {
		this.consigneeStateName = consigneeStateName;
	}

	public String getConsigneeCityName() {
		return consigneeCityName;
	}

	public void setConsigneeCityName(String consigneeCityName) {
		this.consigneeCityName = consigneeCityName;
	}

	public String getConsigneeStreet() {
		return consigneeStreet;
	}

	public void setConsigneeStreet(String consigneeStreet) {
		this.consigneeStreet = consigneeStreet;
	}

	public String getConsigneePostCode() {
		return consigneePostCode;
	}

	public void setConsigneePostCode(String consigneePostCode) {
		this.consigneePostCode = consigneePostCode;
	}

	public String getConsigneeMobileNo() {
		return consigneeMobileNo;
	}

	public void setConsigneeMobileNo(String consigneeMobileNo) {
		this.consigneeMobileNo = consigneeMobileNo;
	}

	public String getTotalGoodsValueCurrency() {
		return totalGoodsValueCurrency;
	}

	public void setTotalGoodsValueCurrency(String totalGoodsValueCurrency) {
		this.totalGoodsValueCurrency = totalGoodsValueCurrency;
	}
    
}
