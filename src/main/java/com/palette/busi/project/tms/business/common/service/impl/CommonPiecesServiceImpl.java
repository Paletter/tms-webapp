package com.palette.busi.project.tms.business.common.service.impl;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.palette.busi.project.tms.business.common.service.CommonPiecesService;
import com.palette.busi.project.tms.business.common.vo.ComPiecesRefUpdateVo;
import com.palette.busi.project.tms.business.common.vo.ComPiecesStatusUpdateVo;
import com.palette.busi.project.tms.business.common.vo.ComUsablePiecesResultVo;
import com.palette.busi.project.tms.business.receive.piecesStockIn.controller.PiecesStockInController;
import com.palette.busi.project.tms.common.base.BaseServiceImpl;
import com.palette.busi.project.tms.common.constant.CodeConstants;
import com.palette.busi.project.tms.common.constant.SqlMapperConstants;
import com.palette.busi.project.tms.common.util.BigDecimalUtils;
import com.palette.busi.project.tms.common.util.DateUtils;
import com.palette.busi.project.tms.common.util.StringUtils;
import com.palette.busi.project.tms.common.util.ThrowExp;
import com.palette.busi.project.tms.common.vo.ServiceOptParamLinkerVo;
import com.palette.busi.project.tms.core.dao.TmPiecesCurrentDao;
import com.palette.busi.project.tms.core.dao.TmPiecesHistoryDao;
import com.palette.busi.project.tms.core.dao.TmPiecesRefDao;
import com.palette.busi.project.tms.core.entity.TmPieces;
import com.palette.busi.project.tms.core.entity.TmPiecesAction;
import com.palette.busi.project.tms.core.entity.TmPiecesCurrent;
import com.palette.busi.project.tms.core.entity.TmPiecesHistory;
import com.palette.busi.project.tms.core.entity.TmPiecesRef;

@Service
@Transactional
public class CommonPiecesServiceImpl extends BaseServiceImpl implements CommonPiecesService {

	@Autowired
	private TmPiecesCurrentDao tmPiecesCurrentDao;
	@Autowired
	private TmPiecesHistoryDao tmPiecesHistoryDao;
	@Autowired
	private TmPiecesRefDao tmPiecesRefDao;
	
	@Override
	public ComPiecesStatusUpdateVo createPiecesStatusUpdateVo(Integer tmPiecesId, String piecesNo, String actionCode, String memo, String controllerId, ServiceOptParamLinkerVo linkerVo) {
		
		ComPiecesStatusUpdateVo updateVo = new ComPiecesStatusUpdateVo(linkerVo.getUserName(), controllerId);
		
		updateVo.setTmPiecesId(tmPiecesId);
		updateVo.setPiecesNo(piecesNo);
		updateVo.setActionCode(actionCode);
		updateVo.setActionDateTime(DateUtils.getCurrentGMTDate());
		updateVo.setActionUserName(linkerVo.getUserName());
		updateVo.setMemo(memo);
		updateVo.setUserName(linkerVo.getUserName());
		
		return updateVo;
	}
	
	@Override
	public void updatePiecesStatus(ComPiecesStatusUpdateVo updateVo) {
		
		// Query pieces action
		TmPiecesAction tmPiecesActionQuery = new TmPiecesAction();
		tmPiecesActionQuery.setActionCode(updateVo.getActionCode());
		tmPiecesActionQuery.setIsActivity(1);
		TmPiecesAction tmPiecesAction = querier.selectTmPiecesActionOneByRecord(tmPiecesActionQuery);
		ThrowExp.isNull(tmPiecesAction, "操作失败。更新包裹状态，查询不到TmPiecesAction数据");
		boolean isLogisticsAction = tmPiecesAction.getIsLogistics() == 1;
		
		// Insert or Update pieces current
		if(isLogisticsAction) {
			TmPiecesCurrent tmPiecesCurrentQuery = new TmPiecesCurrent();
			tmPiecesCurrentQuery.setTmPiecesId(updateVo.getTmPiecesId());
			TmPiecesCurrent tmPiecesCurrent = querier.selectTmPiecesCurrentOneByRecord(tmPiecesCurrentQuery);
			if(tmPiecesCurrent == null) {
				tmPiecesCurrent = new TmPiecesCurrent();
				
				tmPiecesCurrent.setTmPiecesId(updateVo.getTmPiecesId());
				tmPiecesCurrent.setPiecesNo(updateVo.getPiecesNo());
			}
			
			tmPiecesCurrent.setActionCode(updateVo.getActionCode());
			tmPiecesCurrent.setMemo(updateVo.getMemo());
			tmPiecesCurrent.setActionUserName(updateVo.getActionUserName());
			tmPiecesCurrent.setActionDateTime(updateVo.getActionDateTime());
			
			tmPiecesCurrentDao.saveTmPiecesCurrent(tmPiecesCurrent, updateVo.getUserName(), updateVo.getControllerId());
		}
		
		// Insert pieces history
		TmPiecesHistory tmPiecesHistory = new TmPiecesHistory();
		tmPiecesHistory.setPiecesNo(updateVo.getPiecesNo());
		tmPiecesHistory.setTmPiecesId(updateVo.getTmPiecesId());
		tmPiecesHistory.setActionCode(updateVo.getActionCode());
		tmPiecesHistory.setMemo(updateVo.getMemo());
		tmPiecesHistory.setActionUserName(updateVo.getActionUserName());
		tmPiecesHistory.setActionDateTime(updateVo.getActionDateTime());
		
		tmPiecesHistoryDao.insertTmPiecesHistory(tmPiecesHistory, updateVo.getUserName(), updateVo.getControllerId());
	}
	
	@Override
	public void updatePiecesRefInfo(ComPiecesRefUpdateVo updateVo) {
		
		TmPiecesRef tmPiecesRefQuery = new TmPiecesRef();
		tmPiecesRefQuery.setTmPiecesId(updateVo.getTmPiecesId());
		tmPiecesRefQuery.setRefType(updateVo.getRefType());
		TmPiecesRef tmPiecesRef = querier.selectTmPiecesRefOneByRecord(tmPiecesRefQuery);
		if(tmPiecesRef == null) {
			tmPiecesRef = new TmPiecesRef();
			
			tmPiecesRef.setTmPiecesId(updateVo.getTmPiecesId());
			tmPiecesRef.setPiecesNo(updateVo.getPiecesNo());
			tmPiecesRef.setRefType(updateVo.getRefType());
		}
		
		tmPiecesRef.setRefCode(updateVo.getRefCode());
		tmPiecesRef.setRefId(updateVo.getRefId());
		
		tmPiecesRefDao.saveTmPiecesRef(tmPiecesRef, updateVo.getUserName(), updateVo.getControllerId());
	}

	@Override
	public BigDecimal getPiecesChargedWeight(TmPieces tmPieces) {
		
		BigDecimal result = BigDecimalUtils.getBiggerOrEqual(tmPieces.getActualWeight(), tmPieces.getVolumeWeight());
		return result;
	}
	
	@Override
	public ComUsablePiecesResultVo queryUsablePieces(String piecesNo, ServiceOptParamLinkerVo linkerVo) {
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("piecesNo", piecesNo);
		params.put("warehouseCode", linkerVo.getWarehouseCode());
		ComUsablePiecesResultVo resultVo = selectOne(SqlMapperConstants.BUSINESS_COMMON_CALL_GET_USABLE_PIECES_SP, params);
		return resultVo;
	}
}
