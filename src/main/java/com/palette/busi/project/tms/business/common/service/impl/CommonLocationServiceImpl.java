package com.palette.busi.project.tms.business.common.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.palette.busi.project.tms.business.common.service.CommonLocationService;
import com.palette.busi.project.tms.business.common.vo.ComPiecesPutUpUpdateVo;
import com.palette.busi.project.tms.common.base.BaseServiceImpl;
import com.palette.busi.project.tms.common.constant.CodeConstants;
import com.palette.busi.project.tms.common.constant.SqlMapperConstants;
import com.palette.busi.project.tms.common.util.DateUtils;
import com.palette.busi.project.tms.common.vo.ServiceOptParamLinkerVo;
import com.palette.busi.project.tms.core.dao.WmLocationCurrentDao;
import com.palette.busi.project.tms.core.dao.WmLocationHistoryDao;
import com.palette.busi.project.tms.core.entity.TmPieces;
import com.palette.busi.project.tms.core.entity.WmLocation;
import com.palette.busi.project.tms.core.entity.WmLocationCurrent;
import com.palette.busi.project.tms.core.entity.WmLocationHistory;

@Service
public class CommonLocationServiceImpl extends BaseServiceImpl implements CommonLocationService {

	@Autowired
	private WmLocationCurrentDao wmLocationCurrentDao;
	@Autowired
	private WmLocationHistoryDao wmLocationHistoryDao;
	
	@Override
	public void piecesPutUpToLocation(ComPiecesPutUpUpdateVo updateVo, ServiceOptParamLinkerVo paramLinkerVo) {
		
		WmLocation wmLocation = updateVo.getWmLocation();
		TmPieces tmPieces = updateVo.getTmPieces();
		
		// 1 Delete piecesno loction current data
		delete(SqlMapperConstants.BUSINESS_COMMON_DELETE_PIECES_NO_LOCATION_CURRENT, tmPieces.getPiecesNo());
		
		// 2 Insert new wmlocationcurrent
		WmLocationCurrent wmLocationCurrent = new WmLocationCurrent();
		wmLocationCurrent.setWmLocationId(wmLocation.getWmLocationId());
		wmLocationCurrent.setLocationCode(wmLocation.getLocationCode());
		wmLocationCurrent.setWarehouseCode(wmLocation.getWarehouseCode());
		wmLocationCurrent.setTmPiecesId(tmPieces.getTmPiecesId());
		wmLocationCurrent.setPiecesNo(tmPieces.getPiecesNo());
		wmLocationCurrent.setTmConsignmentId(tmPieces.getTmConsignmentId());
		wmLocationCurrent.setConsignmentNo(tmPieces.getConsignmentNo());
		wmLocationCurrent.setMemo(updateVo.getMemo());
		wmLocationCurrent.setCreateUserCode(paramLinkerVo.getUserName());
		wmLocationCurrent.setCreateDateTime(DateUtils.getCurrentGMTDate());
		wmLocationCurrentDao.insertWmLocationCurrent(wmLocationCurrent, updateVo.getUserName(), updateVo.getControllerId());
		
		// 3 Insert location history
		WmLocationHistory wmLocationHistory = new WmLocationHistory();
		wmLocationHistory.setWmLocationId(wmLocation.getWmLocationId());
		wmLocationHistory.setLocationCode(wmLocation.getLocationCode());
		wmLocationHistory.setWarehouseCode(wmLocation.getWarehouseCode());
		wmLocationHistory.setTmPiecesId(tmPieces.getTmPiecesId());
		wmLocationHistory.setPiecesNo(tmPieces.getPiecesNo());
		wmLocationHistory.setTmConsignmentId(tmPieces.getTmConsignmentId());
		wmLocationHistory.setConsignmentNo(tmPieces.getConsignmentNo());
		wmLocationHistory.setActionCode(CodeConstants.LOCATION_HITORY_ACTION_CODE.PUT_UP);
		wmLocationHistory.setMemo(updateVo.getMemo());
		wmLocationHistory.setCreateUserCode(updateVo.getUserName());
		wmLocationHistory.setCreateDateTime(DateUtils.getCurrentGMTDate());
		wmLocationHistoryDao.insertWmLocationHistory(wmLocationHistory, updateVo.getUserName(), updateVo.getControllerId());
	}
	
}
