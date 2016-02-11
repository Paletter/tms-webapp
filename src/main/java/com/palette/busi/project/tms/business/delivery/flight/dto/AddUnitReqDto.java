package com.palette.busi.project.tms.business.delivery.flight.dto;

import com.palette.busi.project.tms.common.base.BaseReqDto;

public class AddUnitReqDto extends BaseReqDto {

	private Integer tmSectorId;
	private String sectorCode;
	private String unitLabel;
	private String mawbCode;

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

	public String getUnitLabel() {
		return unitLabel;
	}

	public void setUnitLabel(String unitLabel) {
		this.unitLabel = unitLabel;
	}

	public String getMawbCode() {
		return mawbCode;
	}

	public void setMawbCode(String mawbCode) {
		this.mawbCode = mawbCode;
	}
	
}
