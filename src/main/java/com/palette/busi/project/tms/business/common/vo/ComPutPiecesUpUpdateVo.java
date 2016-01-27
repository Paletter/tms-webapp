package com.palette.busi.project.tms.business.common.vo;

import com.palette.busi.project.tms.common.base.BaseUpdateVo;
import com.palette.busi.project.tms.core.entity.TmPieces;
import com.palette.busi.project.tms.core.entity.WmLocation;

public class ComPutPiecesUpUpdateVo extends BaseUpdateVo {

	private WmLocation wmLocation;
	private TmPieces tmPieces;
	private String memo;
	
	public ComPutPiecesUpUpdateVo(String userName, String controllerId) {
		super(userName, controllerId);
	}

	public WmLocation getWmLocation() {
		return wmLocation;
	}

	public void setWmLocation(WmLocation wmLocation) {
		this.wmLocation = wmLocation;
	}

	public TmPieces getTmPieces() {
		return tmPieces;
	}

	public void setTmPieces(TmPieces tmPieces) {
		this.tmPieces = tmPieces;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}
	
}
