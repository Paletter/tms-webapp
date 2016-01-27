package com.palette.busi.project.tms.business.basic.login.vo;

import java.util.List;

import com.palette.busi.project.tms.core.entity.CdCompany;
import com.palette.busi.project.tms.core.entity.CdCountry;
import com.palette.busi.project.tms.core.entity.CdCountryRef;
import com.palette.busi.project.tms.core.entity.CdRole;
import com.palette.busi.project.tms.core.entity.CdUser;
import com.palette.busi.project.tms.core.entity.CdWarehouse;

public class LoginUserResultVo {

	private CdUser cdUser;
	private CdCountry cdCountry;
	private CdCountryRef cdCountryRef;
	private CdWarehouse cdWarehouse;
	private String sessionId;
	private List<CdRole> cdRoleList;
	private boolean isRoot;
	private CdCompany cdCompany;
	
	private List<MenuResultVo> menuVoList;

	public boolean getIsRoot() {
		return isRoot;
	}

	public void setIsRoot(boolean isRoot) {
		this.isRoot = isRoot;
	}


	public CdCountry getCdCountry() {
		return cdCountry;
	}

	public void setCdCountry(CdCountry cdCountry) {
		this.cdCountry = cdCountry;
	}

	public CdCountryRef getCdCountryRef() {
		return cdCountryRef;
	}

	public void setCdCountryRef(CdCountryRef cdCountryRef) {
		this.cdCountryRef = cdCountryRef;
	}

	public CdWarehouse getCdWarehouse() {
		return cdWarehouse;
	}

	public void setCdWarehouse(CdWarehouse cdWarehouse) {
		this.cdWarehouse = cdWarehouse;
	}

	public List<MenuResultVo> getMenuVoList() {
		return menuVoList;
	}

	public void setMenuVoList(List<MenuResultVo> menuVoList) {
		this.menuVoList = menuVoList;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public CdUser getCdUser() {
		return cdUser;
	}

	public void setCdUser(CdUser cdUser) {
		this.cdUser = cdUser;
	}

	public List<CdRole> getCdRoleList() {
		return cdRoleList;
	}

	public void setCdRoleList(List<CdRole> cdRoleList) {
		this.cdRoleList = cdRoleList;
	}

	public CdCompany getCdCompany() {
		return cdCompany;
	}

	public void setCdCompany(CdCompany cdCompany) {
		this.cdCompany = cdCompany;
	}

}
