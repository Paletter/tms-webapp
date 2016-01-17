package com.palette.busi.project.tms.business.receive.piecesStockIn.service;

import com.palette.busi.project.tms.business.receive.piecesStockIn.vo.PiecesStockInUpdateVo;

public interface PiecesStockInValidateService {

	public void validateNormalPiecesStockIn(PiecesStockInUpdateVo piecesStockInUpdateVo);
	public void validateUnconsignedPiecesStockIn(PiecesStockInUpdateVo piecesStockInUpdateVo);
}
