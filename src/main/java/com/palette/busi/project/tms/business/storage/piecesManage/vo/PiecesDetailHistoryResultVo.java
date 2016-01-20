package com.palette.busi.project.tms.business.storage.piecesManage.vo;

import java.util.Date;

public class PiecesDetailHistoryResultVo {

	private String actionDesc;
	private String memo;
	private String actionUserName;
	private Date actionDateTime;

	public String getActionDesc() {
		return actionDesc;
	}

	public void setActionDesc(String actionDesc) {
		this.actionDesc = actionDesc;
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
