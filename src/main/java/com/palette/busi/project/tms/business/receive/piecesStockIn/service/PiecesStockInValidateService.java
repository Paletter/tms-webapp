package com.palette.busi.project.tms.business.receive.piecesStockIn.service;

import com.palette.busi.project.tms.business.receive.piecesStockIn.dto.PiecesStockInReqDto;

public interface PiecesStockInValidateService {

	public void validateNormalPiecesStockIn(PiecesStockInReqDto reqDto);
	public void validateUnconsignedPiecesStockIn(PiecesStockInReqDto reqDto);
}
