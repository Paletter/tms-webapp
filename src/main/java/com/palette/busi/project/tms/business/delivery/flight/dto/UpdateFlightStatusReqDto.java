package com.palette.busi.project.tms.business.delivery.flight.dto;

import com.palette.busi.project.tms.common.base.BaseReqDto;

public class UpdateFlightStatusReqDto extends BaseReqDto {

	private Integer tmSectorId;
	private String sectorCode;

	public Integer getTmSectorId() {
		return tmSectorId;
	}

	public void setTmSectorId(Integer tmSectorId) {
		this.tmSectorId = tmSectorId;
	}

	public String getSectorCode() {
		return sectorCode;
	}

	public void setSectorCode(String sectorCode) {
		this.sectorCode = sectorCode;
	}
	
}
