package com.palette.busi.project.tms.business.delivery.packGoods.dto;

import com.palette.busi.project.tms.common.base.BaseReqDto;
import com.palette.busi.project.tms.core.entity.TmUnit;

public class PackPiecesOutUnitReqDto extends BaseReqDto {

	private TmUnit tmUnit;
	private String packNo;

	public TmUnit getTmUnit() {
		return tmUnit;
	}

	public void setTmUnit(TmUnit tmUnit) {
		this.tmUnit = tmUnit;
	}

	public String getPackNo() {
		return packNo;
	}

	public void setPackNo(String packNo) {
		this.packNo = packNo;
	}
	
}
