package com.palette.busi.project.tms.business.receive.piecesStockIn.service;

import com.palette.busi.project.tms.business.receive.piecesStockIn.dto.PiecesStockInReqDto;
import com.palette.busi.project.tms.common.vo.ServiceOptParamLinkerVo;
import com.palette.busi.project.tms.core.entity.TmPieces;

public interface PiecesStockInService {

	public TmPieces queryCanStockInPiecesInfoByLogisticNo(String logisticsNo);
	public void formatPiecesStockInUpdateVo(PiecesStockInReqDto reqDto);
	public TmPieces updatePiecesInfoForStockIn(PiecesStockInReqDto reqDto, ServiceOptParamLinkerVo linkerVo);
}
