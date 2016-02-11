package com.palette.busi.project.tms.business.delivery.flight.dto;

import com.palette.busi.project.tms.common.base.BaseReqDto;

public class DeleteUnitReqDto extends BaseReqDto {

	private Integer tmUnitId;

	public Integer getTmUnitId() {
		return tmUnitId;
	}

	public void setTmUnitId(Integer tmUnitId) {
		this.tmUnitId = tmUnitId;
	}
	
}
