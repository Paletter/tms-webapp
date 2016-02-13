package com.palette.busi.project.tms.business.common.service;

import java.math.BigDecimal;

import com.palette.busi.project.tms.business.common.vo.ComPiecesRefUpdateVo;
import com.palette.busi.project.tms.business.common.vo.ComPiecesStatusUpdateVo;
import com.palette.busi.project.tms.business.common.vo.ComUsablePiecesQueryVo;
import com.palette.busi.project.tms.business.common.vo.ComUsablePiecesResultVo;
import com.palette.busi.project.tms.common.vo.ServiceOptParamLinkerVo;
import com.palette.busi.project.tms.core.entity.TmPieces;

public interface CommonPiecesService {

	/**
	 * @param tmPiecesId
	 * @param piecesNo
	 * @param actionCode
	 * @param memo
	 * @param controllerId
	 * @param linkerVo
	 * @return ComPiecesStatusUpdateVo
	 */
	public ComPiecesStatusUpdateVo createPiecesStatusUpdateVo(Integer tmPiecesId,
			String piecesNo, String actionCode, String memo,
			String controllerId, ServiceOptParamLinkerVo linkerVo);
	
	public void updatePiecesRefInfo(ComPiecesRefUpdateVo updateVo);
	public void updatePiecesStatus(ComPiecesStatusUpdateVo updateVo);
	public BigDecimal getPiecesChargedWeight(TmPieces tmPieces);
	public ComUsablePiecesResultVo queryUsablePieces(ComUsablePiecesQueryVo queryVo, ServiceOptParamLinkerVo linkerVo);
}
