package com.palette.busi.project.tms.business.delivery.packGoods.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.palette.busi.project.tms.business.common.vo.ComPiecesStatusUpdateVo;
import com.palette.busi.project.tms.business.common.vo.ComPutPiecesDownUpdateVo;
import com.palette.busi.project.tms.business.delivery.packGoods.controller.PackGoodsController;
import com.palette.busi.project.tms.business.delivery.packGoods.dto.PackPiecesInUnitReqDto;
import com.palette.busi.project.tms.business.delivery.packGoods.dto.PackPiecesOutUnitReqDto;
import com.palette.busi.project.tms.business.delivery.packGoods.service.PackGoodsService;
import com.palette.busi.project.tms.common.base.BaseServiceImpl;
import com.palette.busi.project.tms.common.constant.CodeConstants;
import com.palette.busi.project.tms.common.constant.SqlMapperConstants;
import com.palette.busi.project.tms.common.util.DateUtils;
import com.palette.busi.project.tms.common.vo.ServiceOptParamLinkerVo;
import com.palette.busi.project.tms.core.dao.TmPiecesDao;
import com.palette.busi.project.tms.core.entity.TmPieces;
import com.palette.busi.project.tms.core.entity.TmUnit;

@Service
@Transactional
public class PackGoodsServiceImpl extends BaseServiceImpl implements PackGoodsService {

	@Autowired
	private TmPiecesDao tmPiecesDao;
	
	@Override
	public TmPieces updatePiecesInfoForPackIn(PackPiecesInUnitReqDto reqDto, ServiceOptParamLinkerVo linkerVo) {
		
		// Update pieces
		TmPieces tmPiecesQuery = new TmPieces();
		tmPiecesQuery.setPiecesNo(reqDto.getPackNo());
		TmPieces tmPieces = querier.selectTmPiecesOneByRecord(tmPiecesQuery);
		TmUnit tmUnit = reqDto.getTmUnit();
		tmPieces.setTmSectorId(tmUnit.getTmSectorId());
		tmPieces.setSectorCode(tmUnit.getSectorCode());
		tmPieces.setUnitNo(tmUnit.getUnitNo());
		tmPieces.setTmUnitId(tmUnit.getTmUnitId());
		tmPiecesDao.updateTmPieces(tmPieces, linkerVo.getUserName(), PackGoodsController.CONTROLLER_ID);
		
		// Update pieces current and history
		ComPiecesStatusUpdateVo piecesStatusUpdateVo = createPackInUpdatePiecesStatusVo(tmPieces, linkerVo);
		servicePvd.commonPiecesService.updatePiecesStatus(piecesStatusUpdateVo);
		
		// Update pieces put down from loc
		ComPutPiecesDownUpdateVo putPiecesDownUpdateVo = new ComPutPiecesDownUpdateVo(linkerVo.getUserName(), PackGoodsController.CONTROLLER_ID);
		putPiecesDownUpdateVo.setTmPieces(tmPieces);
		putPiecesDownUpdateVo.setMemo(CodeConstants.LOCATION_HITORY_MEMO_TEMPLATE.PACK_AUTO_DOWN);
		servicePvd.commonLocationService.putPiecesDownFromLocation(putPiecesDownUpdateVo, linkerVo);
		
		return tmPieces;
	}
	
	private ComPiecesStatusUpdateVo createPackInUpdatePiecesStatusVo(TmPieces tmPieces, ServiceOptParamLinkerVo linkerVo) {
		
		ComPiecesStatusUpdateVo updateVo = new ComPiecesStatusUpdateVo(linkerVo.getUserName(), PackGoodsController.CONTROLLER_ID);
		
		updateVo.setTmPiecesId(tmPieces.getTmPiecesId());
		updateVo.setPiecesNo(tmPieces.getPiecesNo());
		updateVo.setActionCode(CodeConstants.PIECES_ACTION.PK);
		updateVo.setActionDateTime(DateUtils.getCurrentGMTDate());
		updateVo.setActionUserName(linkerVo.getUserName());
		updateVo.setMemo("打包货物");
		updateVo.setUserName(linkerVo.getUserName());
		return updateVo;
	}
	
	@Override
	public TmPieces updatePiecesInfoForPackOut(PackPiecesOutUnitReqDto reqDto, ServiceOptParamLinkerVo linkerVo) {
		
		// Update pieces
		TmPieces tmPiecesQuery = new TmPieces();
		tmPiecesQuery.setPiecesNo(reqDto.getPackNo());
		TmPieces tmPieces = querier.selectTmPiecesOneByRecord(tmPiecesQuery);
		
		Map<String, Object> updatePiecesParam = new HashMap<String, Object>();
		updatePiecesParam.put("tmUnitId", null);
		updatePiecesParam.put("unitNo", null);
		updatePiecesParam.put("tmSectorId", null);
		updatePiecesParam.put("sectorCode", null);
		updatePiecesParam.put("piecesNo", tmPieces.getPiecesNo());
		baseDao.update(SqlMapperConstants.PACK_GOODS_UPDATE_PIECES_UNIT_INFO, updatePiecesParam);
		
		// Update pieces current and history
		ComPiecesStatusUpdateVo piecesStatusUpdateVo = createPackOutUpdatePiecesStatusVo(tmPieces, linkerVo);
		servicePvd.commonPiecesService.updatePiecesStatus(piecesStatusUpdateVo);
		
		return tmPieces;
	}

	private ComPiecesStatusUpdateVo createPackOutUpdatePiecesStatusVo(TmPieces tmPieces, ServiceOptParamLinkerVo linkerVo) {
		
		ComPiecesStatusUpdateVo updateVo = new ComPiecesStatusUpdateVo(linkerVo.getUserName(), PackGoodsController.CONTROLLER_ID);
		
		updateVo.setTmPiecesId(tmPieces.getTmPiecesId());
		updateVo.setPiecesNo(tmPieces.getPiecesNo());
		updateVo.setActionCode(CodeConstants.PIECES_ACTION.CP);
		updateVo.setActionDateTime(DateUtils.getCurrentGMTDate());
		updateVo.setActionUserName(linkerVo.getUserName());
		updateVo.setMemo("取消打包");
		updateVo.setUserName(linkerVo.getUserName());
		return updateVo;
	}
}
