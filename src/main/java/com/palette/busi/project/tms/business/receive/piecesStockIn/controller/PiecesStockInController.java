package com.palette.busi.project.tms.business.receive.piecesStockIn.controller;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.palette.busi.project.tms.business.receive.piecesStockIn.dto.PiecesStockInReqDto;
import com.palette.busi.project.tms.business.receive.piecesStockIn.dto.PiecesStockInRespDto;
import com.palette.busi.project.tms.business.receive.piecesStockIn.dto.QueryStockedPiecesReqDto;
import com.palette.busi.project.tms.business.receive.piecesStockIn.dto.QueryStockedPiecesRespDto;
import com.palette.busi.project.tms.business.receive.piecesStockIn.service.PiecesStockInPrintService;
import com.palette.busi.project.tms.business.receive.piecesStockIn.service.PiecesStockInService;
import com.palette.busi.project.tms.business.receive.piecesStockIn.service.PiecesStockInValidateService;
import com.palette.busi.project.tms.common.base.BaseController;
import com.palette.busi.project.tms.common.util.BeanUtilsExt;
import com.palette.busi.project.tms.common.util.PrintUtils;
import com.palette.busi.project.tms.common.util.StringUtils;
import com.palette.busi.project.tms.common.util.ThrowExp;
import com.palette.busi.project.tms.core.entity.TmPieces;

@RestController
public class PiecesStockInController extends BaseController {

	public static String CONTROLLER_ID = "PIECES_STOCK_IN";
	
	@Autowired
	private PiecesStockInService piecesStockInService;
	@Autowired
	private PiecesStockInPrintService piecesStockInPrintService;
	@Autowired
	private PiecesStockInValidateService piecesStockInValidateService;
	
	@RequestMapping(value="/PiecesStockInController/queryStockedPiecesInfo")
	public QueryStockedPiecesRespDto queryStockedPiecesInfo(@RequestBody QueryStockedPiecesReqDto reqDto) {

		ThrowExp.isNullOrEmpty(reqDto.getLogisticsNo(), "操作失败。物流号不能为空");
		
		reqDto.setLogisticsNo(StringUtils.toUpperAndTrim(reqDto.getLogisticsNo()));
		
		// Business
		TmPieces tmPieces = piecesStockInService.queryCanStockInPiecesInfoByLogisticNo(reqDto.getLogisticsNo());
		
		// Encapsulation result
		QueryStockedPiecesRespDto respDto = new QueryStockedPiecesRespDto();
		if(tmPieces != null) {
			BeanUtilsExt.copyPropertiesIgnoreDefault(tmPieces, respDto);
		}
		
		return respDto;
	}
	
	@RequestMapping(value="/PiecesStockInController/unconsignedPiecesStockIn")
	public PiecesStockInRespDto unconsignedPiecesStockIn(@RequestBody PiecesStockInReqDto reqDto) {
		
		// Validate
		piecesStockInValidateService.validateUnconsignedPiecesStockIn(reqDto);
		
		piecesStockInService.formatPiecesStockInUpdateVo(reqDto);
		
		// Business
		TmPieces updatePieces = piecesStockInService.updatePiecesInfoForStockIn(reqDto, getSessionServiceOptParamLinkerVo());
		
		// Encapsulation result
		PiecesStockInRespDto respDto = new PiecesStockInRespDto();
		BeanUtilsExt.copyPropertiesIgnoreDefault(updatePieces, respDto);
		return respDto;
	}
	
	@RequestMapping(value="/PiecesStockInController/consignedPiecesStockIn")
	public PiecesStockInRespDto consignedPiecesStockIn(@RequestBody PiecesStockInReqDto reqDto) throws Exception {
		
		piecesStockInService.formatPiecesStockInUpdateVo(reqDto);
		
		// Validate
		piecesStockInValidateService.validateNormalPiecesStockIn(reqDto);
		
		// Business
		TmPieces updatePieces = piecesStockInService.updatePiecesInfoForStockIn(reqDto, getSessionServiceOptParamLinkerVo());
		
		// Encapsulation result
		PiecesStockInRespDto respDto = new PiecesStockInRespDto();
		BeanUtilsExt.copyPropertiesIgnoreDefault(updatePieces, respDto);
		return respDto;
	}
	
	@RequestMapping(value="/PiecesStockInController/printPiecesStorageLabel")
	public void printPiecesStorageLabel(HttpServletResponse response) throws Exception {
		
		Integer tmPiecesId = Integer.valueOf(request.getParameter("tmPiecesId"));
		TmPieces tmPieces = querier.selectTmPiecesById(tmPiecesId);
		
		XSSFWorkbook workbook = piecesStockInPrintService.createPiecesStorageLabel(getServletRealPath(), tmPieces, getSessionServiceOptParamLinkerVo());
		
		PrintUtils.labelResponseOutput(response, workbook, new String(tmPieces.getPiecesNo() + "-StorageLable.xlsx"));
	}
}
	
