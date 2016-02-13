package com.palette.busi.project.tms.business.delivery.outBatch.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.palette.busi.project.tms.business.common.vo.ComPiecesStatusUpdateVo;
import com.palette.busi.project.tms.business.delivery.outBatch.controller.OutBatchController;
import com.palette.busi.project.tms.business.delivery.outBatch.dto.DeliverOutBatchReqDto;
import com.palette.busi.project.tms.business.delivery.outBatch.service.OutBatchService;
import com.palette.busi.project.tms.common.base.BaseServiceImpl;
import com.palette.busi.project.tms.common.constant.CodeConstants;
import com.palette.busi.project.tms.common.util.DateUtils;
import com.palette.busi.project.tms.common.vo.ServiceOptParamLinkerVo;
import com.palette.busi.project.tms.core.dao.TmOutBatchDao;
import com.palette.busi.project.tms.core.dao.TmPiecesDao;
import com.palette.busi.project.tms.core.entity.TmOutBatch;
import com.palette.busi.project.tms.core.entity.TmPieces;

@Service
@Transactional
public class OutBatchServiceImpl extends BaseServiceImpl implements OutBatchService {

	@Autowired
	private TmOutBatchDao tmOutBatchDao;
	@Autowired
	private TmPiecesDao tmPiecesDao;
	
	@Override
	public TmOutBatch createOutBatch(ServiceOptParamLinkerVo linkerVo) {
		
		TmOutBatch tmOutBatch = new TmOutBatch();
		tmOutBatch.setOutBatchNo(servicePvd.commonSeqNumberService.generateOutBatchNo());
		tmOutBatch.setOutDate(DateUtils.getCurrentGMTDate());
		tmOutBatch.setCountryCode(linkerVo.getCountryCode());
		tmOutBatch.setWarehouseCode(linkerVo.getWarehouseCode());
		tmOutBatch.setStatus(CodeConstants.OUT_BATCH_STATUS.INITIAL);
		tmOutBatch.setCompanyCode(linkerVo.getCompanyCode());
		tmOutBatchDao.insertTmOutBatch(tmOutBatch, linkerVo.getUserName(), OutBatchController.CONTROLLER_ID);
		
		return tmOutBatch;
	}
	
	@Override
	public void deliverOutBatch(DeliverOutBatchReqDto reqDto, ServiceOptParamLinkerVo linkerVo) {
		
		TmOutBatch tmOutBatchUpdate = new TmOutBatch();
		tmOutBatchUpdate.setTmOutBatchId(reqDto.getTmOutBatchId());
		tmOutBatchUpdate.setStatus(CodeConstants.OUT_BATCH_STATUS.OUT);
		tmOutBatchDao.updateTmOutBatch(tmOutBatchUpdate, linkerVo.getUserName(), OutBatchController.CONTROLLER_ID);
	}
	
	@Override
	public void deliverPieces(DeliverOutBatchReqDto reqDto, ServiceOptParamLinkerVo linkerVo) {
		
		TmPieces tmPiecesQuery = new TmPieces();
		tmPiecesQuery.setTmOutBatchId(reqDto.getTmOutBatchId());
		List<TmPieces> tmPiecesList = querier.selectTmPiecesAllByRecord(tmPiecesQuery);
		for(TmPieces tmPieces : tmPiecesList) {
			
			tmPieces.setDeliveryDate(DateUtils.getCurrentGMTDate());
			tmPiecesDao.updateTmPieces(tmPieces, linkerVo.getUserName(), OutBatchController.CONTROLLER_ID);
			
			ComPiecesStatusUpdateVo updateVo = servicePvd.commonPiecesService.createPiecesStatusUpdateVo(tmPieces.getTmPiecesId()
					 																					,tmPieces.getPiecesNo()
					 																					,CodeConstants.PIECES_ACTION.CO
					 																					,"包裹出仓"
					 																					,OutBatchController.CONTROLLER_ID
					 																					,linkerVo);
			
			servicePvd.commonPiecesService.updatePiecesStatus(updateVo);
		}
	}
}
