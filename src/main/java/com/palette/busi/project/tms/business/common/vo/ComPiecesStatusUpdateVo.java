package com.palette.busi.project.tms.business.common.vo;

import java.util.Date;

import com.palette.busi.project.tms.common.base.BaseUpdateVo;

public class ComPiecesStatusUpdateVo extends BaseUpdateVo {

	private Integer tmPiecesId;
	private String piecesNo;
	private String actionCode;
    private String memo;
    private String actionUserName;
    private Date actionDateTime;

    public ComPiecesStatusUpdateVo(String userName, String controllerId) {
		super(userName, controllerId);
	}
    
	public Integer getTmPiecesId() {
		return tmPiecesId;
	}

	public void setTmPiecesId(Integer tmPiecesId) {
		this.tmPiecesId = tmPiecesId;
	}

	public String getPiecesNo() {
		return piecesNo;
	}

	public void setPiecesNo(String piecesNo) {
		this.piecesNo = piecesNo;
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
