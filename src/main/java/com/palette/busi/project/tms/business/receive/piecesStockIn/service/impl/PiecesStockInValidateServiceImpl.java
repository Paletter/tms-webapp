package com.palette.busi.project.tms.business.receive.piecesStockIn.service.impl;

import org.springframework.stereotype.Service;

import com.palette.busi.project.tms.business.receive.piecesStockIn.service.PiecesStockInValidateService;
import com.palette.busi.project.tms.business.receive.piecesStockIn.vo.PiecesStockInUpdateVo;
import com.palette.busi.project.tms.common.util.ThrowExp;

@Service
public class PiecesStockInValidateServiceImpl implements PiecesStockInValidateService {

	@Override
	public void validateNormalPiecesStockIn(PiecesStockInUpdateVo piecesStockInUpdateVo) {
		
		ThrowExp.isNull(piecesStockInUpdateVo.getTmPiecesId(), "操作失败。运单信息为空");
		ThrowExp.isNull(piecesStockInUpdateVo.getActualWeight(), "操作失败。必须输入包裹毛重");
	}
	
	@Override
	public void validateUnconsignedPiecesStockIn(PiecesStockInUpdateVo piecesStockInUpdateVo) {
		
		ThrowExp.isNull(piecesStockInUpdateVo.getActualWeight(), "操作失败。必须输入包裹毛重");
	}
}
