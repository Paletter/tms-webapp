package com.palette.busi.project.tms.business.delivery.outBatchDeliver.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.palette.busi.project.tms.business.delivery.outBatchDeliver.dto.PackPiecesInOutBatchReqDto;
import com.palette.busi.project.tms.business.delivery.outBatchDeliver.dto.QueryBatchPiecesReqDto;
import com.palette.busi.project.tms.business.delivery.outBatchDeliver.service.OutBatchDeliverService;
import com.palette.busi.project.tms.business.delivery.outBatchDeliver.support.PiecesOutBatchUpdateParam;
import com.palette.busi.project.tms.business.delivery.outBatchDeliver.vo.DeliverPiecesRowVo;
import com.palette.busi.project.tms.common.base.BaseServiceImpl;
import com.palette.busi.project.tms.common.constant.SqlMapperConstants;
import com.palette.busi.project.tms.common.vo.ServiceOptParamLinkerVo;
import com.palette.busi.project.tms.core.dao.TmPiecesDao;
import com.palette.busi.project.tms.core.entity.TmPieces;

@Service
@Transactional
public class OutBatchDeliverServiceImpl extends BaseServiceImpl implements OutBatchDeliverService {

	@Autowired
	private TmPiecesDao tmPiecesDao;
	
	@Override
	public List<DeliverPiecesRowVo> queryBatchPieces(QueryBatchPiecesReqDto reqDto, ServiceOptParamLinkerVo linkerVo) {
		
		TmPieces tmPiecesQuery = new TmPieces();
		tmPiecesQuery.setTmOutBatchId(reqDto.getTmOutBatchId());
		List<TmPieces> tmPiecesList = querier.selectTmPiecesAllByRecord(tmPiecesQuery);
		
		List<DeliverPiecesRowVo> deliverPiecesVoList = new ArrayList<DeliverPiecesRowVo>();
		for(TmPieces tmPieces : tmPiecesList) {
			DeliverPiecesRowVo deliverPiecesVo = new DeliverPiecesRowVo();
			deliverPiecesVo.setPiecesNo(tmPieces.getPiecesNo());
			deliverPiecesVo.setTmPiecesId(tmPieces.getTmPiecesId());
			deliverPiecesVo.setActualWeight(tmPieces.getActualWeight());
			
			deliverPiecesVoList.add(deliverPiecesVo);
		}
		
		return deliverPiecesVoList;
	}
	
	@Override
	public void updatePiecesInOutBatch(PackPiecesInOutBatchReqDto reqDto, ServiceOptParamLinkerVo linkerVo) {
		
		List<PiecesOutBatchUpdateParam> updateParamList = new ArrayList<PiecesOutBatchUpdateParam>();
		List<DeliverPiecesRowVo> deliverPiecesVoList = reqDto.getDeliverPiecesVoList();
		for(DeliverPiecesRowVo deliverPiecesVo : deliverPiecesVoList) {
			
			if(deliverPiecesVo.isAddRow()) {
				PiecesOutBatchUpdateParam updateParam = new PiecesOutBatchUpdateParam();
				updateParam.setTmPiecesId(deliverPiecesVo.getTmPiecesId());
				updateParam.setOutBatchNo(reqDto.getOutBatchNo());
				updateParam.setTmOutBatchId(reqDto.getTmOutBatchId());
				updateParamList.add(updateParam);
			}
			
			if(deliverPiecesVo.isDeletedRow()) {
				PiecesOutBatchUpdateParam updateParam = new PiecesOutBatchUpdateParam();
				updateParam.setTmPiecesId(deliverPiecesVo.getTmPiecesId());
				updateParam.setOutBatchNo(null);
				updateParam.setTmOutBatchId(null);
				updateParamList.add(updateParam);
			}
		}
		
		if(updateParamList.size() > 0) {
			baseDao.update(SqlMapperConstants.OUT_BATCH_DELIVER_BATCH_UPDATE_PIECES_BATCH_INFO, updateParamList);
		}
	}
}
