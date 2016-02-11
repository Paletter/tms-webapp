package com.palette.busi.project.tms.business.delivery.packGoods.dto;

import java.util.List;

import com.palette.busi.project.tms.business.delivery.packGoods.vo.UnitCsmInfoResultVo;
import com.palette.busi.project.tms.common.base.BaseRespDto;
import com.palette.busi.project.tms.core.entity.TmUnit;

public class QueryUnitCsmInfoRespDto extends BaseRespDto {

	private TmUnit tmUnit;
	private List<UnitCsmInfoResultVo> unitCsmList;

	public TmUnit getTmUnit() {
		return tmUnit;
	}

	public void setTmUnit(TmUnit tmUnit) {
		this.tmUnit = tmUnit;
	}

	public List<UnitCsmInfoResultVo> getUnitCsmList() {
		return unitCsmList;
	}

	public void setUnitCsmList(List<UnitCsmInfoResultVo> unitCsmList) {
		this.unitCsmList = unitCsmList;
	}
}
