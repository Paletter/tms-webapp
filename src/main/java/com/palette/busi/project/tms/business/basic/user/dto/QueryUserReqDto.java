package com.palette.busi.project.tms.business.basic.user.dto;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import com.palette.busi.project.tms.common.base.BaseReqDto;

@JsonIgnoreProperties(ignoreUnknown=true)
public class QueryUserReqDto extends BaseReqDto {

	private String userName;
	private String fullName;
	private String companyCode;

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

	public String getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}
	
}
