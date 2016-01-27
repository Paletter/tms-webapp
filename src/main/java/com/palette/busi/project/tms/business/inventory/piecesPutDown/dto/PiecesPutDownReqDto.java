package com.palette.busi.project.tms.business.inventory.piecesPutDown.dto;

import com.palette.busi.project.tms.common.base.BaseReqDto;

public class PiecesPutDownReqDto extends BaseReqDto {

	private String putDownNo;

	public String getPutDownNo() {
		return putDownNo;
	}

	public void setPutDownNo(String putDownNo) {
		this.putDownNo = putDownNo;
	}
	
}
