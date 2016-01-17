package com.palette.busi.project.tms.business.receive.piecesStockIn.service.impl;

import org.springframework.stereotype.Service;

import com.palette.busi.project.tms.business.receive.piecesStockIn.service.PiecesStockInValidateService;
import com.palette.busi.project.tms.business.receive.piecesStockIn.vo.PiecesStockInUpdateVo;
import com.palette.busi.project.tms.common.util.BigDecimalUtils;
import com.palette.busi.project.tms.web.exception.BusinessException;

@Service
public class PiecesStockInValidateServiceImpl implements PiecesStockInValidateService {

	@Override
	public void validateNormalPiecesStockIn(PiecesStockInUpdateVo piecesStockInUpdateVo) {
		
		if(piecesStockInUpdateVo.getTmPiecesId() == null) {
			throw new BusinessException("操作失败。运单信息为空");
		}
		
		if((piecesStockInUpdateVo.getActualWeight() == null || BigDecimalUtils.isZero(piecesStockInUpdateVo.getActualWeight()))
		   && (piecesStockInUpdateVo.getVolumeWeight() == null || BigDecimalUtils.isZero(piecesStockInUpdateVo.getVolumeWeight()))) {
			
			throw new BusinessException("操作失败。必须输入包裹毛重或体积重");
		}
	}
	
	@Override
	public void validateUnconsignedPiecesStockIn(PiecesStockInUpdateVo piecesStockInUpdateVo) {
		
		if((piecesStockInUpdateVo.getActualWeight() == null || BigDecimalUtils.isZero(piecesStockInUpdateVo.getActualWeight()))
		   && (piecesStockInUpdateVo.getVolumeWeight() == null || BigDecimalUtils.isZero(piecesStockInUpdateVo.getVolumeWeight()))) {
			
			throw new BusinessException("操作错误，必须输入包裹毛重或体积重");
		}
	}
}
