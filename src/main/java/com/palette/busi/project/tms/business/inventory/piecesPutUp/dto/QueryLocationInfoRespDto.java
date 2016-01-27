package com.palette.busi.project.tms.business.inventory.piecesPutUp.dto;

import java.util.List;

import com.palette.busi.project.tms.common.base.BaseRespDto;
import com.palette.busi.project.tms.core.entity.WmLocation;
import com.palette.busi.project.tms.core.entity.WmLocationCurrent;

public class QueryLocationInfoRespDto extends BaseRespDto {

	private WmLocation wmLocation;
	private List<WmLocationCurrent> wmLocationCurrentList;

	public WmLocation getWmLocation() {
		return wmLocation;
	}

	public void setWmLocation(WmLocation wmLocation) {
		this.wmLocation = wmLocation;
	}

	public List<WmLocationCurrent> getWmLocationCurrentList() {
		return wmLocationCurrentList;
	}

	public void setWmLocationCurrentList(
			List<WmLocationCurrent> wmLocationCurrentList) {
		this.wmLocationCurrentList = wmLocationCurrentList;
	}
	
}
