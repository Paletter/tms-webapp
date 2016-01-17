package com.palette.busi.project.tms.business.common.service;

import java.math.BigDecimal;

import com.palette.busi.project.tms.business.common.vo.UpdatePiecesStatusVo;
import com.palette.busi.project.tms.core.entity.TmPieces;

public interface CommonPiecesService {

	public void updatePiecesRefInfo(TmPieces tmPieces, String refType, String refCode);
	
	public void updatePiecesStatus(UpdatePiecesStatusVo updatePiecesStatusVo);
	
	public BigDecimal getPiecesChargedWeight(TmPieces tmPieces);
}
