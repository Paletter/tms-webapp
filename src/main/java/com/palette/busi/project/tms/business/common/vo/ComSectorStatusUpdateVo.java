package com.palette.busi.project.tms.business.common.vo;

import java.util.Date;

import com.palette.busi.project.tms.common.base.BaseUpdateVo;

public class ComSectorStatusUpdateVo extends BaseUpdateVo {

	private int tmSectorId;
	private String sectorCode;
	private String actionCode;
    private String memo;
    private String actionUserName;
    private Date actionDateTime;
	
	public ComSectorStatusUpdateVo(String userName, String controllerId) {
		super(userName, controllerId);
	}

	public int getTmSectorId() {
		return tmSectorId;
	}

	public void setTmSectorId(int tmSectorId) {
		this.tmSectorId = tmSectorId;
	}

	public String getSectorCode() {
		return sectorCode;
	}

	public void setSectorCode(String sectorCode) {
		this.sectorCode = sectorCode;
	}

	public String getActionCode() {
		return actionCode;
	}

	public void setActionCode(String actionCode) {
		this.actionCode = actionCode;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getActionUserName() {
		return actionUserName;
	}

	public void setActionUserName(String actionUserName) {
		this.actionUserName = actionUserName;
	}

	public Date getActionDateTime() {
		return actionDateTime;
	}

	public void setActionDateTime(Date actionDateTime) {
		this.actionDateTime = actionDateTime;
	}

}
