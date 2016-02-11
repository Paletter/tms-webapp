package com.palette.busi.project.tms.business.receive.piecesStockIn.service.impl;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.palette.busi.project.tms.business.common.vo.ComPiecesStatusUpdateVo;
import com.palette.busi.project.tms.business.receive.piecesStockIn.controller.PiecesStockInController;
import com.palette.busi.project.tms.business.receive.piecesStockIn.dto.PiecesStockInReqDto;
import com.palette.busi.project.tms.business.receive.piecesStockIn.service.PiecesStockInService;
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
	public void formatPiecesStockInUpdateVo(PiecesStockInReqDto reqDto) {
		
		if(reqDto.getActualWeight() != null) {
			reqDto.setActualWeight(reqDto.getActualWeight().setScale(2, BigDecimal.ROUND_UP));
		}
		
		if(reqDto.getVolumeWeight() != null) {
			reqDto.setVolumeWeight(reqDto.getVolumeWeight().setScale(2, BigDecimal.ROUND_UP));
			reqDto.setLength(reqDto.getLength().setScale(2, BigDecimal.ROUND_UP));
			reqDto.setWidth(reqDto.getWidth().setScale(2, BigDecimal.ROUND_UP));
			reqDto.setHeight(reqDto.getHeight().setScale(2, BigDecimal.ROUND_UP));
		}
		
		reqDto.setLogisticsNo(StringUtils.toUpperAndTrim(reqDto.getLogisticsNo()));
	}

	@Override
	public TmPieces updatePiecesInfoForStockIn(PiecesStockInReqDto reqDto, ServiceOptParamLinkerVo linkerVo) {
		
		TmPieces updatePieces = null;
		
		if(reqDto.getTmPiecesId() == null) {
			updatePieces = new TmPieces();
			updatePieces.setPiecesNo(servicePvd.commonSeqNumberService.generatePiecesNo());
		}
		
		if(reqDto.getTmPiecesId() != null) {
			updatePieces = querier.selectTmPiecesById(reqDto.getTmPiecesId());
		}

		// Inser or Update pieces
		updatePieces.setActualWeight(reqDto.getActualWeight());
		updatePieces.setLength(reqDto.getLength());
		updatePieces.setWidth(reqDto.getWidth());
		updatePieces.setHeight(reqDto.getHeight());
		updatePieces.setVolumeWeight(reqDto.getVolumeWeight());
		updatePieces.setMemberCode(reqDto.getMemberCode());
		updatePieces.setLogisticsNo(StringUtils.toUpperAndTrim(reqDto.getLogisticsNo()));
		updatePieces.setWarehouseCode(linkerVo.getWarehouseCode());
		updatePieces.setMemo(reqDto.getMemo());
		if(updatePieces.getCheckDate() == null) updatePieces.setCheckDate(DateUtils.getCurrentGMTDate());
		
		updatePieces = tmPiecesDao.saveTmPieces(updatePieces, linkerVo.getUserName(), PiecesStockInController.CONTROLLER_ID);
		
		// Insert or Update pieces current and history
		ComPiecesStatusUpdateVo updatePiecesStatusVo = createStockInUpdatePiecesStatusVo(updatePieces, linkerVo);
		servicePvd.commonPiecesService.updatePiecesStatus(updatePiecesStatusVo);
		
		return updatePieces;
	}
	
	private ComPiecesStatusUpdateVo createStockInUpdatePiecesStatusVo(TmPieces tmPieces, ServiceOptParamLinkerVo linkerVo) {
		
		ComPiecesStatusUpdateVo updateVo = new ComPiecesStatusUpdateVo(linkerVo.getUserName(), PiecesStockInController.CONTROLLER_ID);
		
		updateVo.setTmPiecesId(tmPieces.getTmPiecesId());
		updateVo.setPiecesNo(tmPieces.getPiecesNo());
		updateVo.setActionCode(CodeConstants.PIECES_ACTION.CI);
		updateVo.setActionDateTime(DateUtils.getCurrentGMTDate());
		updateVo.setActionUserName(linkerVo.getUserName());
		BigDecimal chargedWeight = servicePvd.commonPiecesService.getPiecesChargedWeight(tmPieces);
		String memo = StringUtils.concat(linkerVo.getWarehouseDesc(), " 称重，计费重量", chargedWeight.toString(), linkerVo.getWeightUnit(), "， 打印标签");
		updateVo.setMemo(memo);
		updateVo.setUserName(linkerVo.getUserName());
		
		return updateVo;
	}
}
