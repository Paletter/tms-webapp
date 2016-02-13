package com.palette.busi.project.tms.business.receive.csmStockIn.vo;

import java.math.BigDecimal;

import com.palette.busi.project.tms.common.base.BaseUpdateVo;

public class CsmStockInCsmUpdateVo extends BaseUpdateVo {

    public CsmStockInCsmUpdateVo(String userName, String controllerId) {
		super(userName, controllerId);
	}

	private Integer tmConsignmentId;
	private String referenceNo;
	
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

	public Integer getTmConsignmentId() {
		return tmConsignmentId;
	}

	public void setTmConsignmentId(Integer tmConsignmentId) {
		this.tmConsignmentId = tmConsignmentId;
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

	public String getConsigneeChineseFullAddress() {
		return consigneeChineseFullAddress;
	}

	public void setConsigneeChineseFullAddress(String consigneeChineseFullAddress) {
		this.consigneeChineseFullAddress = consigneeChineseFullAddress;
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

	public String getTotalGoodsValueCurrency() {
		return totalGoodsValueCurrency;
	}

	public void setTotalGoodsValueCurrency(String totalGoodsValueCurrency) {
		this.totalGoodsValueCurrency = totalGoodsValueCurrency;
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
    
}
