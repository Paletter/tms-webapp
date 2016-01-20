package com.palette.busi.project.tms.business.inventory.piecesPutUp.vo;

import java.util.List;

import com.palette.busi.project.tms.core.entity.WmLocation;
import com.palette.busi.project.tms.core.entity.WmLocationCurrent;

public class LocationInfoResultVo {

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
