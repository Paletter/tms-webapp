package com.palette.busi.project.tms.business.common.service;

import java.math.BigDecimal;

import com.palette.busi.project.tms.business.common.vo.ComPiecesRefUpdateVo;
import com.palette.busi.project.tms.business.common.vo.ComPiecesStatusUpdateVo;
import com.palette.busi.project.tms.core.entity.TmPieces;

public interface CommonPiecesService {

	public void updatePiecesRefInfo(ComPiecesRefUpdateVo updateVo);
	
	public void updatePiecesStatus(ComPiecesStatusUpdateVo updateVo);
	
	public BigDecimal getPiecesChargedWeight(TmPieces tmPieces);
}
