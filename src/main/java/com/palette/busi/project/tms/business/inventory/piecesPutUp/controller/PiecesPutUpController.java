package com.palette.busi.project.tms.business.inventory.piecesPutUp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.palette.busi.project.tms.business.common.vo.ComPutPiecesUpUpdateVo;
import com.palette.busi.project.tms.business.inventory.piecesPutUp.dto.PiecesPutUpReqDto;
import com.palette.busi.project.tms.business.inventory.piecesPutUp.dto.QueryLocationInfoRespDto;
import com.palette.busi.project.tms.business.inventory.piecesPutUp.service.PiecesPutUpService;
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
	public QueryLocationInfoRespDto queryLocationInfo(@RequestParam(value="locCode") String locCode) {

		// Validate
		ThrowExp.isNullOrEmpty(locCode, "操作失败。库位号不能为空");
		
		// Business
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
		QueryLocationInfoRespDto respDto = new QueryLocationInfoRespDto();
		respDto.setWmLocation(wmLocation);
		respDto.setWmLocationCurrentList(wmLocationCurrentList);
		return respDto;
	}
	
	@RequestMapping(value="/PiecesPutUpController/piecesPutUp")
	public boolean piecesPutUp(@RequestBody PiecesPutUpReqDto reqDto) throws BusinessException {
		
		// Validate
		ThrowExp.isNull(reqDto.getWmLocation() == null, "操作失败。库位信息不能为空");
		ThrowExp.isNullOrEmpty(reqDto.getPutUpNo(), "操作失败。上架号不能为空");
		
		TmPieces tmPiecesQuery = new TmPieces();
		tmPiecesQuery.setPiecesNo(reqDto.getPutUpNo());
		TmPieces tmPieces = querier.selectTmPiecesOneByRecord(tmPiecesQuery);
		ThrowExp.isNull(tmPieces, "操作失败。找不到包裹信息");
		
		// Business
		ComPutPiecesUpUpdateVo comPiecesPutUpUpdateVo = new ComPutPiecesUpUpdateVo(getSessionUserName(), PiecesPutUpController.CONTROLLER_ID);
		comPiecesPutUpUpdateVo.setTmPieces(tmPieces);
		comPiecesPutUpUpdateVo.setWmLocation(reqDto.getWmLocation());
		comPiecesPutUpUpdateVo.setMemo(CodeConstants.LOCATION_HITORY_MEMO_TEMPLATE.NORMAL);
		comPiecesPutUpUpdateVo.setUserName(getSessionUserName());
		servicePvd.commonLocationService.putPiecesUpToLocation(comPiecesPutUpUpdateVo, getSessionServiceOptParamLinkerVo());
		
		return true;
	}
	
}
