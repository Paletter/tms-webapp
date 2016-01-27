package com.palette.busi.project.tms.business.inventory.piecesPutUp.dto;

import com.palette.busi.project.tms.common.base.BaseReqDto;
import com.palette.busi.project.tms.core.entity.WmLocation;

public class PiecesPutUpReqDto extends BaseReqDto {

	private WmLocation wmLocation;
	private String putUpNo;

	public WmLocation getWmLocation() {
		return wmLocation;
	}

	public void setWmLocation(WmLocation wmLocation) {
		this.wmLocation = wmLocation;
	}

	public String getPutUpNo() {
		return putUpNo;
	}

	public void setPutUpNo(String putUpNo) {
		this.putUpNo = putUpNo;
	}
	
}
