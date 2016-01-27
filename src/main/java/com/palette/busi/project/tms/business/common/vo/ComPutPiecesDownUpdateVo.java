package com.palette.busi.project.tms.business.common.vo;

import com.palette.busi.project.tms.common.base.BaseUpdateVo;
import com.palette.busi.project.tms.core.entity.TmPieces;

public class ComPutPiecesDownUpdateVo extends BaseUpdateVo {

	private TmPieces tmPieces;
	private String memo;
	
	public ComPutPiecesDownUpdateVo(String userName, String controllerId) {
		super(userName, controllerId);
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
