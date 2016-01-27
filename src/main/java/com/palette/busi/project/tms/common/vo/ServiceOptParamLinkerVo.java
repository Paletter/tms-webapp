package com.palette.busi.project.tms.common.vo;

import java.math.BigDecimal;

public class ServiceOptParamLinkerVo {

	private String userName;
	private String weightUnit;
	private String volumnUnit;
	private String countryCode;
	private String warehouseCode;
	private String warehouseDesc;
	private BigDecimal convertToKg;
	private String companyCode;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getWeightUnit() {
		return weightUnit;
	}

	public void setWeightUnit(String weightUnit) {
		this.weightUnit = weightUnit;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getWarehouseCode() {
		return warehouseCode;
	}

	public void setWarehouseCode(String warehouseCode) {
		this.warehouseCode = warehouseCode;
	}

	public String getWarehouseDesc() {
		return warehouseDesc;
	}

	public void setWarehouseDesc(String warehouseDesc) {
		this.warehouseDesc = warehouseDesc;
	}

	public BigDecimal getConvertToKg() {
		return convertToKg;
	}

	public void setConvertToKg(BigDecimal convertToKg) {
		this.convertToKg = convertToKg;
	}

	public String getVolumnUnit() {
		return volumnUnit;
	}

	public void setVolumnUnit(String volumnUnit) {
		this.volumnUnit = volumnUnit;
	}

	public String getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}
	
}
