package com.palette.busi.project.tms.business.receive.piecesStockIn.controller;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.palette.busi.project.tms.business.receive.piecesStockIn.service.PiecesStockInPrintService;
import com.palette.busi.project.tms.business.receive.piecesStockIn.service.PiecesStockInService;
import com.palette.busi.project.tms.business.receive.piecesStockIn.service.PiecesStockInValidateService;
import com.palette.busi.project.tms.business.receive.piecesStockIn.vo.PiecesStockInResultVo;
import com.palette.busi.project.tms.business.receive.piecesStockIn.vo.PiecesStockInUpdateVo;
import com.palette.busi.project.tms.business.receive.piecesStockIn.vo.StockedPiecesQueryParamVo;
import com.palette.busi.project.tms.business.receive.piecesStockIn.vo.StockedPiecesResultVo;
import com.palette.busi.project.tms.common.base.BaseController;
import com.palette.busi.project.tms.common.util.BeanUtilsExt;
import com.palette.busi.project.tms.common.util.PrintUtils;
import com.palette.busi.project.tms.core.entity.TmPieces;

@RestController
public class PiecesStockInController extends BaseController {

	@Autowired
	private PiecesStockInService piecesStockInService;
	@Autowired
	private PiecesStockInPrintService piecesStockInPrintService;
	@Autowired
	private PiecesStockInValidateService piecesStockInValidateService;
	
	@RequestMapping(value="/PiecesStockInController/queryStockedPiecesInfo")
	public StockedPiecesResultVo queryStockedPiecesInfo(@RequestBody StockedPiecesQueryParamVo queryParamVo) {

		String logisticsNo = queryParamVo.getLogisticsNo().toUpperCase().replaceAll(" ", "");
		
		// Business
		TmPieces tmPieces = piecesStockInService.queryCanStockInPiecesInfoByLogisticNo(logisticsNo);
		
		// Encapsulation result
		StockedPiecesResultVo resultVo = new StockedPiecesResultVo();
		if(tmPieces != null) {
			BeanUtilsExt.copyPropertiesIgnoreDefault(tmPieces, resultVo);
		}
		return resultVo;
	}
	
	@RequestMapping(value="/PiecesStockInController/unconsignedPiecesStockIn")
	public PiecesStockInResultVo unconsignedPiecesStockIn(@RequestBody PiecesStockInUpdateVo piecesStockInUpdateVo) {
		
		// Validate
		piecesStockInValidateService.validateUnconsignedPiecesStockIn(piecesStockInUpdateVo);
		
		piecesStockInService.formatPiecesStockInUpdateVo(piecesStockInUpdateVo);
		
		// Business
		TmPieces updatePieces = piecesStockInService.updatePiecesInfoForStockIn(piecesStockInUpdateVo, getSessionServiceOptParamLinkerVo());
		
		// Encapsulation result
		PiecesStockInResultVo resultVo = new PiecesStockInResultVo();
		BeanUtilsExt.copyPropertiesIgnoreDefault(updatePieces, resultVo);
		return resultVo;
	}
	
	@RequestMapping(value="/PiecesStockInController/consignedPiecesStockIn")
	public PiecesStockInResultVo consignedPiecesStockIn(@RequestBody PiecesStockInUpdateVo piecesStockInUpdateVo) throws Exception {
		
		piecesStockInService.formatPiecesStockInUpdateVo(piecesStockInUpdateVo);
		
		// Validate
		piecesStockInValidateService.validateNormalPiecesStockIn(piecesStockInUpdateVo);
		
		// Business
		TmPieces updatePieces = piecesStockInService.updatePiecesInfoForStockIn(piecesStockInUpdateVo, getSessionServiceOptParamLinkerVo());
		
		// Encapsulation result
		PiecesStockInResultVo resultVo = new PiecesStockInResultVo();
		BeanUtilsExt.copyPropertiesIgnoreDefault(updatePieces, resultVo);
		return resultVo;
	}
	
	@RequestMapping(value="/PiecesStockInController/printPiecesStorageLabel")
	public void printPiecesStorageLabel(HttpServletResponse response) throws Exception {
		
		Integer tmPiecesId = Integer.valueOf(request.getParameter("tmPiecesId"));
		TmPieces tmPieces = querier.selectTmPiecesById(tmPiecesId);
		
		XSSFWorkbook workbook = piecesStockInPrintService.createPiecesStorageLabel(getServletRealPath(), tmPieces, getSessionServiceOptParamLinkerVo());
		
		PrintUtils.labelResponseOutput(response, workbook, new String(tmPieces.getPiecesNo() + "-StorageLable.xlsx"));
	}
}
	
