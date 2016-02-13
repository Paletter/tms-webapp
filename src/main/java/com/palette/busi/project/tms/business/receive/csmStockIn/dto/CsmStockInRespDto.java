package com.palette.busi.project.tms.business.receive.csmStockIn.dto;

import com.palette.busi.project.tms.common.base.BaseReqDto;

public class CsmStockInRespDto extends BaseReqDto {

	private Integer tmPiecesId;
	private String referenceNo;

	public Integer getTmPiecesId() {
		return tmPiecesId;
	}

	public void setTmPiecesId(Integer tmPiecesId) {
		this.tmPiecesId = tmPiecesId;
	}

	public String getReferenceNo() {
		return referenceNo;
	}

	public void setReferenceNo(String referenceNo) {
		this.referenceNo = referenceNo;
	}
	
}
