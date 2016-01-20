package com.palette.busi.project.tms.business.receive.piecesStockIn.service.impl;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.palette.busi.project.tms.business.common.vo.ComPiecesStatusUpdateVo;
import com.palette.busi.project.tms.business.receive.piecesStockIn.controller.PiecesStockInController;
import com.palette.busi.project.tms.business.receive.piecesStockIn.service.PiecesStockInService;
import com.palette.busi.project.tms.business.receive.piecesStockIn.vo.PiecesStockInUpdateVo;
import com.palette.busi.project.tms.common.base.BaseServiceImpl;
import com.palette.busi.project.tms.common.constant.CodeConstants;
import com.palette.busi.project.tms.common.constant.SqlMapperConstants;
import com.palette.busi.project.tms.common.util.DateUtils;
import com.palette.busi.project.tms.common.util.StringUtils;
import com.palette.busi.project.tms.common.vo.ServiceOptParamLinkerVo;
import com.palette.busi.project.tms.core.dao.TmPiecesDao;
import com.palette.busi.project.tms.core.entity.TmPieces;

@Service
@Transactional
public class PiecesStockInServiceImpl extends BaseServiceImpl implements PiecesStockInService {

	@Autowired
	private TmPiecesDao tmPiecesDao;
	
	@Override
	public TmPieces queryCanStockInPiecesInfoByLogisticNo(String logisticsNo) {
		
		TmPieces piecesQuery = new TmPieces();
		piecesQuery.setLogisticsNo(logisticsNo);
		TmPieces tmPieces = selectOneWithEx(SqlMapperConstants.PIECES_STOCK_IN_QUERY_STOCK_IN_PIECES, logisticsNo);
		return tmPieces;
	}
	
	@Override
	public void formatPiecesStockInUpdateVo(PiecesStockInUpdateVo piecesStockInUpdateVo) {
		
		if(piecesStockInUpdateVo.getActualWeight() != null) {
			piecesStockInUpdateVo.setActualWeight(piecesStockInUpdateVo.getActualWeight().setScale(2, BigDecimal.ROUND_UP));
		}
		
		if(piecesStockInUpdateVo.getVolumeWeight() != null) {
			piecesStockInUpdateVo.setVolumeWeight(piecesStockInUpdateVo.getVolumeWeight().setScale(2, BigDecimal.ROUND_UP));
			piecesStockInUpdateVo.setLength(piecesStockInUpdateVo.getLength().setScale(2, BigDecimal.ROUND_UP));
			piecesStockInUpdateVo.setWidth(piecesStockInUpdateVo.getWidth().setScale(2, BigDecimal.ROUND_UP));
			piecesStockInUpdateVo.setHeight(piecesStockInUpdateVo.getHeight().setScale(2, BigDecimal.ROUND_UP));
		}
		
		piecesStockInUpdateVo.setLogisticsNo(StringUtils.toUpperAndTrim(piecesStockInUpdateVo.getLogisticsNo()));
	}

	@Override
	public TmPieces updatePiecesInfoForStockIn(PiecesStockInUpdateVo piecesStockInUpdateVo, ServiceOptParamLinkerVo paramLinkerVo) {
		
		TmPieces updatePieces = null;
		
		if(piecesStockInUpdateVo.getTmPiecesId() == null) {
			updatePieces = new TmPieces();
			updatePieces.setPiecesNo(servicePvd.commonSeqNumberService.generatePiecesNo());
		}
		
		if(piecesStockInUpdateVo.getTmPiecesId() != null) {
			updatePieces = querier.selectTmPiecesById(piecesStockInUpdateVo.getTmPiecesId());
		}

		// Inser or Update pieces
		updatePieces.setActualWeight(piecesStockInUpdateVo.getActualWeight());
		updatePieces.setLength(piecesStockInUpdateVo.getLength());
		updatePieces.setWidth(piecesStockInUpdateVo.getWidth());
		updatePieces.setHeight(piecesStockInUpdateVo.getHeight());
		updatePieces.setVolumeWeight(piecesStockInUpdateVo.getVolumeWeight());
		updatePieces.setMemberCode(piecesStockInUpdateVo.getMemberCode());
		updatePieces.setLogisticsNo(StringUtils.toUpperAndTrim(piecesStockInUpdateVo.getLogisticsNo()));
		updatePieces.setWarehouseCode(paramLinkerVo.getWarehouseCode());
		updatePieces.setMemo(piecesStockInUpdateVo.getMemo());
		if(updatePieces.getCheckDate() == null) updatePieces.setCheckDate(DateUtils.getCurrentGMTDate());
		
		updatePieces = tmPiecesDao.saveTmPieces(updatePieces, paramLinkerVo.getUserName(), PiecesStockInController.CONTROLLER_ID);
		
		// Insert or Update pieces current and history
		ComPiecesStatusUpdateVo updatePiecesStatusVo = createStockInUpdatePiecesStatusVo(updatePieces, paramLinkerVo);
		servicePvd.commonPiecesService.updatePiecesStatus(updatePiecesStatusVo);
		
		return updatePieces;
	}
	
	private ComPiecesStatusUpdateVo createStockInUpdatePiecesStatusVo(TmPieces tmPieces, ServiceOptParamLinkerVo paramLinkerVo) {
		
		ComPiecesStatusUpdateVo updatePiecesStatusVo = new ComPiecesStatusUpdateVo(paramLinkerVo.getUserName(), PiecesStockInController.CONTROLLER_ID);
		
		updatePiecesStatusVo.setTmPiecesId(tmPieces.getTmPiecesId());
		updatePiecesStatusVo.setPiecesNo(tmPieces.getPiecesNo());
		updatePiecesStatusVo.setActionCode(CodeConstants.PIECES_ACTION.CI);
		updatePiecesStatusVo.setActionDateTime(DateUtils.getCurrentGMTDate());
		updatePiecesStatusVo.setActionUserName(paramLinkerVo.getUserName());
		BigDecimal chargedWeight = servicePvd.commonPiecesService.getPiecesChargedWeight(tmPieces);
		String memo = StringUtils.concat(paramLinkerVo.getWarehouseDesc(), " 称重，计费重量", chargedWeight.toString(), paramLinkerVo.getWeightUnit(), "， 打印标签");
		updatePiecesStatusVo.setMemo(memo);
		updatePiecesStatusVo.setUserName(paramLinkerVo.getUserName());
		
		return updatePiecesStatusVo;
	}
}
