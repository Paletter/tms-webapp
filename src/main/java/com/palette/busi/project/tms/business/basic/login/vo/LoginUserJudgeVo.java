package com.palette.busi.project.tms.business.basic.login.vo;

import java.util.List;

import com.palette.busi.project.tms.core.entity.CdCountry;
import com.palette.busi.project.tms.core.entity.CdRole;
import com.palette.busi.project.tms.core.entity.CdWarehouse;

public class LoginUserJudgeVo {

	private Integer cdUserId;
	private String userName;
	private String salt;
	private String pwd;
	private List<CdRole> cdRoleList;
	private List<CdWarehouse> cdWarehouseList;
	private List<CdCountry> cdCountryList;

	public Integer getCdUserId() {
		return cdUserId;
	}

	public void setCdUserId(Integer cdUserId) {
		this.cdUserId = cdUserId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public List<CdRole> getCdRoleList() {
		return cdRoleList;
	}

	public void setCdRoleList(List<CdRole> cdRoleList) {
		this.cdRoleList = cdRoleList;
	}

	public List<CdWarehouse> getCdWarehouseList() {
		return cdWarehouseList;
	}

	public void setCdWarehouseList(List<CdWarehouse> cdWarehouseList) {
		this.cdWarehouseList = cdWarehouseList;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public List<CdCountry> getCdCountryList() {
		return cdCountryList;
	}

	public void setCdCountryList(List<CdCountry> cdCountryList) {
		this.cdCountryList = cdCountryList;
	}
	
}
