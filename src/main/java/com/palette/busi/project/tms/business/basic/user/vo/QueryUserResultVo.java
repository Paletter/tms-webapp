package com.palette.busi.project.tms.business.basic.user.vo;


public class QueryUserResultVo {

	private Integer cdUserId;
	private String userName;
	private String fullName;
	private String memo;
	private String companyName;
	private String companyCode;
	private Integer isActive;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public Integer getCdUserId() {
		return cdUserId;
	}

	public void setCdUserId(Integer cdUserId) {
		this.cdUserId = cdUserId;
	}

	public String getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}

	public Integer getIsActive() {
		return isActive;
	}

	public void setIsActive(Integer isActive) {
		this.isActive = isActive;
	}
	
}
