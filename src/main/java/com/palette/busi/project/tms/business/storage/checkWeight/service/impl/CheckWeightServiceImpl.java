package com.palette.busi.project.tms.business.storage.checkWeight.service.impl;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.palette.busi.project.tms.business.common.vo.ComPiecesStatusUpdateVo;
import com.palette.busi.project.tms.business.storage.checkWeight.controller.CheckWeightController;
import com.palette.busi.project.tms.business.storage.checkWeight.dto.CheckWeightReqDto;
import com.palette.busi.project.tms.business.storage.checkWeight.dto.QueryCheckWeightPiecesReqDto;
import com.palette.busi.project.tms.business.storage.checkWeight.service.CheckWeightService;
import com.palette.busi.project.tms.business.storage.checkWeight.vo.CWPiecesInfoResultVo;
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
public class CheckWeightServiceImpl extends BaseServiceImpl implements CheckWeightService {

	@Autowired
	private TmPiecesDao tmPiecesDao;
	
	@Override
	public CWPiecesInfoResultVo queryCheckWeightPieces(QueryCheckWeightPiecesReqDto reqDto) {
		
		CWPiecesInfoResultVo resultVo = selectOne(SqlMapperConstants.CHECK_WEIGHT_QUERY_CHECK_WEIGHT_PIECES, reqDto.getQueryNo());
		return resultVo;
	}

	@Override
	public void formatCheckWeightUpdateVo(CheckWeightReqDto reqDto) {
		
		if(reqDto.getActualWeight() != null) {
			BigDecimal kernelWeight = reqDto.getActualWeight();
			reqDto.setActualWeight(kernelWeight.setScale(2, BigDecimal.ROUND_UP));
		}
		
		if(reqDto.getVolumeWeight() != null) {
			BigDecimal volumeWeight = reqDto.getVolumeWeight();
			reqDto.setVolumeWeight(volumeWeight.setScale(2, BigDecimal.ROUND_UP));
		}
		
		reqDto.setPiecesNo(StringUtils.toUpperAndTrim(reqDto.getPiecesNo()));
	}

	@Override
	public void updatePiecesInfoForCkeckWeight(CheckWeightReqDto reqDto, ServiceOptParamLinkerVo linkerVo) {

		TmPieces piecesQueryPram = new TmPieces();
		piecesQueryPram.setPiecesNo(reqDto.getPiecesNo());
		TmPieces updatePieces = querier.selectTmPiecesOneByRecord(piecesQueryPram);
		
		// Update pieces
		if(reqDto.getActualWeight() != null) {
			updatePieces.setActualWeight(reqDto.getActualWeight());
		}
		if(reqDto.getVolumeWeight() != null) {
			updatePieces.setWidth(reqDto.getWidth());
			updatePieces.setHeight(reqDto.getHeight());
			updatePieces.setLength(reqDto.getLength());
			updatePieces.setVolumeWeight(reqDto.getVolumeWeight());
		}
		updatePieces.setWarehouseCode(linkerVo.getWarehouseCode());
		
		tmPiecesDao.updateTmPieces(updatePieces, linkerVo.getUserName(), CheckWeightController.CONTROLLER_ID);
		
		// Insert or Update pieces current and history
		ComPiecesStatusUpdateVo updatePiecesStatusVo = createCheckWeightUpdatePiecesStatusVo(updatePieces, linkerVo);
		servicePvd.commonPiecesService.updatePiecesStatus(updatePiecesStatusVo);
	}
	
	private ComPiecesStatusUpdateVo createCheckWeightUpdatePiecesStatusVo(TmPieces tmPieces, ServiceOptParamLinkerVo linkerVo) {
		
		ComPiecesStatusUpdateVo updatePiecesStatusVo = new ComPiecesStatusUpdateVo(linkerVo.getUserName(), CheckWeightController.CONTROLLER_ID);
		
		updatePiecesStatusVo.setTmPiecesId(tmPieces.getTmPiecesId());
		updatePiecesStatusVo.setPiecesNo(tmPieces.getPiecesNo());
		updatePiecesStatusVo.setActionCode(CodeConstants.PIECES_ACTION.KW);
		updatePiecesStatusVo.setActionDateTime(DateUtils.getCurrentGMTDate());
		updatePiecesStatusVo.setActionUserName(linkerVo.getUserName());
		String memo = StringUtils.concat(linkerVo.getWarehouseDesc(), " 核重包裹，实重", tmPieces.getActualWeight().toString(), linkerVo.getWeightUnit());
		updatePiecesStatusVo.setMemo(memo);
		updatePiecesStatusVo.setUserName(linkerVo.getUserName());
		
		return updatePiecesStatusVo;
	}
	
}
