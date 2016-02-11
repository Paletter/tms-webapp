package com.palette.busi.project.tms.business.delivery.flight.dto;

import java.util.List;

import com.palette.busi.project.tms.common.base.BaseRespDto;
import com.palette.busi.project.tms.core.entity.TmUnit;

public class QueryUnitListRespDto extends BaseRespDto {

	private List<TmUnit> tmUnitList;

	public List<TmUnit> getTmUnitList() {
		return tmUnitList;
	}

	public void setTmUnitList(List<TmUnit> tmUnitList) {
		this.tmUnitList = tmUnitList;
	}
	
}
