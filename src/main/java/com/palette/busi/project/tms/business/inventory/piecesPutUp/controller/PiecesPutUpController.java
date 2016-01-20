package com.palette.busi.project.tms.business.inventory.piecesPutUp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.palette.busi.project.tms.business.common.vo.ComPiecesPutUpUpdateVo;
import com.palette.busi.project.tms.business.inventory.piecesPutUp.service.PiecesPutUpService;
import com.palette.busi.project.tms.business.inventory.piecesPutUp.vo.LocationInfoResultVo;
import com.palette.busi.project.tms.business.inventory.piecesPutUp.vo.PiecesPutUpUpdateVo;
import com.palette.busi.project.tms.common.base.BaseController;
import com.palette.busi.project.tms.common.constant.CodeConstants;
import com.palette.busi.project.tms.common.util.StringUtils;
import com.palette.busi.project.tms.common.util.ThrowExp;
import com.palette.busi.project.tms.core.entity.TmPieces;
import com.palette.busi.project.tms.core.entity.WmLocation;
import com.palette.busi.project.tms.core.entity.WmLocationCurrent;
import com.palette.busi.project.tms.web.exception.BusinessException;

@RestController
public class PiecesPutUpController extends BaseController {

	public static String CONTROLLER_ID = "PIECES_PUT_UP";
	
	@Autowired 
	private PiecesPutUpService piecesPutUpService;

	@RequestMapping(value="/PiecesPutUpController/queryLocationInfo")
	public LocationInfoResultVo queryLocationInfo(@RequestParam(value="locCode") String locCode) throws BusinessException {
		
		// Business
		ThrowExp.isNullOrEmpty(locCode, "操作失败。库位号不能为空");
		
		locCode = StringUtils.toUpperAndTrim(locCode);
		
		WmLocation wmLocationQuery = new WmLocation();
		wmLocationQuery.setLocationCode(locCode);
		wmLocationQuery.setWarehouseCode(getSessionWarehouseCode());
		WmLocation wmLocation = querier.selectWmLocationOneByRecord(wmLocationQuery);
		
		ThrowExp.isNull(wmLocation, "操作失败。库位信息不存在");
		
		WmLocationCurrent wmLocationCurrentQuery = new WmLocationCurrent();
		wmLocationCurrentQuery.setWmLocationId(wmLocation.getWmLocationId());
		List<WmLocationCurrent> wmLocationCurrentList = querier.selectWmLocationCurrentAllByRecord(wmLocationCurrentQuery);
		
		// Encapsulation result
		LocationInfoResultVo locationInfoResultVo = new LocationInfoResultVo();
		locationInfoResultVo.setWmLocation(wmLocation);
		locationInfoResultVo.setWmLocationCurrentList(wmLocationCurrentList);
		return locationInfoResultVo;
	}
	
	@RequestMapping(value="/PiecesPutUpController/piecesPutUp")
	public boolean piecesPutUp(@RequestBody PiecesPutUpUpdateVo piecesPutUpUpdateVo) throws BusinessException {
		
		// Validate
		ThrowExp.isNull(piecesPutUpUpdateVo.getWmLocation() == null, "操作失败。库位信息不能为空");
		ThrowExp.isNullOrEmpty(piecesPutUpUpdateVo.getPutUpNo(), "操作失败。上架号不能为空");
		
		TmPieces tmPiecesQuery = new TmPieces();
		tmPiecesQuery.setPiecesNo(piecesPutUpUpdateVo.getPutUpNo());
		TmPieces tmPieces = querier.selectTmPiecesOneByRecord(tmPiecesQuery);
		ThrowExp.isNull(tmPieces, "操作失败。找不到包裹信息");
		
		// Business
		ComPiecesPutUpUpdateVo comPiecesPutUpUpdateVo = new ComPiecesPutUpUpdateVo(getSessionUserName(), PiecesPutUpController.CONTROLLER_ID);
		comPiecesPutUpUpdateVo.setTmPieces(tmPieces);
		comPiecesPutUpUpdateVo.setWmLocation(piecesPutUpUpdateVo.getWmLocation());
		comPiecesPutUpUpdateVo.setMemo(CodeConstants.LOCATION_HITORY_MEMO_TEMPLATE.NORMAL);
		comPiecesPutUpUpdateVo.setUserName(getSessionUserName());
		servicePvd.commonLocationService.piecesPutUpToLocation(comPiecesPutUpUpdateVo, getSessionServiceOptParamLinkerVo());
		
		return true;
	}
	
}
