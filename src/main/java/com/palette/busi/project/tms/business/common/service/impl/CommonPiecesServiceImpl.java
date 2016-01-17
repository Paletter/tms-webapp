package com.palette.busi.project.tms.business.common.service.impl;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.palette.busi.project.tms.business.common.service.CommonPiecesService;
import com.palette.busi.project.tms.business.common.vo.UpdatePiecesStatusVo;
import com.palette.busi.project.tms.common.base.BaseServiceImpl;
import com.palette.busi.project.tms.common.util.BigDecimalUtils;
import com.palette.busi.project.tms.common.util.EntityUtils;
import com.palette.busi.project.tms.core.dao.TmPiecesCurrentDao;
import com.palette.busi.project.tms.core.dao.TmPiecesHistoryDao;
import com.palette.busi.project.tms.core.dao.TmPiecesRefDao;
import com.palette.busi.project.tms.core.entity.TmPieces;
import com.palette.busi.project.tms.core.entity.TmPiecesAction;
import com.palette.busi.project.tms.core.entity.TmPiecesCurrent;
import com.palette.busi.project.tms.core.entity.TmPiecesHistory;
import com.palette.busi.project.tms.core.entity.TmPiecesRef;
import com.palette.busi.project.tms.web.exception.BusinessException;

@Service
public class CommonPiecesServiceImpl extends BaseServiceImpl implements CommonPiecesService {

	@Autowired
	private TmPiecesCurrentDao tmPiecesCurrentDao;
	@Autowired
	private TmPiecesHistoryDao tmPiecesHistoryDao;
	@Autowired
	private TmPiecesRefDao tmPiecesRefDao;
	
	@Override
	public void updatePiecesStatus(UpdatePiecesStatusVo updatePiecesStatusVo) {
		
		// Query pieces action
		TmPiecesAction tmPiecesActionQuery = new TmPiecesAction();
		tmPiecesActionQuery.setActionCode(updatePiecesStatusVo.getActionCode());
		tmPiecesActionQuery.setIsActivity(1);
		TmPiecesAction tmPiecesAction = querier.selectTmPiecesActionOneByRecord(tmPiecesActionQuery);
		if(tmPiecesAction == null) throw new BusinessException("操作失败。更新包裹状态，查询不到TmPiecesAction数据");
		boolean isLogisticsAction = tmPiecesAction.getIsLogistics() == 1;
		
		// Insert or Update pieces current
		if(isLogisticsAction) {
			TmPiecesCurrent tmPiecesCurrentQuery = new TmPiecesCurrent();
			tmPiecesCurrentQuery.setTmPiecesId(updatePiecesStatusVo.getTmPiecesId());
			TmPiecesCurrent tmPiecesCurrent = querier.selectTmPiecesCurrentOneByRecord(tmPiecesCurrentQuery);
			if(tmPiecesCurrent == null) {
				tmPiecesCurrent = new TmPiecesCurrent();
				
				tmPiecesCurrent.setTmPiecesId(updatePiecesStatusVo.getTmPiecesId());
				tmPiecesCurrent.setPiecesNo(updatePiecesStatusVo.getPiecesNo());
				EntityUtils.setBasicDataForCreateEntity(tmPiecesCurrent, updatePiecesStatusVo.getUserName());
			}
			
			tmPiecesCurrent.setActionCode(updatePiecesStatusVo.getActionCode());
			tmPiecesCurrent.setMemo(updatePiecesStatusVo.getMemo());
			tmPiecesCurrent.setActionUserName(updatePiecesStatusVo.getActionUserName());
			tmPiecesCurrent.setActionDateTime(updatePiecesStatusVo.getActionDateTime());
			EntityUtils.setBasicDataForUpdateEntity(tmPiecesCurrent, updatePiecesStatusVo.getUserName());
			
			tmPiecesCurrentDao.saveTmPiecesCurrent(tmPiecesCurrent);
		}
		
		// Insert pieces history
		TmPiecesHistory tmPiecesHistory = new TmPiecesHistory();
		tmPiecesHistory.setPiecesNo(updatePiecesStatusVo.getPiecesNo());
		tmPiecesHistory.setTmPiecesId(updatePiecesStatusVo.getTmPiecesId());
		tmPiecesHistory.setActionCode(updatePiecesStatusVo.getActionCode());
		tmPiecesHistory.setMemo(updatePiecesStatusVo.getMemo());
		tmPiecesHistory.setActionUserName(updatePiecesStatusVo.getActionUserName());
		tmPiecesHistory.setActionDateTime(updatePiecesStatusVo.getActionDateTime());
		EntityUtils.setBasicDataForCreateEntity(tmPiecesHistory, updatePiecesStatusVo.getUserName());
		
		tmPiecesHistoryDao.insertTmPiecesHistory(tmPiecesHistory);
	}
	
	@Override
	public void updatePiecesRefInfo(TmPieces tmPieces, String refType, String refCode) {
		
		TmPiecesRef tmPiecesRefQuery = new TmPiecesRef();
		tmPiecesRefQuery.setTmPiecesId(tmPieces.getTmPiecesId());
		tmPiecesRefQuery.setRefType(refType);
		TmPiecesRef tmPiecesRef = querier.selectTmPiecesRefOneByRecord(tmPiecesRefQuery);
		if(tmPiecesRef == null) {
			tmPiecesRef = new TmPiecesRef();
			
			tmPiecesRef.setTmPiecesId(tmPieces.getTmPiecesId());
			tmPiecesRef.setPiecesNo(tmPieces.getPiecesNo());
			tmPiecesRef.setRefType(refType);
		}
		
		tmPiecesRef.setRefCode(refCode);
		
		tmPiecesRefDao.saveTmPiecesRef(tmPiecesRef);
	}

	@Override
	public BigDecimal getPiecesChargedWeight(TmPieces tmPieces) {
		
		BigDecimal result = BigDecimalUtils.getBiggerOrEqual(tmPieces.getActualWeight(), tmPieces.getVolumeWeight());
		return result;
	}
}
