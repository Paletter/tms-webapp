package com.palette.busi.project.tms.business.common.vo;

import com.palette.busi.project.tms.common.base.BaseUpdateVo;

public class ComPiecesRefUpdateVo extends BaseUpdateVo {

	private Integer tmPiecesId;
	private String piecesNo;
	private String refType;
    private String refCode;
    private Integer refId;

    public ComPiecesRefUpdateVo(String userName, String controllerId) {
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

	public String getRefType() {
		return refType;
	}

	public void setRefType(String refType) {
		this.refType = refType;
	}

	public String getRefCode() {
		return refCode;
	}

	public void setRefCode(String refCode) {
		this.refCode = refCode;
	}

	public Integer getRefId() {
		return refId;
	}

	public void setRefId(Integer refId) {
		this.refId = refId;
	}
	
}
