package com.palette.busi.project.tms.business.delivery.flight.dto;

import com.palette.busi.project.tms.common.base.BaseRespDto;

public class AddFlightRespDto extends BaseRespDto {

	private String sectorCode;

	public String getSectorCode() {
		return sectorCode;
	}

	public void setSectorCode(String sectorCode) {
		this.sectorCode = sectorCode;
	}
	
}
