package com.palette.busi.project.tms.business.receive.piecesStockIn.service.impl;

import org.springframework.stereotype.Service;

import com.palette.busi.project.tms.business.receive.piecesStockIn.dto.PiecesStockInReqDto;
import com.palette.busi.project.tms.business.receive.piecesStockIn.service.PiecesStockInValidateService;
import com.palette.busi.project.tms.common.util.ThrowExp;

@Service
public class PiecesStockInValidateServiceImpl implements PiecesStockInValidateService {

	@Override
	public void validateNormalPiecesStockIn(PiecesStockInReqDto reqDto) {
		
		ThrowExp.isNull(reqDto.getTmPiecesId(), "操作失败。运单信息为空");
		ThrowExp.isNull(reqDto.getActualWeight(), "操作失败。必须输入包裹实重");
	}
	
	@Override
	public void validateUnconsignedPiecesStockIn(PiecesStockInReqDto reqDto) {
		
		ThrowExp.isNull(reqDto.getActualWeight(), "操作失败。必须输入包裹实重");
	}
}
