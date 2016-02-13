package com.palette.busi.project.tms.business.receive.csmStockIn.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.palette.busi.project.tms.business.common.vo.ComUsablePiecesQueryVo;
import com.palette.busi.project.tms.business.common.vo.ComUsablePiecesResultVo;
import com.palette.busi.project.tms.business.receive.csmStockIn.dto.CsmStockInReqDto;
import com.palette.busi.project.tms.business.receive.csmStockIn.dto.CsmStockInRespDto;
import com.palette.busi.project.tms.business.receive.csmStockIn.dto.QueryStockedCsmPiecesReqDto;
import com.palette.busi.project.tms.business.receive.csmStockIn.dto.QueryStockedCsmPiecesRespDto;
import com.palette.busi.project.tms.business.receive.csmStockIn.service.CsmStockInService;
import com.palette.busi.project.tms.business.receive.csmStockIn.service.CsmStockInValidateService;
import com.palette.busi.project.tms.business.receive.csmStockIn.vo.CsmStockImportVo;
import com.palette.busi.project.tms.business.receive.csmStockIn.vo.CsmStockInCsmUpdateVo;
import com.palette.busi.project.tms.business.receive.csmStockIn.vo.CsmStockInPiecesUpdateVo;
import com.palette.busi.project.tms.business.receive.csmStockIn.vo.StockedCsmResultVo;
import com.palette.busi.project.tms.common.base.BaseController;
import com.palette.busi.project.tms.common.constant.PrintTemplateConstants;
import com.palette.busi.project.tms.common.util.BeanUtilsExt;
import com.palette.busi.project.tms.common.util.ExcelUtils;
import com.palette.busi.project.tms.common.util.PrintUtils;
import com.palette.busi.project.tms.common.util.StringUtils;
import com.palette.busi.project.tms.common.util.ThrowExp;
import com.palette.busi.project.tms.core.entity.TmConsignment;
import com.palette.busi.project.tms.core.entity.TmPieces;

@RestController
public class CsmStockInController extends BaseController {

	public static String CONTROLLER_ID = "CSM_STOCK_IN";
	
	@Autowired
	private CsmStockInService csmStockInService;
	@Autowired
	private CsmStockInValidateService csmStockInValidateService;
	
	@RequestMapping(value="/CsmStockInController/queryStockedCsmPiecesInfo")
	public QueryStockedCsmPiecesRespDto queryStockedCsmPiecesInfo(@RequestBody QueryStockedCsmPiecesReqDto reqDto) {

		ThrowExp.isNullOrEmpty(reqDto.getReferenceNo(), "操作失败。关联号不能为空");
		
		reqDto.setReferenceNo(StringUtils.toUpperAndTrim(reqDto.getReferenceNo()));
		
		// Business
		ComUsablePiecesQueryVo usablePiecesQueryVo = new ComUsablePiecesQueryVo();
		usablePiecesQueryVo.setLogisticsNo(reqDto.getReferenceNo());
		ComUsablePiecesResultVo usablePieces = servicePvd.commonPiecesService.queryUsablePieces(usablePiecesQueryVo, getSessionLinkerVo());
		
		TmConsignment tmCsm = null;
		if(usablePieces != null && usablePieces.getTmConsignmentId() != null) {
			tmCsm = querier.selectTmConsignmentById(usablePieces.getTmConsignmentId());
		}
		
		// Encapsulation result
		QueryStockedCsmPiecesRespDto respDto = new QueryStockedCsmPiecesRespDto();
		
		if(usablePieces != null) {
			BeanUtilsExt.copyProperties(usablePieces, respDto);
		}
		
		if(tmCsm != null) {
			StockedCsmResultVo stockedCsmResultVo = new StockedCsmResultVo();
			BeanUtilsExt.copyProperties(tmCsm, stockedCsmResultVo);
			respDto.setStockedCsmResultVo(stockedCsmResultVo);
		}
		
		return respDto;
	}
	
	@RequestMapping(value="/CsmStockInController/csmStockIn")
	public CsmStockInRespDto csmStockIn(@RequestBody CsmStockInReqDto reqDto) {
		
		// Validate
		csmStockInValidateService.validateCsmStockIn(reqDto);
		
		// Business 
		csmStockInService.formatCsmStockInUpdateVo(reqDto);
		
		CsmStockInCsmUpdateVo csmUpdateVo = new CsmStockInCsmUpdateVo(getSessionUserName(), CONTROLLER_ID);
		BeanUtilsExt.copyProperties(reqDto, csmUpdateVo);
		TmConsignment tmCsm = csmStockInService.insertOrUpdateCsmInfo(csmUpdateVo, getSessionLinkerVo());
		
		CsmStockInPiecesUpdateVo piecesUpdateVo = new CsmStockInPiecesUpdateVo(getSessionUserName(), CONTROLLER_ID);
		BeanUtilsExt.copyProperties(reqDto, piecesUpdateVo);
		piecesUpdateVo.setTmConsignment(tmCsm);
		TmPieces tmPieces = csmStockInService.updatePiecesInfoForStockIn(piecesUpdateVo, getSessionLinkerVo());
		
		// Encapsulation result
		CsmStockInRespDto respDto = new CsmStockInRespDto();
		respDto.setTmPiecesId(tmPieces.getTmPiecesId());
		respDto.setReferenceNo(tmPieces.getLogisticsNo());
		
		return respDto;
	}

	@RequestMapping(value="/CsmStockInController/printStockCsmImportTemplate")
	public void printStockCsmImportTemplate(HttpServletResponse response) throws FileNotFoundException, IOException {
			
		String templatePath = getServletRealPath() + PrintTemplateConstants.CS_STOCK_CSM_IMPORT_TEMPLATE;
		XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(templatePath));
		PrintUtils.excelResponseOutput(response, workbook, "StockCsmImportTemplate.xlsx");
	}
	
	@RequestMapping(value="/CsmStockInController/importStockCsmExcel")
	public boolean importStockCsmExcel(@RequestParam(value="stockCsmFile") MultipartFile file) throws Exception {
		
		// Validate
		ExcelUtils.validateImportExcel(file);
		
		// Business
		List<CsmStockImportVo> importVoList = csmStockInService.importStockCsmExcel(file);
		
		csmStockInService.concurrencyCsmStockIn(importVoList, getSessionLinkerVo());
		
		return true;
	}
}
