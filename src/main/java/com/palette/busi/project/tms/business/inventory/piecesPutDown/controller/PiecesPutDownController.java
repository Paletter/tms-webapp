package com.palette.busi.project.tms.business.inventory.piecesPutDown.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.palette.busi.project.tms.business.common.vo.ComPutPiecesDownUpdateVo;
import com.palette.busi.project.tms.business.inventory.piecesPutDown.dto.PiecesPutDownReqDto;
import com.palette.busi.project.tms.common.base.BaseController;
import com.palette.busi.project.tms.common.constant.CodeConstants;
import com.palette.busi.project.tms.common.util.StringUtils;
import com.palette.busi.project.tms.common.util.ThrowExp;
import com.palette.busi.project.tms.core.entity.TmPieces;
import com.palette.busi.project.tms.web.exception.BusinessException;

@RestController
public class PiecesPutDownController extends BaseController {

	public static String CONTROLLER_ID = "PIECES_PUT_DOWN";
	
	@RequestMapping(value="/PiecesPutDownController/piecesPutDown")
	public boolean piecesPutDown(@RequestBody PiecesPutDownReqDto reqDto) throws BusinessException {
		
		// Validate
		ThrowExp.isNullOrEmpty(reqDto.getPutDownNo(), "操作失败。下架号不能为空");
		
		String putDownNo = StringUtils.toUpperAndTrim(reqDto.getPutDownNo());
		
		TmPieces tmPiecesQuery = new TmPieces();
		tmPiecesQuery.setPiecesNo(putDownNo);
		TmPieces tmPieces = querier.selectTmPiecesOneByRecord(tmPiecesQuery);
		ThrowExp.isNull(tmPieces, "操作失败。找不到包裹信息");
		
		// Business
		ComPutPiecesDownUpdateVo comPutPiecesDownUpdateVo = new ComPutPiecesDownUpdateVo(getSessionUserName(), PiecesPutDownController.CONTROLLER_ID);
		comPutPiecesDownUpdateVo.setTmPieces(tmPieces);
		comPutPiecesDownUpdateVo.setMemo(CodeConstants.LOCATION_HITORY_MEMO_TEMPLATE.NORMAL);
		servicePvd.commonLocationService.putPiecesDownFromLocation(comPutPiecesDownUpdateVo, getSessionServiceOptParamLinkerVo());
		
		return true;
	}
}
