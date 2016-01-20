package com.palette.busi.project.tms.business.storage.checkWeight.service.impl;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.palette.busi.project.tms.business.common.vo.ComPiecesStatusUpdateVo;
import com.palette.busi.project.tms.business.storage.checkWeight.controller.CheckWeightController;
import com.palette.busi.project.tms.business.storage.checkWeight.service.CheckWeightService;
import com.palette.busi.project.tms.business.storage.checkWeight.vo.CWPiecesInfoResultVo;
import com.palette.busi.project.tms.business.storage.checkWeight.vo.CWPiecesQueryParamVo;
import com.palette.busi.project.tms.business.storage.checkWeight.vo.CheckWeightUpdateVo;
import com.palette.busi.project.tms.common.base.BaseServiceImpl;
import com.palette.busi.project.tms.common.constant.CodeConstants;
import com.palette.busi.project.tms.common.constant.SqlMapperConstants;
import com.palette.busi.project.tms.common.util.DateUtils;
import com.palette.busi.project.tms.common.util.StringUtils;
import com.palette.busi.project.tms.common.vo.ServiceOptParamLinkerVo;
import com.palette.busi.project.tms.core.dao.TmPiecesDao;
import com.palette.busi.project.tms.core.entity.TmPieces;

@Service
public class CheckWeightServiceImpl extends BaseServiceImpl implements CheckWeightService {

	@Autowired
	private TmPiecesDao tmPiecesDao;
	
	@Override
	public CWPiecesInfoResultVo queryCheckWeightPieces(CWPiecesQueryParamVo checkWeightPiecesQueryParamVo) {
		
		CWPiecesInfoResultVo resultVo = selectOne(SqlMapperConstants.CHECK_WEIGHT_QUERY_CHECK_WEIGHT_PIECES, checkWeightPiecesQueryParamVo.getQueryNo());
		return resultVo;
	}

	@Override
	public void formatCheckWeightUpdateVo(CheckWeightUpdateVo checkWeightUpdateVo) {
		
		if(checkWeightUpdateVo.getActualWeight() != null) {
			BigDecimal kernelWeight = checkWeightUpdateVo.getActualWeight();
			checkWeightUpdateVo.setActualWeight(kernelWeight.setScale(2, BigDecimal.ROUND_UP));
		}
		
		if(checkWeightUpdateVo.getVolumeWeight() != null) {
			BigDecimal volumeWeight = checkWeightUpdateVo.getVolumeWeight();
			checkWeightUpdateVo.setVolumeWeight(volumeWeight.setScale(2, BigDecimal.ROUND_UP));
		}
		
		checkWeightUpdateVo.setPiecesNo(StringUtils.toUpperAndTrim(checkWeightUpdateVo.getPiecesNo()));
	}

	@Override
	public void updatePiecesInfoForCkeckWeight(CheckWeightUpdateVo updateVo, ServiceOptParamLinkerVo paramLinkerVo) {

		TmPieces piecesQueryPram = new TmPieces();
		piecesQueryPram.setPiecesNo(updateVo.getPiecesNo());
		TmPieces updatePieces = querier.selectTmPiecesOneByRecord(piecesQueryPram);
		
		// Update pieces
		if(updateVo.getActualWeight() != null) {
			updatePieces.setActualWeight(updateVo.getActualWeight());
		}
		if(updateVo.getVolumeWeight() != null) {
			updatePieces.setWidth(updateVo.getWidth());
			updatePieces.setHeight(updateVo.getHeight());
			updatePieces.setLength(updateVo.getLength());
			updatePieces.setVolumeWeight(updateVo.getVolumeWeight());
		}
		updatePieces.setWarehouseCode(paramLinkerVo.getWarehouseCode());
		
		tmPiecesDao.updateTmPieces(updatePieces, paramLinkerVo.getUserName(), CheckWeightController.CONTROLLER_ID);
		
		// Insert or Update pieces current and history
		ComPiecesStatusUpdateVo updatePiecesStatusVo = createCheckWeightUpdatePiecesStatusVo(updatePieces, paramLinkerVo);
		servicePvd.commonPiecesService.updatePiecesStatus(updatePiecesStatusVo);
	}
	
	private ComPiecesStatusUpdateVo createCheckWeightUpdatePiecesStatusVo(TmPieces tmPieces, ServiceOptParamLinkerVo paramLinkerVo) {
		
		ComPiecesStatusUpdateVo updatePiecesStatusVo = new ComPiecesStatusUpdateVo(paramLinkerVo.getUserName(), CheckWeightController.CONTROLLER_ID);
		
		updatePiecesStatusVo.setTmPiecesId(tmPieces.getTmPiecesId());
		updatePiecesStatusVo.setPiecesNo(tmPieces.getPiecesNo());
		updatePiecesStatusVo.setActionCode(CodeConstants.PIECES_ACTION.KW);
		updatePiecesStatusVo.setActionDateTime(DateUtils.getCurrentGMTDate());
		updatePiecesStatusVo.setActionUserName(paramLinkerVo.getUserName());
		BigDecimal chargedWeight = servicePvd.commonPiecesService.getPiecesChargedWeight(tmPieces);
		String memo = StringUtils.concat(paramLinkerVo.getWarehouseDesc(), " 核重包裹，计费重量", chargedWeight.toString(), paramLinkerVo.getWeightUnit());
		updatePiecesStatusVo.setMemo(memo);
		updatePiecesStatusVo.setUserName(paramLinkerVo.getUserName());
		
		return updatePiecesStatusVo;
	}
	
}
